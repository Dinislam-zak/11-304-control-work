package ru.kpfu.itis.zakirov.controlwork11304.entity;

import java.time.LocalDateTime;

public class Attempt {

    private Integer id;

    private String login;

    private LocalDateTime time;

    private Boolean attemptStatus;

    public Attempt(Integer id, String login, LocalDateTime time, Boolean attemptStatus) {
        this.id = id;
        this.login = login;
        this.time = time;
        this.attemptStatus = attemptStatus;
    }

    public Attempt(String login, LocalDateTime time, Boolean attemptStatus) {
        this.login = login;
        this.time = time;
        this.attemptStatus = attemptStatus;
    }

    public String getLogin() {
        return login;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Boolean getAttemptStatus() {
        return attemptStatus;
    }

}
