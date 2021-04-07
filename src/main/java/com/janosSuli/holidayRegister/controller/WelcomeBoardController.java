package com.janosSuli.holidayRegister.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "WelcomeBoardController", value = "/welcomeBoard")
public class WelcomeBoardController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/welcomeBoard.jsp").forward(request, response);

    }

}
