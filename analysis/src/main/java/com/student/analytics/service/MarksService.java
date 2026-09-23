package com.student.analytics.service;

import com.student.analytics.dao.MarksDAO;
import com.student.analytics.entity.Marks;

public class MarksService {

    private final MarksDAO marksDAO;

    public MarksService() {
        marksDAO = new MarksDAO();
    }

    public boolean addMarks(Marks marks) {

        if (marks == null) {
            return false;
        }

        if (marks.getStudent_id() <= 0) {
            return false;
        }

        if (marks.getSubject_id() <= 0) {
            return false;
        }

        if (marks.getMarks() < 0 ||
                marks.getMarks() > 100) {
            return false;
        }

        return marksDAO.addMarks(marks);
    }
}