<%--
  Created by IntelliJ IDEA.
  User: jyotiranjanmahuri
  Date: 22-09-2026
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.student.analytics.entity.Subject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Subject> subjects =
            (List<Subject>) request.getAttribute("subjects");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Manage Subjects</title>
</head>

<body>

<h1>Manage Subjects</h1>

<h2>Add Subject</h2>

<form action="manage-subjects" method="post">

    <label>Subject Name:</label>
    <input type="text"
           name="subject_name"
           required>
    <br><br>

    <label>Subject Code:</label>
    <input type="text"
           name="subject_code"
           required>
    <br><br>

    <label>Course:</label>
    <input type="text"
           name="course"
           required>
    <br><br>

    <label>Semester:</label>
    <input type="number"
           name="semester"
           min="1"
           required>
    <br><br>

    <button type="submit">
        Add Subject
    </button>

</form>

<hr>

<h2>All Subjects</h2>

<table border="1" cellpadding="10">

    <tr>
        <th>ID</th>
        <th>Subject Name</th>
        <th>Subject Code</th>
        <th>Course</th>
        <th>Semester</th>
    </tr>

    <%
        if (subjects != null && !subjects.isEmpty()) {

            for (Subject subject : subjects) {
    %>

    <tr>
        <td><%= subject.getId() %></td>
        <td><%= subject.getSubject_name() %></td>
        <td><%= subject.getSubject_code() %></td>
        <td><%= subject.getCourse() %></td>
        <td><%= subject.getSemester() %></td>
    </tr>

    <%
        }

    } else {
    %>

    <tr>
        <td colspan="5">
            No subjects found.
        </td>
    </tr>

    <%
        }
    %>

</table>

<br>

<a href="admin">Back to Admin Dashboard</a>

</body>
</html>