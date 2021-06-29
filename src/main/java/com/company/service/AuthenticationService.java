package com.company.service;

import com.company.lib.exception.AuthenticationException;
import com.company.model.Driver;

public interface AuthenticationService {
    Driver login(String login, String password) throws AuthenticationException;
}
