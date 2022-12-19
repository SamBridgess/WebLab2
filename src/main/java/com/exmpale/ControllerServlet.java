package com.exmpale;

import com.exmpale.models.AttemptsManager;
import com.exmpale.models.PointRequest;
import com.exmpale.models.PointResult;
import com.exmpale.utils.RequestParser;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/")
public class ControllerServlet extends HttpServlet {
    @Inject
    private AttemptsManager am;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestedResource = req.getRequestURI().substring(getServletContext().getContextPath().length());

        if (requestedResource.equals("/attempts")) {
            getServletContext().getNamedDispatcher("attemptslist").forward(req, resp);
        } else if (requestedResource.equals("/clean")) {
            am.clear();
            resp.sendRedirect(getServletContext().getContextPath());
        } else if (requestedResource.startsWith("/view_results")) {
            String[] requestedResults = req.getParameterValues("results");
            PointResult[] results = new PointResult[requestedResults.length];
            boolean failed = false;

            for (int i = 0; i < requestedResults.length; i++) {
                try {
                    results[i] = am.getResults().get(Integer.parseInt(requestedResults[i]));
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    failed = true;
                    resp.sendError(400, "Invalid params");
                    break;
                }
            }

            if (!failed) {
                req.setAttribute("results", results);
                getServletContext().getRequestDispatcher("/results.jsp").forward(req, resp);
            }
        } else if (requestedResource.equals("/")) {
            getServletContext().getRequestDispatcher("/main.jsp").forward(req, resp);
        } else {
            getServletContext().getNamedDispatcher("default").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PointRequest pr = RequestParser.getPointRequest(req);
        if (pr != null) {
            req.setAttribute("pr", pr);
            getServletContext().getNamedDispatcher("areacheck").forward(req, resp);
        } else {
            resp.sendError(400, "Invalid params");
        }
    }
}
