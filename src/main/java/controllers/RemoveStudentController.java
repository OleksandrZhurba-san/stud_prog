package controllers;

import database.DataServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveStudentController extends HttpServlet{
    DataServices services = new DataServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession();

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/JSP/student_list.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession();
        String[] ids = req.getParameterValues("ids");
        int[] userId = new int[ids.length];

        for (int i = 0; i < ids.length; i++){
            userId[i] = Integer.getInteger(ids[i]);
        }
        services.removeStudent(userId);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/JSP/student_list.jsp");
        dispatcher.forward(req,resp);
    }
}
