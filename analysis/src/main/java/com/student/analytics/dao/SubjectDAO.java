package com.student.analytics.dao;

import com.student.analytics.entity.Subject;
import com.student.analytics.utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO {

    public boolean addSubject(Subject subject) {

        String sql = "insert into subjects (subject_name, subject_code, course, semester) values (?, ?, ?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, subject.getSubject_name());
            ps.setString(2, subject.getSubject_code());
            ps.setString(3, subject.getCourse());
            ps.setInt(4, subject.getSemester());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Subject> getAllSubjects() {

        List<Subject> subjects = new ArrayList<>();

        String sql = "select * from subjects";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Subject subject = new Subject(
                        rs.getInt("id"),
                        rs.getString("subject_name"),
                        rs.getString("subject_code"),
                        rs.getString("course"),
                        rs.getInt("semester")
                );

                subjects.add(subject);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return subjects;
    }
}