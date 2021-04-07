package com.janosSuli.holidayRegister.controller;

import com.janosSuli.holidayRegister.dao.DataImplementationManager;
import com.janosSuli.holidayRegister.dao.WorkerDao;
import com.janosSuli.holidayRegister.model.WorkerModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchBoardController", value = "/searchBoard")
public class SearchBoardController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        WorkerDao workerDao = DataImplementationManager.getWorkerDao();
        List<WorkerModel> workerList = workerDao.getAll();

        request.setAttribute("worker", workerList);
        getServletContext().getRequestDispatcher("/searchBoard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        WorkerDao workerDao = DataImplementationManager.getWorkerDao();

        request.setCharacterEncoding("UTF-8");
        String searchOption = request.getParameter("searchOption");
        String searchInput = request.getParameter("searchInput");
        String searchError = "No results found! Please try again!";

        switch (searchOption) {
            case "Name": {
                if (!workerDao.findByName(searchInput).isEmpty()) {
                    searchForwarding(workerDao.findByName(searchInput), request, response);
                } else {
                    request.setAttribute("searchError", searchError);
                    getServletContext().getRequestDispatcher("/searchBoard.jsp").forward(request, response);
                }
                break;
            }
            case "E-mail": {
                if (!workerDao.findByEmail(searchInput).isEmpty()) {
                    searchForwarding(workerDao.findByEmail(searchInput), request, response);
                } else {
                    request.setAttribute("searchError", searchError);
                    getServletContext().getRequestDispatcher("/searchBoard.jsp").forward(request, response);
                }
                break;
            }
            case "Workplace": {
                if (!workerDao.findByWorkplace(searchInput).isEmpty()) {
                    searchForwarding(workerDao.findByWorkplace(searchInput), request, response);
                } else {
                    request.setAttribute("searchError", searchError);
                    getServletContext().getRequestDispatcher("/searchBoard.jsp").forward(request, response);
                }
                break;
            }
            case "Position": {
                if (!workerDao.findByPosition(searchInput).isEmpty()) {
                    searchForwarding(workerDao.findByPosition(searchInput), request, response);
                } else {
                    request.setAttribute("searchError", searchError);
                    getServletContext().getRequestDispatcher("/searchBoard.jsp").forward(request, response);
                }
                break;
            }
            case "Status": {
                if (!workerDao.findByStatus(searchInput).isEmpty()) {
                    searchForwarding(workerDao.findByStatus(searchInput), request, response);
                } else {
                    request.setAttribute("searchError", searchError);
                    getServletContext().getRequestDispatcher("/searchBoard.jsp").forward(request, response);
                }
                break;
            }
        }

    }

    private void searchForwarding(List<WorkerModel> workerModelList,
                                  HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("worker", workerModelList);
        getServletContext().getRequestDispatcher("/searchBoard.jsp").forward(request, response);

    }

}
