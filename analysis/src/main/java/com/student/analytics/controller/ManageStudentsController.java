package com.student.analytics.controller;

import com.student.analytics.entity.Student;
import com.student.analytics.service.StudentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/manage-students")
public class ManageStudentsController extends HttpServlet {

    private StudentService studentService;

    @Override
    public void init() throws ServletException {
        studentService = new StudentService();
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

        if (role == null ||
                (!"ADMIN".equalsIgnoreCase(role)
                        && !"TEACHER".equalsIgnoreCase(role))) {

            response.getWriter().println("Access Denied");
            return;
        }

        List<Student> students = studentService.getAllStudent();

        request.setAttribute("students", students);

        request.getRequestDispatcher("WEB-INF/views/manage-students.jsp")
                .forward(request, response);
    }

}