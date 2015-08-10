package controllers;

import database.DataServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddDisciplineController extends HttpServlet {

    DataServices services = new DataServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession();
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/JSP/discipline_add.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession();
        String discipline = req.getParameter("discipline");

        if (discipline.length() > 0) {
            services.addDiscipline(discipline);
            req.getRequestDispatcher("/WEB-INF/JSP/discipline.jsp").forward(req,resp);
        } else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/JSP/error.jsp");
            dispatcher.forward(req,resp);
        }
    }
}
