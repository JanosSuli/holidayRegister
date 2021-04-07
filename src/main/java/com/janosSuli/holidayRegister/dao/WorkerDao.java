package com.janosSuli.holidayRegister.dao;

import com.janosSuli.holidayRegister.model.WorkerModel;

import java.util.List;

public interface WorkerDao {

    void add(WorkerModel worker);
    void modifyWorker(WorkerModel editedWorker);
    WorkerModel findByID(int ID);
    List<WorkerModel> findByName(String name);
    List<WorkerModel> findByEmail(String email);
    List<WorkerModel> findByWorkplace(String workPlace);
    List<WorkerModel> findByPosition(String position);
    List<WorkerModel> findByStatus(String status);
    List<WorkerModel> getAll();

}
