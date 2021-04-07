package com.janosSuli.holidayRegister.controller;

import com.janosSuli.holidayRegister.dao.DataImplementationManager;
import com.janosSuli.holidayRegister.dao.UserDao;
import com.janosSuli.holidayRegister.model.UserModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao userDao = DataImplementationManager.getUserDao();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String registrationError = "Password does not match the confirm password. Please try again!";

        if (password.equals(confirmPassword)) {
            userDao.add(new UserModel(userName, password));
            response.sendRedirect("/login");
        } else {
            request.setAttribute("RegistrationError", registrationError);
            getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
        }

    }
}
