<%--
  Created by IntelliJ IDEA.
  User: jyotiranjanmahuri
  Date: 11-09-2026
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>

    <title>Admin Dashboard</title>

</head>

<body bgcolor="#4682b4">

<h1>Admin Dashboard</h1>

<h2>Welcome, <%= request.getAttribute("name") %></h2>

<h3>Your Profile</h3>

<p>
    <strong>Email:</strong>
    <%= request.getAttribute("email") %>
</p>

<p>
    <strong>Mobile Number:</strong>
    <%= request.getAttribute("mobile_no") %>
</p>

<hr>

<h2>Welcome Mr. Admin</h2>

<ul>
    <li>
        <a href="add-teacher">Add Teacher</a>
    </li>
    <li>
        <a href="manage-students">Manage Students</a>
    </li>

    <li>
        <a href="manage-subjects">Manage Subjects</a>
    </li>

    <li>
        <a href="assign-subject">Assign Subjects to Teachers</a>
    </li>
   <p><strong>Other features are coming soon</strong></p>
</ul>

</body>
</html>
