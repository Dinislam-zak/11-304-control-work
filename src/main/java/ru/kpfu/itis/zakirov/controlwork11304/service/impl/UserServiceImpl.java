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
    public UserLoginDto getUserLoginDto(String login) {
        User user = userDao.getByLogin(login);
        return new UserLoginDto(
                user.getLogin(),
                user.getPassword()
        );
    }

    @Override
    public UserDto get(Integer id) {
        User user = userDao.get(id);
        return new UserDto(
                user.getName(),
                user.getLogin()
        );
    }

    @Override
    public UserDto getByLogin(String login) {
        User user = userDao.getByLogin(login);
        return new UserDto(
                user.getName(),
                user.getLogin()
        );
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userDao.getAll();
        return users.stream()
                .map(u -> new UserDto(u.getName(), u.getLogin()))
                .toList();
    }

    @Override
    public void register(String name, String login, String password) {
        userDao.save(
                new User(
                        null,
                        name,
                        login,
                        PasswordUtil.encrypt(password)
                )
        );
    }
}