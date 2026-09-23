package com.student.analytics.controller;

import com.student.analytics.entity.Marks;
import com.student.analytics.service.MarksService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/enter-marks")
public class MarksController extends HttpServlet {

    private MarksService marksService;

    @Override
    public void init() throws ServletException {
        marksService = new MarksService();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        if (session == null) {
            response.sendRedirect("staff-login.html");
            return;
        }

        String role =
                (String) session.getAttribute("role");

        if (role == null ||
                !"TEACHER".equalsIgnoreCase(role)) {

            response.getWriter().println("Access Denied");
            return;
        }

        request.getRequestDispatcher(
                "WEB-INF/views/enter-marks.jsp"
        ).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        if (session == null) {
            response.sendRedirect("staff-login.html");
            return;
        }

        String role =
                (String) session.getAttribute("role");

        if (role == null ||
                !"TEACHER".equalsIgnoreCase(role)) {

            response.getWriter().println("Access Denied");
            return;
        }

        int student_id =
                Integer.parseInt(
                        request.getParameter("student_id"));

        int subject_id =
                Integer.parseInt(
                        request.getParameter("subject_id"));

        int marks =
                Integer.parseInt(
                        request.getParameter("marks"));

        Marks marksObject =
                new Marks(
                        student_id,
                        subject_id,
                        marks
                );

        boolean result =
                marksService.addMarks(marksObject);

        if (result) {
            response.sendRedirect("enter-marks");
        } else {
            response.getWriter().println(
                    "Failed to enter marks"
            );
        }
    }
}