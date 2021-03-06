package com.company.controller.driver;

import com.company.lib.Injector;
import com.company.model.Driver;
import com.company.service.DriverService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddDriverController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("com.company");
    private final DriverService driverService = (DriverService) injector
            .getInstance(DriverService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/drivers/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        String name = req.getParameter("name");
        String licenceNumber = req.getParameter("licence_number");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirm_password");
        if (driverService.getByLogin(login).isPresent()) {
            req.setAttribute("errorMessage", "Login " + login + " is already taken");
            req.getRequestDispatcher("/WEB-INF/views/drivers/add.jsp").forward(req, resp);
            return;
        }
        if (!password.equals(confirmPassword)) {
            req.setAttribute("errorMessage", "Password dose not match");
            req.getRequestDispatcher("/WEB-INF/views/drivers/add.jsp").forward(req, resp);
            return;
        }
        Driver driver = new Driver(name, licenceNumber);
        driver.setLogin(login);
        driver.setPassword(password);
        driverService.create(driver);
        resp.sendRedirect("/drivers");
    }
}
