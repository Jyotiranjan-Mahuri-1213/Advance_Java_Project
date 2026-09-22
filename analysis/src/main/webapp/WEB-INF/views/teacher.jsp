<%--
  Created by IntelliJ IDEA.
  User: jyotiranjanmahuri
  Date: 21-09-2026
  Time: 00:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
  <title>Teacher Dashboard</title>
</head>
<body>

<h1>Teacher Dashboard</h1>

<h2>Welcome, <%= request.getAttribute("name") %></h2>

<h3>Teacher Profile</h3>

<p>
  <strong>Email:</strong>
  <%= request.getAttribute("email") %>
</p>

<p>
  <strong>Mobile Number:</strong>
  <%= request.getAttribute("mobile_no") %>
</p>

<hr>

<h2>Teacher Features</h2>

<ul>
  <li>Enter Marks</li>
  <li>Update Marks</li>
  <li>Record Attendance</li>
  <li>Update Attendance</li>
  <li>View Class Performance</li>
  <li>Analytics</li>
  <li>Reports</li>
</ul>

</body>
</html>
