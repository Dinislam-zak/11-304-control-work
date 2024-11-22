package ru.kpfu.itis.zakirov.controlwork11304.service.impl;

import ru.kpfu.itis.zakirov.controlwork11304.dao.AttemptDao;
import ru.kpfu.itis.zakirov.controlwork11304.dao.impl.AttemptDaoImpl;
import ru.kpfu.itis.zakirov.controlwork11304.dto.AttemptDto;
import ru.kpfu.itis.zakirov.controlwork11304.entity.Attempt;
import ru.kpfu.itis.zakirov.controlwork11304.service.AttemptService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AttemptServiceImpl implements AttemptService {
    private final AttemptDao attemptDao = new AttemptDaoImpl();

    @Override
    public AttemptDto get(Integer id) {
        Attempt attempt = attemptDao.get(id);

        return new AttemptDto(
                attempt.getLogin(),
                attempt.getTime().toString(),
                attempt.getAttemptStatus().toString()
        );
    }

    @Override
    public AttemptDto getByLogin(String login) {
        Attempt attempt = attemptDao.getByLogin(login);

        return new AttemptDto(
                attempt.getLogin(),
                attempt.getTime().toString(),
                attempt.getAttemptStatus().toString()
        );
    }

    @Override
    public List<AttemptDto> getAll() {
        List<Attempt> attempts = attemptDao.getAll();

        return attempts.stream()
                .map(a -> new AttemptDto(a.getLogin(), a.getTime().toString(), a.getAttemptStatus().toString()))
                .toList();
    }

    @Override
    public void registerAttempt(String login, Boolean status) {
        attemptDao.save(
                new Attempt(
                        null,
                        login,
                        LocalDateTime.now(),
                        status
                )
        );
    }
}
