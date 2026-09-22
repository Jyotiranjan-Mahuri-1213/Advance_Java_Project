package com.student.analytics.controller;

import com.student.analytics.entity.Subject;
import com.student.analytics.entity.TeacherSubjectAssignment;
import com.student.analytics.entity.User;
import com.student.analytics.service.SubjectService;
import com.student.analytics.service.TeacherSubjectAssignmentService;
import com.student.analytics.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/assign-subject")
public class TeacherSubjectAssignmentController extends HttpServlet {

    private TeacherSubjectAssignmentService assignmentService;
    private UserService userService;
    private SubjectService subjectService;

    @Override
    public void init() throws ServletException {
        assignmentService =
                new TeacherSubjectAssignmentService();

        userService =
                new UserService();

        subjectService =
                new SubjectService();
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
                !"ADMIN".equalsIgnoreCase(role)) {

            response.getWriter().println("Access Denied");
            return;
        }

        List<User> teachers =
                userService.getAllTeachers();

        List<Subject> subjects =
                subjectService.getAllSubjects();

        List<TeacherSubjectAssignment> assignments =
                assignmentService.getAllAssignments();

        request.setAttribute("teachers", teachers);
        request.setAttribute("subjects", subjects);
        request.setAttribute("assignments", assignments);

        request.getRequestDispatcher(
                "WEB-INF/views/assign-subject.jsp"
        ).forward(request, response);
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
                !"ADMIN".equalsIgnoreCase(role)) {

            response.getWriter().println("Access Denied");
            return;
        }

        int teacher_id =
                Integer.parseInt(
                        request.getParameter("teacher_id"));

        int subject_id =
                Integer.parseInt(
                        request.getParameter("subject_id"));

        TeacherSubjectAssignment assignment =
                new TeacherSubjectAssignment(
                        teacher_id,
                        subject_id
                );

        boolean result =
                assignmentService
                        .assignSubjectToTeacher(assignment);

        if (result) {
            response.sendRedirect("assign-subject");
        } else {
            response.getWriter().println(
                    "Failed to assign subject"
            );
        }
    }
}