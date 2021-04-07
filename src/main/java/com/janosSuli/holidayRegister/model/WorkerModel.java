package com.janosSuli.holidayRegister.model;

public class WorkerModel {

    private int workerID;
    private String name;
    private String email;
    private String workPlace;
    private String position;
    private String status;
    private int holidayInAYear;
    private int usedHoliday;
    private int remainHoliday;

    public WorkerModel() {
        this.workerID = 0;
        this.name = "";
        this.email = "";
        this.workPlace = "";
        this.position = "";
        this.status = "";
        this.holidayInAYear = 0;
        this.usedHoliday = 0;
        this.remainHoliday = 0;
    }

    public WorkerModel(String name, String email, String workPlace, String position, String status, int holidayInAYear, int usedHoliday) {
        this.name = name;
        this.email = email;
        this.workPlace = workPlace;
        this.position = position;
        this.status = status;
        this.holidayInAYear = holidayInAYear;
        this.usedHoliday = usedHoliday;
        this.remainHoliday = this.holidayInAYear - this.usedHoliday;
    }

    public int getWorkerID() {
        return workerID;
    }

    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHolidayInAYear() {
        return holidayInAYear;
    }

    public void setHolidayInAYear(int holidayInAYear) {
        this.holidayInAYear = holidayInAYear;
    }

    public int getUsedHoliday() {
        return usedHoliday;
    }

    public void setUsedHoliday(int usedHoliday) {
        this.usedHoliday = usedHoliday;
        remainHoliday = holidayInAYear - usedHoliday;
    }

    public int getRemainHoliday() {
        return remainHoliday;
    }

    public void setRemainHoliday(int remainHoliday) {
        this.remainHoliday = remainHoliday;
    }
}
