package com.student.analytics.controller;

import com.student.analytics.entity.User;
import com.student.analytics.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/staff-login")
public class StaffLoginController extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println("Staff login attempt: " + email);

        User user = userService.login(email, password);

        if (user == null) {

            response.getWriter().println("Invalid email or password");
            return;
        }

        String role = user.getRole();

        System.out.println("Login successful");
        System.out.println("User: " + user.getName());
        System.out.println("Role: " + role);

        HttpSession session = request.getSession();

        session.setAttribute("userId", user.getId());
        session.setAttribute("name", user.getName());
        session.setAttribute("email", user.getEmail());
        session.setAttribute("mobile_no", user.getMobile_no());
        session.setAttribute("role", role);

        if ("ADMIN".equalsIgnoreCase(role)) {

            response.sendRedirect("admin");

        } else if ("TEACHER".equalsIgnoreCase(role)) {

            response.sendRedirect("teacher");

        } else {

            session.invalidate();
            response.getWriter().println("Unauthorized role");
        }
    }
}