package com.student.analytics.dao;

import com.student.analytics.entity.Student;
import com.student.analytics.utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private String email;

    public boolean register(Student student) {

        String sql = "insert into students (name, email, regd_no, course, semester,password) values (?, ?, ?, ?, ?,?)";

        try{
            System.out.println("load database");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql) ;

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getRegd_no());
            ps.setString(4, student.getCourse());
            ps.setString(5, String.valueOf(student.getSemester()));
            ps.setString(6, student.getPassword());
          //  ps.executeUpdate();
          //  System.out.println("data added");
            System.out.println("Execute query...");
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
    public Student login(String email, String password) {

        String sql = "select * from students where email = ? AND password = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("regd_no"),
                        rs.getString("course"),
                        rs.getInt("semester"),
                        rs.getString("password")
                );

                return student;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Student getStudentByEmail(String studentEmail) {
        String sql = "select * from students where email = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1,email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("regd_no"),
                        rs.getString("course"),
                        rs.getInt("semester"),
                        rs.getString("password")
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            
        }

        return null;
    }
}