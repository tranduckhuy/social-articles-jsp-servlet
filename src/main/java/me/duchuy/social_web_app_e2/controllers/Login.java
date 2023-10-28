package me.duchuy.social_web_app_e2.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import me.duchuy.social_web_app_e2.dao.UserDAOImpl;
import me.duchuy.social_web_app_e2.utils.Encode;

/**
 *
 * @author ADMIN
 */

@WebServlet(name = "login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String uId = (String) session.getAttribute("uId");
        
        if (uId != null) {
            response.sendRedirect("list-article?page=1");
        } else {
            request.getRequestDispatcher("views/index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        password = Encode.toSHA256(password);
        
        UserDAOImpl userDao = new UserDAOImpl();
        String uId = userDao.isValidUser(email, password);

        if (uId != null) {
            HttpSession session = request.getSession();
            session.setAttribute("uId", uId);
            response.sendRedirect("list-article?page=1");
        } else {
            request.setAttribute("error", "Incorrect email or password. Please try again.");
            request.getRequestDispatcher("views/index.jsp").forward(request, response);
        }
        
    }


}
