<%@ page import="com.student.analytics.entity.Student" %>

<%
    Student student = (Student) request.getAttribute("student");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Student Dashboard</title>
</head>

<body>

<h1>Welcome, <%= student.getName() %></h1>

<h2>Student Performance Analytics Dashboard</h2>

<hr>

<h3>Student Information</h3>

<p><strong>Name:</strong> <%= student.getName() %></p>

<p><strong>Email:</strong> <%= student.getEmail() %></p>

<p><strong>Registration No:</strong> <%= student.getRegd_no() %></p>

<p><strong>Course:</strong> <%= student.getCourse() %></p>

<p><strong>Semester:</strong> <%= student.getSemester() %></p>
<p><strong>Mobile no:</strong> <%= student.getMobile_no() %></p>

</body>
</html>