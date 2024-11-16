package ru.kpfu.itis.zakirov.controlwork11304.dao;

import ru.kpfu.itis.zakirov.controlwork11304.entity.User;

import java.util.List;

public interface UserDao {

    User get(Integer id);

    List<User> getAll();

    User getByLogin(String login);

    void save(User user);
}