package com.janosSuli.holidayRegister.controller;

import com.janosSuli.holidayRegister.dao.DataImplementationManager;
import com.janosSuli.holidayRegister.dao.UserDao;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao userDao = DataImplementationManager.getUserDao();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String loginError = "Username or Password is incorrect. Please try again.";

        if (userDao.find(userName, password).getName().equals(userName) &&
                BCrypt.checkpw(password, userDao.find(userName, password).getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("userName", userName);
            response.sendRedirect("/welcomeBoard");
        } else {
            request.setAttribute("loginError", loginError);
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }
}
