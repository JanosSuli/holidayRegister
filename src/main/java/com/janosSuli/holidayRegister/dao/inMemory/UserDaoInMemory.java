package com.janosSuli.holidayRegister.dao.inMemory;

import com.janosSuli.holidayRegister.dao.UserDao;
import com.janosSuli.holidayRegister.model.UserModel;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

public class UserDaoInMemory implements UserDao {

    private List<UserModel> userList = new ArrayList<>();

    {
        userList.add(new UserModel("Janika", "janika"));
    }

    public UserDaoInMemory() {
    }

    @Override
    public void add(UserModel user) {
        userList.add(user);
    }

    @Override
    public UserModel find(String userName, String password) {

        for (UserModel user: userList) {
            if (user.getName().equals(userName) && BCrypt.checkpw(password, user.getPassword())) {

                return user;
            }
        }

        return new UserModel();
    }
}
