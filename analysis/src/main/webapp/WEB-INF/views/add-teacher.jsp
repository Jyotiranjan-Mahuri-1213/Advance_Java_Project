<%--
  Created by IntelliJ IDEA.
  User: jyotiranjanmahuri
  Date: 12-09-2026
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Teacher</title>
</head>
<body>

<h1>Add Teacher</h1>

<form action="add-teacher" method="post">

    <label>Name:</label>
    <input type="text" name="name" required>
    <br><br>

    <label>Email:</label>
    <input type="email" name="email" required>
    <br><br>

    <label>Mobile Number:</label>
    <input type="text" name="mobile_no" required>
    <br><br>

    <label>Password:</label>
    <input type="password" name="password" required>
    <br><br>

    <button type="submit">Add Teacher</button>

</form>

<br>

<a href="admin">Back to Admin Dashboard</a>

</body>
</html>