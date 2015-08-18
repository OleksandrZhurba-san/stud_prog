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

public class StudentController extends AbstractServlet{
    DataServices services = new DataServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession();
        List<Students> studentsList = services.loadStudents();
        req.setAttribute("studentList", studentsList);
        goToJsp("student_list.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getSession();
//        String[] check = req.getParameterValues("checkboxStudents");
//        for (int i = 0; i < check.length; i++) {
//
//        }
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/JSP/student_creating.jsp");
//        dispatcher.forward(req,resp);
    }
}
