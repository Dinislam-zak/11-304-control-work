package ru.kpfu.itis.zakirov.controlwork11304.dao.impl;

import ru.kpfu.itis.zakirov.controlwork11304.dao.AttemptDao;
import ru.kpfu.itis.zakirov.controlwork11304.entity.Attempt;
import ru.kpfu.itis.zakirov.controlwork11304.util.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AttemptDaoImpl implements AttemptDao {
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    public Attempt get(Integer id) {
        try {
            String sql = "select * from attempts where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    return new Attempt(
                            resultSet.getInt("id"),
                            resultSet.getString("login"),
                            resultSet.getTimestamp("time").toLocalDateTime(),
                            resultSet.getBoolean("attempt")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Attempt getByLogin(String login) {
        try {
            String sql = "select * from attempts where login = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    return new Attempt(
                            resultSet.getInt("id"),
                            resultSet.getString("login"),
                            resultSet.getTimestamp("time").toLocalDateTime(),
                            resultSet.getBoolean("attempt")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Attempt> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "select * from attempts";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Attempt> attempts = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()){
                    attempts.add(
                            new Attempt(
                                    resultSet.getInt("id"),
                                    resultSet.getString("login"),
                                    resultSet.getTimestamp("time").toLocalDateTime(),
                                    resultSet.getBoolean("attempt")
                            )
                    );
                }
            }
            return attempts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Attempt attempt) {
        String sql = "insert into attempts (login, time, attempt) values (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, attempt.getLogin());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(attempt.getTime()));
            preparedStatement.setBoolean(3, attempt.getAttemptStatus());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
