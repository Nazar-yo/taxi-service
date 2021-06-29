package com.company.service;

import com.company.model.Driver;
import java.util.Optional;

public interface DriverService extends GenericService<Driver> {
    Optional<Driver> getByLogin(String login);
}
