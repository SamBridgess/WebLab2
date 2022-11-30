package com.exmpale;

import com.exmpale.models.AttemptsManager;
import com.exmpale.models.PointRequest;
import com.exmpale.models.PointResult;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="areacheck")
public class AreaCheckServlet extends HttpServlet {
    @Inject
    private AttemptsManager am;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PointRequest pr = (PointRequest) req.getAttribute("pr");

        StringBuilder redirectPath = new StringBuilder();
        redirectPath.append(getServletContext().getContextPath());
        redirectPath.append("/view_results?");

        for (int i = 0; i < pr.getRSize(); i++) {
            long startTime = System.nanoTime();
            boolean result;

            if (pr.getX() >= 0) {
                if (pr.getY() >= 0) {
                    result = pr.getY() <= pr.getR(i) / 2 - pr.getX();
                } else {
                    result = (pr.getX() <= pr.getR(i)) & (pr.getY() >= -pr.getR(i));
                }
            } else {
                if (pr.getY() >= 0) {
                    result = (pr.getR(i) / 2.0f) * (pr.getR(i) / 2.0f) >= (pr.getX() * pr.getX() + pr.getY() * pr.getY());
                } else {
                    result = false;
                }
            }

            PointResult attempt = new PointResult(
                    pr.getX(),
                    pr.getY(),
                    pr.getR(i),
                    result,
                    System.currentTimeMillis(),
                    (System.nanoTime() - startTime) / 1000d
            );
            redirectPath.append("results=");
            redirectPath.append(am.getResults().size());
            if (i < pr.getRSize() - 1) redirectPath.append('&');
            am.addResult(attempt);
        }

        resp.sendRedirect(redirectPath.toString());
    }
}
