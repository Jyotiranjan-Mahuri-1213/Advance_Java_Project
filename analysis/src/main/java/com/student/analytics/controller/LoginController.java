package com.student.analytics.controller;

import com.student.analytics.entity.Student;
import com.student.analytics.service.StudentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    private StudentService studentService;

    @Override
    public void init() throws ServletException {
        studentService = new StudentService();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println("Login attempt: " + email);

        Student student = studentService.login(email, password);

        if (student != null) {

            System.out.println("Login successful");
            System.out.println("Student: " + student.getName());

            Cookie emailCookie = new Cookie("studentEmail", email);
            emailCookie.setMaxAge(60 * 60);
            emailCookie.setPath("/analytics");
            response.addCookie(emailCookie);

            System.out.println("Cookie created");
         //   response.sendRedirect("/webapp/WEB-INF/views/welcome.jsp");
            response.sendRedirect("welcome");
        } else {

            System.out.println("Login failed");

            response.setContentType("text/html");

            response.getWriter().println("<h2>Invalid Email or Password</h2>");

            response.getWriter().println("<a href='login.html'>Try Again</a>");
        }
    }
}