package com.janosSuli.holidayRegister.controller;

import com.janosSuli.holidayRegister.dao.DataImplementationManager;
import com.janosSuli.holidayRegister.dao.WorkerDao;
import com.janosSuli.holidayRegister.model.WorkerModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddBoardController", value = "/addBoard")
public class AddBoardController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        WorkerDao workerDao = DataImplementationManager.getWorkerDao();
        List<WorkerModel> workerList = workerDao.getAll();

        request.setAttribute("worker", workerList);
        getServletContext().getRequestDispatcher("/addBoard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        WorkerDao workerDao = DataImplementationManager.getWorkerDao();

        request.setCharacterEncoding("UTF-8");
        workerDao.add(new WorkerModel(
                request.getParameter("addName"),
                request.getParameter("addEmail"),
                request.getParameter("addWorkPlace"),
                request.getParameter("addPosition"),
                request.getParameter("addStatus"),
                Integer.parseInt(request.getParameter("addHolidayInAYear")),
                Integer.parseInt(request.getParameter("addUsedHoliday"))));
        response.sendRedirect("/addBoard");
    }
}
