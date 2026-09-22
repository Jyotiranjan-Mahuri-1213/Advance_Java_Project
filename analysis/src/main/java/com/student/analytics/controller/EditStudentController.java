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

@WebServlet("/edit-student")
public class EditStudentController extends HttpServlet {

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

        String idValue = request.getParameter("id");

        if (idValue == null || idValue.trim().isEmpty()) {
            response.getWriter().println("Student ID is required");
            return;
        }

        int id = Integer.parseInt(idValue);

        Student student = studentService.getStudentWithId(id);

        if (student == null) {
            response.getWriter().println("Student not found");
            return;
        }

        request.setAttribute("student", student);

        request.getRequestDispatcher("WEB-INF/views/edit-student.jsp")
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

        if (role == null ||
                (!"ADMIN".equalsIgnoreCase(role)
                        && !"TEACHER".equalsIgnoreCase(role))) {

            response.getWriter().println("Access Denied");
            return;
        }

        int id = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int regd_no = Integer.parseInt(request.getParameter("regd_no"));
        String course = request.getParameter("course");
        int semester = Integer.parseInt(request.getParameter("semester"));
        String password = request.getParameter("password");
        String mobile_no = request.getParameter("mobile_no");

        Student student = new Student(
                id,
                name,
                email,
                regd_no,
                course,
                semester,
                password,
                mobile_no
        );

        boolean result = studentService.updateStudent(student);

        if (result) {
            response.sendRedirect("manage-students");
        } else {
            response.getWriter().println("Failed to update student");
        }
    }
}