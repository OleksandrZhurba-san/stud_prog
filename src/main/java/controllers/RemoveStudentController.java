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
import java.util.StringTokenizer;

public class RemoveStudentController extends AbstractServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataServices dataServices = new DataServices();
        List<Students> students = dataServices.loadStudents();
        req.setAttribute("studentList", students);
        goToJsp("student_list.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataServices dataServices = new DataServices();
        String ids = req.getParameter("ids");

        StringTokenizer tokenizer = new StringTokenizer(ids, ", ");
        while (tokenizer.hasMoreTokens()){
           int id =  Integer.parseInt(tokenizer.nextToken());
            dataServices.removeStudent(id);
        }

       List<Students> students = dataServices.loadStudents();
        req.setAttribute("studentList", students);
        goToJsp("student_list.jsp", req, resp);
    }
}
