package com.janosSuli.holidayRegister.dao.database;

import com.janosSuli.holidayRegister.dao.UserDao;
import com.janosSuli.holidayRegister.model.UserModel;

import javax.sql.DataSource;
import java.sql.*;

public class UserDaoDatabase implements UserDao {

    private final DataSource dataSource;

    public UserDaoDatabase(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(UserModel user) {

        try (Connection connection = dataSource.getConnection()) {

            String sql = "INSERT INTO users (name, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public UserModel find(String userName, String password) {

        try (Connection connection = dataSource.getConnection()) {

            UserModel user = new UserModel();
            String sql = "SELECT * FROM users WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user.setName(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));

            return user;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return new UserModel();

    }
}
