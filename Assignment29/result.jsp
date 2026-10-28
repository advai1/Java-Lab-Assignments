<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<body>
    <h2>Registration Details</h2>
    <p>Name: <%= request.getParameter("name") %></p>
    <p>Email: <%= request.getParameter("email") %></p>
    <p>Phone: <%= request.getParameter("phone") %></p>
    <p>Password: <%= request.getParameter("password") %></p>
</body>
</html>