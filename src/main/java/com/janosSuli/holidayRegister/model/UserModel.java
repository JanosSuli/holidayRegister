package com.janosSuli.holidayRegister.model;

import org.mindrot.jbcrypt.BCrypt;

public class UserModel {

    private String name;
    private String password;

    public UserModel() {
        this.name = "";
        this.password = "";
    }

    public UserModel(String name, String password) {
        this.name = name;
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
