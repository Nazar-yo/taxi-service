package com.company.controller.authentication;

import com.company.lib.Injector;
import com.company.lib.exception.AuthenticationException;
import com.company.model.Driver;
import com.company.service.AuthenticationService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogInController extends HttpServlet {
    private static final String DRIVER_ID = "driver_id";
    private static final Injector injector = Injector.getInstance("com/company");
    private final AuthenticationService authenticationService = (AuthenticationService)
            injector.getInstance(AuthenticationService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/authentication/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            Driver driver = authenticationService.login(login, password);
            HttpSession session = req.getSession();
            session.setAttribute(DRIVER_ID, driver.getId());
            resp.sendRedirect("/");
        } catch (AuthenticationException e) {
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/authentication/login.jsp").forward(req, resp);
        }
    }
}
