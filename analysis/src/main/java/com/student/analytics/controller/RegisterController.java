package com.student.analytics.controller;

import com.student.analytics.entity.Student;
import com.student.analytics.service.StudentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegisterController extends HttpServlet {

    private StudentService studentService;

    @Override
    public void init() throws ServletException {
        studentService = new StudentService();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Request data..");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String regdNoValue = request.getParameter("regdNo");
        String course = request.getParameter("course");
        String semesterValue = request.getParameter("semester");
        String password = request.getParameter("password");
        String mobile_no=request.getParameter("mobile_no");


        System.out.println("Name     : " + name);
        System.out.println("Email    : " + email);
        System.out.println("Regd No  : " + regdNoValue);
        System.out.println("Course   : " + course);
        System.out.println("Semester : " + semesterValue);
        System.out.println("Password : " + password);
        System.out.println("Mobile no :" + mobile_no);


        int regdNo;
        int semester;

        try {

            regdNo = Integer.parseInt(regdNoValue);
            System.out.println("Registration number converted: ");
            semester = Integer.parseInt(semesterValue);
            System.out.println("Semester converted: ");

        } catch (NumberFormatException e) {

            response.getWriter().println("Invalid registration number or semester");
            return;
        }

        Student student = new Student(
                name,
                email,
                regdNo,
                course,
                semester,
                password,
                mobile_no
        );

        boolean registered = studentService.addStudent(student);
       // System.out.println("registration Successful");

        if (registered) {
            System.out.println("registration Successful");
            response.sendRedirect("login.html");

        } else {

            response.getWriter().println("Registration failed");
        }
    }
}