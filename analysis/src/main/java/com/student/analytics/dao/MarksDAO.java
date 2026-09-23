package com.student.analytics.dao;

import com.student.analytics.entity.Marks;
import com.student.analytics.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MarksDAO {

    public boolean addMarks(Marks marks) {

        String sql = "insert into marks (student_id, subject_id, marks) values (?, ?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, marks.getStudent_id());
            ps.setInt(2, marks.getSubject_id());
            ps.setInt(3, marks.getMarks());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}