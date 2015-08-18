package controllers;

import database.DataServices;
import entity.Discipline;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DisciplineController extends AbstractServlet {
    DataServices services = new DataServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Discipline> discipline = services.loadDiscipline();
        req.setAttribute("discipline", discipline);
        goToJsp("discipline.jsp", req, resp);
    }
}
