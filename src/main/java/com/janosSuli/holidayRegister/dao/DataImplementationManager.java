package com.janosSuli.holidayRegister.dao;

public class DataImplementationManager {

    private static final DataImplementationTypes dataImplementationType = DataImplementationTypes.DATABASE;
    private static final DaoImplementationSupplier daoImplementationSupplier = DaoImplementationSupplier.getInstance(dataImplementationType);
    private static final UserDao userDao = daoImplementationSupplier.getUserDao();
    private static final WorkerDao workerDao = daoImplementationSupplier.getWorkerDao();

    public static DaoImplementationSupplier getDaoImplementationSupplier() {
        return daoImplementationSupplier;
    }

    public static UserDao getUserDao() {
        return userDao;
    }

    public static WorkerDao getWorkerDao() {
        return workerDao;
    }
}
