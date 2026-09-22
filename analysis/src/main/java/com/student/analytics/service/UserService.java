package com.student.analytics.service;

import com.student.analytics.dao.UserDAO;
import com.student.analytics.entity.User;

import java.util.List;

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

    public boolean addTeacher(User user) {

        if (user == null) {
            return false;
        }

        if (user.getName() == null || user.getName().trim().isEmpty()) {
            return false;
        }

        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            return false;
        }

        if (user.getMobile_no() == null || user.getMobile_no().trim().isEmpty()) {
            return false;
        }

        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            return false;
        }

        return userDAO.addTeacher(user);
    }

    public List<User> getAllTeachers() {
        return userDAO.getAllTeachers();
    }
}