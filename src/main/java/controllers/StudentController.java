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

public class StudentController extends HttpServlet{
    DataServices services = new DataServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession();
        List<Students> studentsList = services.loadStudents();
        req.setAttribute("studentList", studentsList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/JSP/student_list.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession();
        String[] check = req.getParameterValues("checkboxStudents");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/JSP/student_creating.jsp");
        dispatcher.forward(req,resp);
    }
}
