package com.student.analytics.service;

import com.student.analytics.dao.SubjectDAO;
import com.student.analytics.entity.Subject;

import java.util.List;

public class SubjectService {

    private final SubjectDAO subjectDAO;

    public SubjectService() {
        subjectDAO = new SubjectDAO();
    }

    public boolean addSubject(Subject subject) {

        if (subject == null) {
            return false;
        }

        if (subject.getSubject_name() == null ||
                subject.getSubject_name().trim().isEmpty()) {
            return false;
        }

        if (subject.getSubject_code() == null ||
                subject.getSubject_code().trim().isEmpty()) {
            return false;
        }

        if (subject.getCourse() == null ||
                subject.getCourse().trim().isEmpty()) {
            return false;
        }

        if (subject.getSemester() <= 0) {
            return false;
        }

        return subjectDAO.addSubject(subject);
    }

    public List<Subject> getAllSubjects() {
        return subjectDAO.getAllSubjects();
    }
}