package com.student.analytics.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String url = "jdbc:mysql://localhost:3306/student_analytics";

    private static final String user = "root";

    private static final String password = "Jyoti@2004";

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url,user,password);
    }
}