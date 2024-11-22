package ru.kpfu.itis.zakirov.controlwork11304.service;

import ru.kpfu.itis.zakirov.controlwork11304.dto.AttemptDto;
import ru.kpfu.itis.zakirov.controlwork11304.dto.UserLoginDto;

import java.util.List;

public interface AttemptService {


    List<AttemptDto> getAll();

    AttemptDto get(Integer id);

    AttemptDto getByLogin(String login);

    void registerAttempt(String login, Boolean status);
}
