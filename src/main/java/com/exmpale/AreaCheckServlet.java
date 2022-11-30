import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="areacheck")
public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float x = Float.parseFloat(req.getParameter("x"));
        float y = Float.parseFloat(req.getParameter("y"));
        String[] rs = req.getParameterValues("r");
        float[] rf = new float[rs.length];
        for (int i = 0; i < rs.length; i++) {
            rf[i] = Float.parseFloat(rs[i]);
        }

        boolean[] res = new boolean[rf.length];

        for (int i = 0; i < res.length; i++) {
            if (x >= 0) {
                if (y >= 0) {
                    res[i] = y <= rf[i] / 2 - x;
                } else {
                    res[i] = (x <= rf[i]) & (y >= -rf[i]);
                }
            } else {
                if (y >= 0) {
                    res[i] = (rf[i] / 2.0f)*(rf[i] / 2.0f) >= (x*x + y*y);
                } else {
                    res[i] = false;
                }
            }
        }
    }
}
