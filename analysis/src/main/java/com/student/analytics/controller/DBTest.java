package com.student.analytics.controller;

import com.student.analytics.utility.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/dbtest")
public class DBTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

      response.sendRedirect("index.html");

        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DBConnection.getConnection();
            response.getWriter().println("<h1>Database Connected Successfully!!!!!!</h1>");
            connection.close();

        } catch (Exception e) {

            response.getWriter().println("<h1>Database Connection Failed!</h1>");
            e.printStackTrace(
                    response.getWriter()
            );
        }
    }
}