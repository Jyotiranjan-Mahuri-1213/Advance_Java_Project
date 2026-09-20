package com.student.analytics.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/teacher")
public class TeacherController extends HttpServlet {

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

        if (role == null || !"TEACHER".equalsIgnoreCase(role)) {
            response.getWriter().println("Access Denied");
            return;
        }

        request.setAttribute("name", session.getAttribute("name"));
        request.setAttribute("email", session.getAttribute("email"));
        request.setAttribute("mobile_no", session.getAttribute("mobile_no"));

        request.getRequestDispatcher("WEB-INF/views/teacher.jsp")
                .forward(request, response);
    }
}