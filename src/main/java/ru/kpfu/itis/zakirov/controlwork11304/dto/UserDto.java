package ru.kpfu.itis.zakirov.controlwork11304.dto;

public class UserDto {
    private String login;
    private String password;
    public UserDto(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}