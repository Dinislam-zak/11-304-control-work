package ru.kpfu.itis.zakirov.controlwork11304.service;


import ru.kpfu.itis.zakirov.controlwork11304.dto.UserDto;
import ru.kpfu.itis.zakirov.controlwork11304.dto.UserLoginDto;

import java.util.List;


public interface UserService {

    UserLoginDto getUserLoginDto(String login);

    List<UserDto> getAll();

    UserDto get(Integer id);

    UserDto getByLogin(String login);

    void register(String name, String login, String password);
}
