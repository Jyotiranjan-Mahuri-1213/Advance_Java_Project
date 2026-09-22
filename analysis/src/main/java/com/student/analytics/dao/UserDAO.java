package com.student.analytics.dao;

import com.student.analytics.entity.User;
import com.student.analytics.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public User login(String email, String password) {

        String sql = "select * from users where email = ? and password = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DBConnection.getConnection();
            System.out.println("Database connection done");

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);

            System.out.println("details received");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("data found");
                return new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("mobile_no"),
                        rs.getString("password"),
                        rs.getString("role")
                );
            }

            System.out.println("no data found");

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }


    public User getUserByEmail(String email) {

        String sql = "select * from  * from users where email = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                User user=new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("mobile_no"),
                        rs.getString("password"),
                        rs.getString("role")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean addTeacher(User user) {

        String sql = "insert into users (name, email, mobile_no, password, role) values (?, ?, ?, ?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getMobile_no());
            ps.setString(4, user.getPassword());

            // Role is fixed by the backend
            ps.setString(5, "TEACHER");

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<User> getAllTeachers() {

        List<User> teachers = new ArrayList<>();

        String sql = "select * from users where role = 'TEACHER'";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                User teacher = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("mobile_no"),
                        rs.getString("password"),
                        rs.getString("role")
                );

                teachers.add(teacher);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return teachers;
    }
}