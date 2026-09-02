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

@WebServlet("/welcome")
public class WelcomeController extends HttpServlet {

    private StudentService studentService;

    @Override
    public void init() throws ServletException {
        studentService = new StudentService();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("WelcomeController called");

        String email = null;

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {

            for (Cookie cookie : cookies) {

                if ("studentEmail".equals(cookie.getName())) {
                    email = cookie.getValue();
                    break;
                }
            }
        }

        System.out.println("Cookie email: " + email);

        if (email == null || email.isBlank()) {

            System.out.println("Cookie not found");

            response.sendRedirect(
                    request.getContextPath() + "/login.html"
            );

            return;
        }

        // IMPORTANT: pass the cookie email
        Student student = studentService.getStudentByEmail(email);

        if (student == null) {

            System.out.println("Student not found");

            response.sendRedirect(
                    request.getContextPath() + "/login.html"
            );

            return;
        }

        System.out.println("Student found: " + student.getName());

        request.setAttribute("student", student);

        request.getRequestDispatcher(
                "/WEB-INF/views/welcome.jsp"
        ).forward(request, response);
    }
}