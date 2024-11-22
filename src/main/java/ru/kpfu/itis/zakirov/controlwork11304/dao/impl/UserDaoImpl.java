package ru.kpfu.itis.zakirov.controlwork11304.dao.impl;

import ru.kpfu.itis.zakirov.controlwork11304.dao.UserDao;
import ru.kpfu.itis.zakirov.controlwork11304.entity.User;
import ru.kpfu.itis.zakirov.controlwork11304.util.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    public User get(Integer id) {
        try {
            String sql = "select * from users where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet != null) {
                resultSet.next();
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("password")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public User getByLogin(String login) {
        try {
            String sql = "select * from users where login = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    return new User(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("login"),
                            resultSet.getString("password")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "select * from users";
            ResultSet resultSet = statement.executeQuery(sql);
            List<User> users = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()){
                    users.add(
                            new User(
                                    resultSet.getInt("id"),
                                    resultSet.getString("name"),
                                    resultSet.getString("login"),
                                    resultSet.getString("password")
                            )
                    );
                }
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(User user) {
        String sql = "insert into users (name, login, password) values (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
