package controllers;

import database.DataServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddStudentController extends HttpServlet {

    DataServices services = new DataServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession();
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/JSP/student_add.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession();

        String first_name = req.getParameter("first_name");
        String second_name = req.getParameter("second_name");
        String group = req.getParameter("group");
        String date = req.getParameter("date");

        if (first_name.length() > 0) {
            if (second_name.length() > 0) {
                if (group.length() > 0) {
                    if (date.length() > 0) {
                        services.addStudent(first_name, second_name, group, date);
                        req.getRequestDispatcher("/WEB-INF/JSP/student_add.jsp").forward(req, resp);
                    } else {
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/JSP/error.jsp");
                        dispatcher.forward(req, resp);
                    }
                } else {
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/JSP/error.jsp");
                    dispatcher.forward(req, resp);
                }
            } else {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/JSP/error.jsp");
                dispatcher.forward(req, resp);
            }
        } else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/JSP/error.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
