package ru.kpfu.itis.zakirov.controlwork11304.service.impl;

import ru.kpfu.itis.zakirov.controlwork11304.dao.AttemptDao;
import ru.kpfu.itis.zakirov.controlwork11304.dao.impl.AttemptDaoImpl;
import ru.kpfu.itis.zakirov.controlwork11304.dto.AttemptDto;
import ru.kpfu.itis.zakirov.controlwork11304.entity.Attempt;
import ru.kpfu.itis.zakirov.controlwork11304.service.AttemptService;

import java.util.List;
import java.util.stream.Collectors;

public class AttemptServiceImpl implements AttemptService {

    private final AttemptDao attemptDao = new AttemptDaoImpl();

    @Override
    public List<AttemptDto> getAll() {
        return attemptDao.getAll().stream().map(
                a -> new AttemptDto(a.getLogin(),a.getTime(),a.getAttempt())
        ).collect(Collectors.toList());
    }

    @Override
    public AttemptDto get(Integer id) {
        return null;
    }

    @Override
    public AttemptDto getByLogin(String login) {
        Attempt a = attemptDao.getByLogin(login);
        return new AttemptDto(a.getLogin(),a.getTime(),a.getAttempt());
    }

    @Override
    public void registerAttempt(AttemptDto attempt) {
        attemptDao.save(new Attempt(
                attempt.getLogin(),
                attempt.getTime(),
                attempt.getAttempt()
        ));
    }
}
