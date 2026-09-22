package com.student.analytics.dao;

import com.student.analytics.entity.TeacherSubjectAssignment;
import com.student.analytics.utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherSubjectAssignmentDAO {

    public boolean assignSubjectToTeacher(
            TeacherSubjectAssignment assignment) {

        String sql = "insert into teacher_subject_assignments " +
                "(teacher_id, subject_id) values (?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, assignment.getTeacher_id());
            ps.setInt(2, assignment.getSubject_id());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<TeacherSubjectAssignment> getAllAssignments() {

        List<TeacherSubjectAssignment> assignments =
                new ArrayList<>();

        String sql =
                "select * from teacher_subject_assignments";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                TeacherSubjectAssignment assignment =
                        new TeacherSubjectAssignment(
                                rs.getInt("id"),
                                rs.getInt("teacher_id"),
                                rs.getInt("subject_id")
                        );

                assignments.add(assignment);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return assignments;
    }
}