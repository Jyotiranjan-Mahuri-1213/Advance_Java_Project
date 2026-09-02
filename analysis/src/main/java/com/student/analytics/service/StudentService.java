package com.student.analytics.service;

import com.student.analytics.dao.StudentDAO;
import com.student.analytics.entity.Student;

import java.util.List;

public class StudentService {

    private final StudentDAO studentDAO;

    public StudentService() {
        studentDAO = new StudentDAO();
    }

    public boolean addStudent(Student student) {
        System.out.println("Service received student");
        if (student == null) {
            return false;
        }

        if (student.getName() == null ||
                student.getName().trim().isEmpty()) {
            return false;
        }

        if (student.getEmail() == null ||
                student.getEmail().trim().isEmpty()) {
            return false;
        }

        if (student.getRegd_no() <= 0) {
            return false;
        }

        if (student.getCourse() == null ||
                student.getCourse().trim().isEmpty()) {
            return false;
        }

        if (student.getSemester() <= 0) {
            return false;
        }

        if (student.getPassword() == null ||
                student.getPassword().trim().isEmpty()) {
            return false;
        }
        System.out.println("Calling StudentDAO...");

        return studentDAO.register(student);
    }


    public Student login(String email, String password) {

        if (email == null || email.trim().isEmpty()) {
            return null;
        }

        if (password == null || password.trim().isEmpty()) {
            return null;
        }
        return studentDAO.login(email, password);
    }


    public Student getStudentByEmail(String email) {

        System.out.println("Service email: " + email);
        if (email == null || email.trim().isEmpty()) {
            return null;
        }

        return studentDAO.getStudentByEmail(email);
    }
}