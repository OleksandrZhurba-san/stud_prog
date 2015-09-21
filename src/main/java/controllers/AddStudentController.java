package controllers;

import database.DataServices;
import entity.Students;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddStudentController extends AbstractServlet {

    DataServices services = new DataServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        goToJsp("student_add.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String first_name = req.getParameter("first_name");
        String second_name = req.getParameter("second_name");
        String group = req.getParameter("group");
        String date = req.getParameter("date");

        if (!isBlank(first_name)) {
            if (!isBlank(second_name)) {
                if (!isBlank(group)) {
                    if (!isBlank(date)) {
                        services.addStudent(first_name, second_name, group, date);
                        List<Students> studentsList = services.loadStudents();
                        req.setAttribute("studentList", studentsList);
                        goToJsp("student_list.jsp", req, resp);
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
