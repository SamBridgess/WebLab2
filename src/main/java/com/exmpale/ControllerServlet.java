import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            float x = Float.parseFloat(req.getParameter("x"));
            float y = Float.parseFloat(req.getParameter("y"));
            String[] rs = req.getParameterValues("r");
            float[] rf = new float[rs.length];
            for (int i = 0; i < rs.length; i++) {
                rf[i] = Float.parseFloat(rs[i]);
            }
            getServletContext().getNamedDispatcher("areacheck").forward(req, resp);
        } catch (NumberFormatException e) {
            resp.sendError(400, "Invalid params");
        }
    }
}
