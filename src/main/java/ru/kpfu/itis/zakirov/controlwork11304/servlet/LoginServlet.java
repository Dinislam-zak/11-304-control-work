package ru.kpfu.itis.zakirov.controlwork11304.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import ru.kpfu.itis.zakirov.controlwork11304.dto.UserLoginDto;
import ru.kpfu.itis.zakirov.controlwork11304.service.AttemptService;
import ru.kpfu.itis.zakirov.controlwork11304.service.UserService;
import ru.kpfu.itis.zakirov.controlwork11304.service.impl.AttemptServiceImpl;
import ru.kpfu.itis.zakirov.controlwork11304.service.impl.UserServiceImpl;
import ru.kpfu.itis.zakirov.controlwork11304.util.PasswordUtil;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();
    private final AttemptService attemptService = new AttemptServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserLoginDto userLoginDto = userService.getUserLoginDto(login);

        if (userLoginDto.getPassword().equals(PasswordUtil.encrypt(password))) {

            HttpSession session = req.getSession();
            session.setAttribute("login", login);
            session.setMaxInactiveInterval(60 * 60);

            attemptService.registerAttempt(login, true);

            resp.sendRedirect("/profile");

        } else {

            attemptService.registerAttempt(login, false);

            resp.sendRedirect("/login");
        }
    }
}