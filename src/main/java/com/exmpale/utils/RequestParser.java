package com.exmpale.utils;

import com.exmpale.models.PointRequest;
import jakarta.servlet.http.HttpServletRequest;

public class RequestParser {
    public static PointRequest getPointRequest(HttpServletRequest req) {
        try {
            float x = Float.parseFloat(req.getParameter("x"));
            float y = Float.parseFloat(req.getParameter("y"));
            String[] rs = req.getParameterValues("r");
            float[] rf = new float[rs.length];
            for (int i = 0; i < rs.length; i++) {
                rf[i] = Float.parseFloat(rs[i]);
                System.out.println(i);
            }

            return new PointRequest(x, y, rf);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
