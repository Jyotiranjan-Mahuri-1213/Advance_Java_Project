<%--
  Created by IntelliJ IDEA.
  User: jyotiranjanmahuri
  Date: 24-09-2026
  Time: 00:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Enter Marks</title>
</head>
<body>

<h2>Enter Marks</h2>

<form action="enter-marks" method="post">

    <label>Student ID:</label>
    <input type="number"
           name="student_id"
           required>

    <br><br>

    <label>Subject ID:</label>
    <input type="number"
           name="subject_id"
           required>

    <br><br>

    <label>Marks:</label>
    <input type="number"
           name="marks"
           min="0"
           max="100"
           required>

    <br><br>

    <button type="submit">
        Enter Marks
    </button>

</form>

<br>

<a href="teacher">Back to Teacher Dashboard</a>

</body>
</html>