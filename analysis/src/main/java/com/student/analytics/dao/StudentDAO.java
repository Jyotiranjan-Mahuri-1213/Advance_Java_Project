package com.student.analytics.dao;

import com.student.analytics.entity.Student;
import com.student.analytics.utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public boolean addStudent(Student student) {

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
            System.out.println("Executing INSERT query...");
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        String sql = "select * from students";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery() ;

            while (rs.next()) {

                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("regd_no"),
                        rs.getString("course"),
                        rs.getInt("semester"),
                        rs.getString("password")
                );

                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return students;
    }

    public Student getStudentById(int id) {

        String sql = "select * from students where id = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql) ;

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

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
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {

        }

        return null;
    }
    public boolean updateStudent(Student student) {

        String sql = "update students set name = ?, email = ?, roll_number = ?, course = ?, semester = ?,password=? where id = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql) ;

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getRegd_no());
            ps.setString(4, student.getCourse());
            ps.setString(5, String.valueOf(student.getSemester()));
            ps.setInt(6, student.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteStudent(int id) {
        String sql = "delete from students where id = ?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql) ;

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
}