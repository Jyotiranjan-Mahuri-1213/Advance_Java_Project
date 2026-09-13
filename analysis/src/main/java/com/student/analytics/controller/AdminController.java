package com.student.analytics.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/admin")
public class AdminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        // Check whether user is logged in
        if (session == null) {
            response.sendRedirect("staff-login.html");
            return;
        }

        // Get role from session
        String role = (String) session.getAttribute("role");

        // Check Admin permission
        if (role == null || !"ADMIN".equalsIgnoreCase(role)) {

            response.getWriter().println("Access Denied");
            return;
        }

        // Send admin information to JSP
        request.setAttribute("name", session.getAttribute("name"));
        request.setAttribute("email", session.getAttribute("email"));
        request.setAttribute("mobile_no", session.getAttribute("mobile_no"));

        request.getRequestDispatcher("/WEB-INF/views/admin.jsp")
                .forward(request, response);
    }
}