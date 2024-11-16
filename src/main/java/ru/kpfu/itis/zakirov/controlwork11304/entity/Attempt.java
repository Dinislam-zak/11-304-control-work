package ru.kpfu.itis.zakirov.controlwork11304.entity;

import java.time.LocalDateTime;

public class Attempt {

    private int id;

    private String login;

    private LocalDateTime time;

    private boolean attempt;

    public Attempt(int id, String login, LocalDateTime time, boolean attempt) {
        this.id = id;
        this.login = login;
        this.time = time;
        this.attempt = attempt;
    }

    public Attempt(String login, LocalDateTime time, boolean attempt) {
        this.login = login;
        this.time = time;
        this.attempt = attempt;
    }

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public boolean getAttempt() {
        return attempt;
    }
}
