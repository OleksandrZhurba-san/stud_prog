package controllers;

import database.DataServices;
import entity.Role;
import entity.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LoginController extends HttpServlet {

    DataServices services = new DataServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Role> roles = services.loadRoles();
        req.setAttribute("roles", roles);
        req.getRequestDispatcher("/WEB-INF/JSP/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        int idRole = Integer.parseInt(req.getParameter("role"));

        Users user = services.getUserDataByLogin(login);

        if (user.getId() == 0){
            req.setAttribute("messageError","Login is not valid");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/JSP/validationMessage.jsp");
            dispatcher.forward(req,resp);
        }
        List<Role> roles = services.getUserRoleByUserId(user.getId());
        if (user.getLogin().equals(login)){
            if (user.getPassword().equals(password)){
                for (Role role : roles) {
                    if (role.getId() == idRole) {
                        HttpSession session = req.getSession();
                        session.setAttribute("login",login);
                        session.setMaxInactiveInterval(500);
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/JSP/home.jsp");
                        dispatcher.forward(req,resp);
                    }
                }
                req.setAttribute("messageError", "role is not valide");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/JSP/validationMessage.jsp");
                dispatcher.forward(req, resp);
            } else {
                req.setAttribute("messageError", "login is not valid");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/JSP/validationMessage.jsp");
                dispatcher.forward(req, resp);
            }
        }


    }
}
