package com.student.analytics.service;

import com.student.analytics.dao.TeacherSubjectAssignmentDAO;
import com.student.analytics.entity.TeacherSubjectAssignment;

import java.util.List;

public class TeacherSubjectAssignmentService {

    private final TeacherSubjectAssignmentDAO assignmentDAO;

    public TeacherSubjectAssignmentService() {
        assignmentDAO = new TeacherSubjectAssignmentDAO();
    }

    public boolean assignSubjectToTeacher(
            TeacherSubjectAssignment assignment) {

        if (assignment == null) {
            return false;
        }

        if (assignment.getTeacher_id() <= 0) {
            return false;
        }

        if (assignment.getSubject_id() <= 0) {
            return false;
        }

        return assignmentDAO.assignSubjectToTeacher(assignment);
    }

    public List<TeacherSubjectAssignment> getAllAssignments() {
        return assignmentDAO.getAllAssignments();
    }
}