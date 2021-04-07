package com.janosSuli.holidayRegister.controller;

import com.janosSuli.holidayRegister.dao.DataImplementationManager;
import com.janosSuli.holidayRegister.dao.WorkerDao;
import com.janosSuli.holidayRegister.model.WorkerModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditBoardController", value = "/editBoard")
public class EditBoardController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        WorkerDao workerDao = DataImplementationManager.getWorkerDao();
        WorkerModel editedWorker = workerDao.findByID(Integer.parseInt(request.getParameter("workerID")));

        request.setAttribute("editedWorker", editedWorker);
        getServletContext().getRequestDispatcher("/editBoard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        WorkerDao workerDao = DataImplementationManager.getWorkerDao();
        WorkerModel editedWorker = workerDao.findByID(Integer.parseInt(request.getParameter("hiddenWorkerID")));
        String error = "Please fill all input box";

        request.setCharacterEncoding("UTF-8");
        if (request.getParameter("modifyWorkPlace").equals("Please choose a workplace") ||
                request.getParameter("modifyPosition").equals("Please choose a position") ||
                request.getParameter("modifyStatus").equals("Please choose a status")) {
            request.setAttribute("error", error);
        } else {
            editedWorker.setName(request.getParameter("modifyName"));
            editedWorker.setEmail(request.getParameter("modifyEmail"));
            editedWorker.setWorkPlace(request.getParameter("modifyWorkPlace"));
            editedWorker.setPosition(request.getParameter("modifyPosition"));
            editedWorker.setStatus(request.getParameter("modifyStatus"));
            editedWorker.setHolidayInAYear(Integer.parseInt(request.getParameter("modifyHolidayInAYear")));
            editedWorker.setUsedHoliday(Integer.parseInt(request.getParameter("modifyUsedHoliday")));
            workerDao.modifyWorker(editedWorker);
        }
        request.setAttribute("editedWorker", editedWorker);
        getServletContext().getRequestDispatcher("/editBoard.jsp").forward(request, response);


    }
}
