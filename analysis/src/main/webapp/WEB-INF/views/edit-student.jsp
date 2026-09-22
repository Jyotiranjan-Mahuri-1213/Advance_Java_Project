<%--
  Created by IntelliJ IDEA.
  User: jyotiranjanmahuri
  Date: 21-09-2026
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.student.analytics.entity.Student" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Student student = (Student) request.getAttribute("student");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Student</title>
</head>
<body>

<h1>Edit Student</h1>

<form action="edit-student" method="post">

    <input type="hidden"
           name="id"
           value="<%= student.getId() %>">

    <label>Name:</label>
    <input type="text"
           name="name"
           value="<%= student.getName() %>"
           required>
    <br><br>

    <label>Email:</label>
    <input type="email"
           name="email"
           value="<%= student.getEmail() %>"
           required>
    <br><br>

    <label>Registration Number:</label>
    <input type="number"
           name="regd_no"
           value="<%= student.getRegd_no() %>"
           required>
    <br><br>

    <label>Course:</label>
    <input type="text"
           name="course"
           value="<%= student.getCourse() %>"
           required>
    <br><br>

    <label>Semester:</label>
    <input type="number"
           name="semester"
           value="<%= student.getSemester() %>"
           required>
    <br><br>

    <label>Mobile Number:</label>
    <input type="text"
           name="mobile_no"
           value="<%= student.getMobile_no() %>"
           required>
    <br><br>

    <label>Password:</label>
    <input type="password"
           name="password"
           value="<%= student.getPassword() %>"
           required>
    <br><br>

    <button type="submit">Update Student</button>

</form>

<br>

<a href="manage-students">Back to Manage Students</a>

</body>
</html>