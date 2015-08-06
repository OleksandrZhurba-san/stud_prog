package controllers;

import database.DataServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DisciplineController extends HttpServlet {
    DataServices services = new DataServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession();
        List<String> discipline = services.loadDiscipline();
        req.setAttribute("discipline", discipline);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/JSP/discipline.jsp");
        dispatcher.forward(req,resp);
    }
}
