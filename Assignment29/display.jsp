<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<body>
    <h2>Student Information</h2>
    <%
        String name = request.getParameter("name");
        String roll = request.getParameter("roll");
        String course = request.getParameter("course");
    %>
    <p>Name: <%= name %></p>
    <p>Roll No: <%= roll %></p>
    <p>Course: <%= course %></p>
</body>
</html>