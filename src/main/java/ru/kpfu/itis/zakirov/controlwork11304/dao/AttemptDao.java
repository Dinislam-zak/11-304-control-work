package ru.kpfu.itis.zakirov.controlwork11304.dao;

import ru.kpfu.itis.zakirov.controlwork11304.entity.Attempt;
import ru.kpfu.itis.zakirov.controlwork11304.entity.User;

import java.util.List;

public interface AttemptDao {
    Attempt get(Integer id);

    List<Attempt> getAll();

    Attempt getByLogin(String login);

    void save(Attempt attempt);
}
