package com.janosSuli.holidayRegister.dao.inMemory;

import com.janosSuli.holidayRegister.dao.WorkerDao;
import com.janosSuli.holidayRegister.model.WorkerModel;

import java.util.ArrayList;
import java.util.List;

public class WorkerDaoInMemory implements WorkerDao {

    private List<WorkerModel> workerList = new ArrayList<>();
    private int nextWorkerId = 1;

    public WorkerDaoInMemory() {
    }

    @Override
    public void add(WorkerModel worker) {

        worker.setWorkerID(nextWorkerId);
        workerList.add(worker);
        nextWorkerId += 1;

    }

    @Override
    public void modifyWorker(WorkerModel editedWorker) {

        for (WorkerModel worker: workerList) {
            if (worker.getWorkerID() == editedWorker.getWorkerID()) {
                worker.setName(editedWorker.getName());
                worker.setEmail(editedWorker.getEmail());
                worker.setWorkPlace(editedWorker.getWorkPlace());
                worker.setPosition(editedWorker.getPosition());
                worker.setStatus(editedWorker.getStatus());
                worker.setHolidayInAYear(editedWorker.getHolidayInAYear());
                worker.setRemainHoliday(editedWorker.getRemainHoliday());
            }
        }

    }

    @Override
    public WorkerModel findByID(int ID) {

        for (WorkerModel worker: workerList) {
            if (worker.getWorkerID() == ID) {
                return worker;
            }
        }

        return new WorkerModel();

    }

    @Override
    public List<WorkerModel> findByName(String name) {

        List<WorkerModel> resultWorkerList = new ArrayList<>();

        for (WorkerModel worker: workerList) {
            if (worker.getName().toLowerCase().contains(name.toLowerCase()) && !name.equals("")) {
                resultWorkerList.add(worker);
            }
        }

        return resultWorkerList;

    }

    @Override
    public List<WorkerModel> findByEmail(String email) {

        List<WorkerModel> resultWorkerList = new ArrayList<>();

        for (WorkerModel worker: workerList) {
            if (worker.getEmail().toLowerCase().contains(email.toLowerCase()) && !email.equals("")) {
                resultWorkerList.add(worker);
            }
        }

        return resultWorkerList;

    }

    @Override
    public List<WorkerModel> findByWorkplace(String workPlace) {

        List<WorkerModel> resultWorkerList = new ArrayList<>();

        for (WorkerModel worker: workerList) {
            if (worker.getWorkPlace().toLowerCase().contains(workPlace.toLowerCase()) && !workPlace.equals("")) {
                resultWorkerList.add(worker);
            }
        }

        return resultWorkerList;

    }

    @Override
    public List<WorkerModel> findByPosition(String position) {

        List<WorkerModel> resultWorkerList = new ArrayList<>();

        for (WorkerModel worker: workerList) {
            if (worker.getPosition().toLowerCase().contains(position.toLowerCase()) && !position.equals("")) {
                resultWorkerList.add(worker);
            }
        }

        return resultWorkerList;

    }

    @Override
    public List<WorkerModel> findByStatus(String status) {

        List<WorkerModel> resultWorkerList = new ArrayList<>();

        for (WorkerModel worker: workerList) {
            if (worker.getStatus().toLowerCase().contains(status.toLowerCase()) && !status.equals("")) {
                resultWorkerList.add(worker);
            }
        }

        return resultWorkerList;

    }

    @Override
    public List<WorkerModel> getAll() {
        return workerList;
    }

}
