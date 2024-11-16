package ru.kpfu.itis.zakirov.controlwork11304.dto;

import java.time.LocalDateTime;

public class AttemptDto {

    private String login;

    private LocalDateTime time;

    private boolean attempt;

    public AttemptDto(String login, LocalDateTime time, boolean attempt) {
        this.login = login;
        this.time = time;
        this.attempt = attempt;
    }

    public String getLogin() {
        return login;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public boolean getAttempt() {
        return attempt;
    }
}
