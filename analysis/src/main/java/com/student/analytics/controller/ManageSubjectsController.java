package com.student.analytics.controller;

import com.student.analytics.entity.Subject;
import com.student.analytics.service.SubjectService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/manage-subjects")
public class ManageSubjectsController extends HttpServlet {

    private SubjectService subjectService;

    @Override
    public void init() throws ServletException {
        subjectService = new SubjectService();
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

        List<Subject> subjects =
                subjectService.getAllSubjects();

        request.setAttribute("subjects", subjects);

        request.getRequestDispatcher(
                "WEB-INF/views/manage-subjects.jsp"
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

        String subject_name =
                request.getParameter("subject_name");

        String subject_code =
                request.getParameter("subject_code");

        String course =
                request.getParameter("course");

        int semester =
                Integer.parseInt(request.getParameter("semester"));

        Subject subject = new Subject(
                subject_name,
                subject_code,
                course,
                semester
        );

        boolean result =
                subjectService.addSubject(subject);

        if (result) {
            response.sendRedirect("manage-subjects");
        } else {
            response.getWriter().println(
                    "Failed to add subject"
            );
        }
    }
}