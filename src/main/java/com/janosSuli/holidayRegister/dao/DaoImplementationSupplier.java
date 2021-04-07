package com.janosSuli.holidayRegister.dao;

import com.janosSuli.holidayRegister.dao.database.UserDaoDatabase;
import com.janosSuli.holidayRegister.dao.database.WorkerDaoDatabase;
import com.janosSuli.holidayRegister.dao.inMemory.UserDaoInMemory;
import com.janosSuli.holidayRegister.dao.inMemory.WorkerDaoInMemory;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

public class DaoImplementationSupplier {

    private final UserDao userDao;
    private final WorkerDao workerDao;

    public DaoImplementationSupplier(UserDao userDao, WorkerDao workerDao) {
        this.userDao = userDao;
        this.workerDao = workerDao;
    }

    public static DaoImplementationSupplier getInstance(DataImplementationTypes daoTypes) {

        if (daoTypes == DataImplementationTypes.DATABASE) {
            DataSource dataSource = createDateSource();

            return new DaoImplementationSupplier(new UserDaoDatabase(dataSource),
                    new WorkerDaoDatabase(dataSource));
        }
        return new DaoImplementationSupplier(new UserDaoInMemory(),
                new WorkerDaoInMemory());

    }

    public UserDao getUserDao() {
        return userDao;
    }

    public WorkerDao getWorkerDao() {
        return workerDao;
    }

    private static PGSimpleDataSource createDateSource() {

        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUser("postgres");
        dataSource.setPassword("darkhunter");
        dataSource.setDatabaseName("holidayRegisterDatabase");

        return dataSource;

    }
}
