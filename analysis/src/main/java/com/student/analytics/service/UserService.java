package com.student.analytics.service;

import com.student.analytics.dao.UserDAO;
import com.student.analytics.entity.User;

public class UserService {

    private final UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }


    public User login(String email, String password) {

        if (email == null || email.trim().isEmpty()) {
            return null;
        }

        if (password == null || password.trim().isEmpty()) {
            return null;
        }

        return userDAO.login(email, password);
    }


    public User getUserByEmail(String email) {

        if (email == null || email.trim().isEmpty()) {
            return null;
        }

        return userDAO.getUserByEmail(email);
    }
}