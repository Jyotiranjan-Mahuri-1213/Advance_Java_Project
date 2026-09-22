<%--
  Created by IntelliJ IDEA.
  User: jyotiranjanmahuri
  Date: 23-09-2026
  Time: 00:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.student.analytics.entity.User" %>
<%@ page import="com.student.analytics.entity.Subject" %>
<%@ page import="com.student.analytics.entity.TeacherSubjectAssignment" %>

<!DOCTYPE html>
<html>
<head>
    <title>Assign Subject to Teacher</title>
</head>
<body>

<h2>Assign Subject to Teacher</h2>

<form action="assign-subject" method="post">

    <label>Select Teacher:</label>

    <select name="teacher_id" required>

        <option value="">Select Teacher</option>

        <%
            List<User> teachers =
                    (List<User>) request.getAttribute("teachers");

            for (User teacher : teachers) {
        %>

        <option value="<%= teacher.getId() %>">
            <%= teacher.getName() %>
        </option>

        <%
            }
        %>

    </select>

    <br><br>

    <label>Select Subject:</label>

    <select name="subject_id" required>

        <option value="">Select Subject</option>

        <%
            List<Subject> subjects =
                    (List<Subject>) request.getAttribute("subjects");

            for (Subject subject : subjects) {
        %>

        <option value="<%= subject.getId() %>">
            <%= subject.getSubject_name() %>
            -
            <%= subject.getSubject_code() %>
            -
            <%= subject.getCourse() %>
            -
            Semester <%= subject.getSemester() %>
        </option>

        <%
            }
        %>

    </select>

    <br><br>

    <button type="submit">Assign Subject</button>

</form>

<hr>

<h3>Existing Assignments</h3>

<table border="1" cellpadding="8">

    <tr>
        <th>ID</th>
        <th>Teacher ID</th>
        <th>Subject ID</th>
    </tr>

    <%
        List<TeacherSubjectAssignment> assignments =
                (List<TeacherSubjectAssignment>)
                        request.getAttribute("assignments");

        for (TeacherSubjectAssignment assignment : assignments) {
    %>

    <tr>
        <td><%= assignment.getId() %></td>
        <td><%= assignment.getTeacher_id() %></td>
        <td><%= assignment.getSubject_id() %></td>
    </tr>

    <%
        }
    %>

</table>

<br>

<a href="admin">Back to Admin Dashboard</a>

</body>
</html>