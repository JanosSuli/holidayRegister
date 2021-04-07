package com.janosSuli.holidayRegister.dao;

import com.janosSuli.holidayRegister.model.UserModel;

public interface UserDao {

    void add(UserModel user);
    UserModel find(String userName, String password);

}
