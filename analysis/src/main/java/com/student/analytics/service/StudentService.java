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

        return studentDAO.addStudent(student);
    }


    public List<Student> getAllStudents() {

        return studentDAO.getAllStudents();
    }


    public Student getStudentById(int id) {

        if (id <= 0) {
            return null;
        }

        return studentDAO.getStudentById(id);
    }

    public boolean updateStudent(Student student) {

        if (student == null || student.getId() <= 0) {
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

        return studentDAO.updateStudent(student);
    }


    public boolean deleteStudent(int id) {

        if (id <= 0) {
            return false;
        }

        return studentDAO.deleteStudent(id);
    }
}