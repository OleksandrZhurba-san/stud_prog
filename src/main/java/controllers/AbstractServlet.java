package controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by workstation on 18.08.2015.
 */
public class AbstractServlet extends HttpServlet {

    protected void goToErrorPageWithMessage(String message, HttpServletRequest req, HttpServletResponse resp){
        req.setAttribute("messageError", message);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/JSP/error.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void goToJsp(String page, HttpServletRequest req, HttpServletResponse resp){
        req.setAttribute("currentPage", page);
        try {
            req.getRequestDispatcher("/WEB-INF/JSP/home.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected boolean isBlank(String parameter){
        if (parameter == null || parameter.equals("") ){
            return true;
        }else{
            return false;
        }
    }
}
