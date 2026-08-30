//package com.student.analytics.controller;
//
//import com.student.analytics.entity.Student;
//import com.student.analytics.service.StudentService;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//@WebServlet("/students")
//public class StudentController extends HttpServlet {
//
//    private StudentController studentService;
//
//    @Override
//    public void init() throws ServletException {
//        studentService = new StudentController();
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request,
//                         HttpServletResponse response)
//            throws ServletException, IOException {
//
//        response.setContentType("text/html");
//
//        PrintWriter out = response.getWriter();
//
//        List<Student> students = studentService.getAllStudents();
//
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>Students</title>");
//        out.println("</head>");
//
//        out.println("<body>");
//
//        out.println("<h1>Student Performance Analytics</h1>");
//
//        out.println("<h2>Student List</h2>");
//
//        if (students.isEmpty()) {
//
//            out.println("<p>No students found.</p>");
//
//        } else {
//
//            out.println("<table border='1'>");
//
//            out.println("<tr>");
//            out.println("<th>ID</th>");
//            out.println("<th>Name</th>");
//            out.println("<th>Email</th>");
//            out.println("<th>Roll Number</th>");
//            out.println("<th>Course</th>");
//            out.println("<th>Semester</th>");
//            out.println("</tr>");
//
//            for (Student student : students) {
//
//                out.println("<tr>");
//
//                out.println("<td>" +
//                        student.getId() +
//                        "</td>");
//
//                out.println("<td>" +
//                        student.getName() +
//                        "</td>");
//
//                out.println("<td>" +
//                        student.getEmail() +
//                        "</td>");
//
//                out.println("<td>" +
//                        student.getRegd_no() +
//                        "</td>");
//
//                out.println("<td>" +
//                        student.getCourse() +
//                        "</td>");
//
//                out.println("<td>" +
//                        student.getSemester() +
//                        "</td>");
//
//                out.println("</tr>");
//            }
//
//            out.println("</table>");
//        }
//
//        out.println("</body>");
//        out.println("</html>");
//    }
//
//    private List<Student> getAllStudents() {
//        return List.of();
//    }
//}