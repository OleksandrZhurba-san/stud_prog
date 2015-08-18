package controllers;

import database.DataServices;
import entity.Discipline;
import entity.Students;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddDisciplineController extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        goToJsp("discipline_add.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataServices services = new DataServices();
        String discipline = req.getParameter("discipline");

        if (discipline.length() > 0) {
            services.addDiscipline(discipline);
            List<Discipline> disciplines = services.loadDiscipline();

            req.setAttribute("disciplines", disciplines);
            goToJsp("discipline.jsp", req, resp);
        } else {
            goToErrorPageWithMessage("input is blank!!!", req, resp);
        }
    }
}
