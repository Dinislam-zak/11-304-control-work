package ru.kpfu.itis.zakirov.controlwork11304.dto;


public class AttemptDto {

    private String login;

    private String time;

    private String attempt;

    public AttemptDto(String login, String time, String attempt) {
        this.login = login;
        this.time = time;
        this.attempt = attempt;
    }

    public String getLogin() {
        return login;
    }

    public String getTime() {
        return time;
    }

    public String getAttempt() {
        return attempt;
    }
}
