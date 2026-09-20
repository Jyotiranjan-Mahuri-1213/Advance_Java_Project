package com.student.analytics.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import com.student.analytics.entity.User;
import com.student.analytics.service.UserService;


@WebServlet("/add-teacher")
public class AddTeacherController extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect("staff-login.html");
            return;
        }

        String role = (String) session.getAttribute("role");

        if (role == null || !"ADMIN".equalsIgnoreCase(role)) {
            response.getWriter().println("Access Denied");
            return;
        }

        request.getRequestDispatcher("WEB-INF/views/add-teacher.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect("staff-login.html");
            return;
        }

        String role = (String) session.getAttribute("role");

        if (role == null || !"ADMIN".equalsIgnoreCase(role)) {
            response.getWriter().println("Access Denied");
            return;
        }

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile_no = request.getParameter("mobile_no");
        String password = request.getParameter("password");

        User teacher = new User(
                name,
                email,
                mobile_no,
                password,
                "TEACHER"
        );

        boolean result = userService.addTeacher(teacher);

        if (result) {
            response.getWriter().println("Teacher added successfully");
        } else {
            response.getWriter().println("Failed to add teacher");
        }
    }
}