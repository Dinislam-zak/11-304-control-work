package ru.kpfu.itis.zakirov.controlwork11304.service.impl;

import ru.kpfu.itis.zakirov.controlwork11304.dao.UserDao;
import ru.kpfu.itis.zakirov.controlwork11304.dao.impl.UserDaoImpl;
import ru.kpfu.itis.zakirov.controlwork11304.dto.UserDto;
import ru.kpfu.itis.zakirov.controlwork11304.dto.UserLoginDto;
import ru.kpfu.itis.zakirov.controlwork11304.entity.User;
import ru.kpfu.itis.zakirov.controlwork11304.service.UserService;
import ru.kpfu.itis.zakirov.controlwork11304.util.PasswordUtil;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoImpl();

    @Override
    public List<UserDto> getAll() {
        return userDao.getAll().stream().map(
                u -> new UserDto(u.getLogin(), null)
        ).collect(Collectors.toList());
    }

    @Override
    public UserDto get(Integer id) {
        return null;
    }

    @Override
    public UserDto getByLogin(String login) {
        User u = userDao.getByLogin(login);
        return new UserDto(u.getLogin(), null);
    }

    @Override
    public void register(UserLoginDto user) {
        userDao.save(new User(
                user.getLogin(),
                PasswordUtil.encrypt(user.getPassword())
        ));
    }
}