package com.exmpale;

import com.exmpale.models.AttemptsManager;
import com.google.gson.Gson;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="attemptslist")
public class AttemptsListServlet extends HttpServlet {
    @Inject
    private AttemptsManager am;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson g = new Gson();
        resp.getWriter().print(g.toJson(am.getResults()));
    }
}
