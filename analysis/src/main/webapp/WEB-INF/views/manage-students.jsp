<%--
  Created by IntelliJ IDEA.
  User: jyotiranjanmahuri
  Date: 21-09-2026
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.student.analytics.entity.Student" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Manage Students</title>
</head>
<body>

<h1>Manage Students</h1>

<table border="1" cellpadding="10">

    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Registration No</th>
        <th>Course</th>
        <th>Semester</th>
        <th>Mobile</th>
        <th>Action</th>
    </tr>

    <%
        List<Student> students =
                (List<Student>) request.getAttribute("students");

        if (students != null && !students.isEmpty()) {

            for (Student student : students) {
    %>

    <tr>
        <td><%= student.getId() %></td>
        <td><%= student.getName() %></td>
        <td><%= student.getEmail() %></td>
        <td><%= student.getRegd_no() %></td>
        <td><%= student.getCourse() %></td>
        <td><%= student.getSemester() %></td>
        <td><%= student.getMobile_no() %></td>
        <td>
            <a href="edit-student?id=<%= student.getId() %>">
                Edit
            </a>
        </td>
    </tr>

    <%
        }

    } else {
    %>

    <tr>
        <td colspan="8">No students found.</td>
    </tr>

    <%
        }
    %>

</table>

<br>

<a href="admin">Back to Admin Dashboard</a>
<br><br>

<a href="teacher">Back to Teacher Dashboard</a>

</body>
</html>