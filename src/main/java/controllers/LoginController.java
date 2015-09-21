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

public class LoginController extends AbstractServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataServices services = new DataServices();
        List<Role> roles = services.loadRoles();
        req.setAttribute("roles", roles);
        goToJsp("login.jsp",req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataServices services = new DataServices();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        int idRole = Integer.parseInt(req.getParameter("role"));

        Users user = services.getUserDataByLogin(login);

        if (user.getId() == 0){
            this.goToErrorPageWithMessage("login is not valide", req, resp);
        }
        List<Role> roles = services.getUserRoleByUserId(user.getId());
        if (user.getLogin().equals(login)){
            if (user.getPassword().equals(password)){
                    for (Role role : roles) {
                    if (role.getId() == idRole) {
                        HttpSession session = req.getSession();
                        session.setAttribute("role",idRole);
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/JSP/home.jsp");
                        dispatcher.forward(req,resp);
                    } else {
                        this.goToErrorPageWithMessage( "role is not valide", req, resp);
                    }
                }
            } else {
               this.goToErrorPageWithMessage("password is not valide", req, resp);
            }
        }


    }
}
