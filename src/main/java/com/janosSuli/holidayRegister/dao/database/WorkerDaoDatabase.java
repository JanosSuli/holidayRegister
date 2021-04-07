package com.janosSuli.holidayRegister.dao.database;

import com.janosSuli.holidayRegister.dao.WorkerDao;
import com.janosSuli.holidayRegister.model.WorkerModel;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class WorkerDaoDatabase implements WorkerDao {

    private final DataSource dataSource;

    public WorkerDaoDatabase(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(WorkerModel worker) {

        try (Connection connection = dataSource.getConnection()) {

            String sql = "INSERT INTO workers (name, email, workplace, position, status, holidayinayear, usedholiday) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, worker.getName());
            preparedStatement.setString(2, worker.getEmail());
            preparedStatement.setString(3, worker.getWorkPlace());
            preparedStatement.setString(4, worker.getPosition());
            preparedStatement.setString(5, worker.getStatus());
            preparedStatement.setInt(6, worker.getHolidayInAYear());
            preparedStatement.setInt(7, worker.getUsedHoliday());
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public void modifyWorker(WorkerModel editedWorker) {

        try (Connection connection = dataSource.getConnection()) {

            String sql = "UPDATE workers SET name = ?, email = ?, workplace = ?, position = ?, status = ?, holidayinayear = ?, usedholiday = ? WHERE worker_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, editedWorker.getName());
            preparedStatement.setString(2, editedWorker.getEmail());
            preparedStatement.setString(3, editedWorker.getWorkPlace());
            preparedStatement.setString(4, editedWorker.getPosition());
            preparedStatement.setString(5, editedWorker.getStatus());
            preparedStatement.setInt(6, editedWorker.getHolidayInAYear());
            preparedStatement.setInt(7, editedWorker.getUsedHoliday());
            preparedStatement.setInt(8, editedWorker.getWorkerID());
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new NoSuchElementException();
        }

    }

    @Override
    public WorkerModel findByID(int ID) {

        try (Connection connection = dataSource.getConnection()) {

            String sql = "SELECT * FROM workers where worker_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, ID);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            WorkerModel worker = getWorkerModel(resultSet);

            return worker;

        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new NoSuchElementException();
        }

    }

    @Override
    public List<WorkerModel> findByName(String name) {

        List<WorkerModel> workerList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {

            String sql = "SELECT * FROM workers WHERE LOWER(name) like ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, "%" + name.toLowerCase() + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                WorkerModel worker = getWorkerModel(resultSet);
                workerList.add(worker);
            }

            return workerList;

        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new NoSuchElementException();
        }

    }

    @Override
    public List<WorkerModel> findByEmail(String email) {

        List<WorkerModel> workerList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {

            String sql = "SELECT * FROM workers WHERE LOWER(email) like ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, "%" + email.toLowerCase() + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                WorkerModel worker = getWorkerModel(resultSet);
                workerList.add(worker);
            }

            return workerList;

        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new NoSuchElementException();
        }
    }

    @Override
    public List<WorkerModel> findByWorkplace(String workPlace) {

        List<WorkerModel> workerList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {

            String sql = "SELECT * FROM workers WHERE LOWER(workplace) like ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, "%" + workPlace.toLowerCase() + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                WorkerModel worker = getWorkerModel(resultSet);
                workerList.add(worker);
            }

            return workerList;

        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new NoSuchElementException();
        }

    }

    @Override
    public List<WorkerModel> findByPosition(String position) {

        List<WorkerModel> workerList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {

            String sql = "SELECT * FROM workers WHERE LOWER(position) like ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, "%" + position.toLowerCase() + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                WorkerModel worker = getWorkerModel(resultSet);
                workerList.add(worker);
            }

            return workerList;

        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new NoSuchElementException();
        }

    }

    @Override
    public List<WorkerModel> findByStatus(String status) {

        List<WorkerModel> workerList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {

            String sql = "SELECT * FROM workers WHERE LOWER(status) like ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, "%" + status.toLowerCase() + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                WorkerModel worker = getWorkerModel(resultSet);
                workerList.add(worker);
            }

            return workerList;

        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new NoSuchElementException();
        }

    }

    @Override
    public List<WorkerModel> getAll() {
        List<WorkerModel> workerList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {

            String sql = "SELECT * FROM workers";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                WorkerModel worker = getWorkerModel(resultSet);
                workerList.add(worker);
            }

            return workerList;

        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new NoSuchElementException();
        }

    }

    private WorkerModel getWorkerModel(ResultSet resultSet) throws SQLException {

        WorkerModel worker = new WorkerModel(resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getString(5),
                resultSet.getString(6),
                resultSet.getInt(7),
                resultSet.getInt(8));
        worker.setWorkerID(resultSet.getInt(1));

        return worker;

    }
}
