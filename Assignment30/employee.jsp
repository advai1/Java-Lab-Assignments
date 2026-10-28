<%@ page import="java.sql.*" %>
<%
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/company", "root", "root");

    String action = request.getParameter("action");
    String msg = "";

    if ("add".equals(action)) {
        PreparedStatement ps = con.prepareStatement("INSERT INTO employee VALUES (?,?,?,?)");
        ps.setInt(1, Integer.parseInt(request.getParameter("id")));
        ps.setString(2, request.getParameter("name"));
        ps.setString(3, request.getParameter("dept"));
        ps.setDouble(4, Double.parseDouble(request.getParameter("salary")));
        ps.executeUpdate();
        msg = "Employee added.";
    } else if ("update".equals(action)) {
        PreparedStatement ps = con.prepareStatement(
            "UPDATE employee SET name=?, department=?, salary=? WHERE emp_id=?");
        ps.setString(1, request.getParameter("name"));
        ps.setString(2, request.getParameter("dept"));
        ps.setDouble(3, Double.parseDouble(request.getParameter("salary")));
        ps.setInt(4, Integer.parseInt(request.getParameter("id")));
        msg = ps.executeUpdate() > 0 ? "Employee updated." : "Employee not found.";
    } else if ("delete".equals(action)) {
        PreparedStatement ps = con.prepareStatement("DELETE FROM employee WHERE emp_id=?");
        ps.setInt(1, Integer.parseInt(request.getParameter("id")));
        msg = ps.executeUpdate() > 0 ? "Employee deleted." : "Employee not found.";
    }
%>
<html>
<body>
    <h2>Employee Management (CRUD)</h2>
    <p style="color:green"><%= msg %></p>

    <h3>Add Employee</h3>
    <form method="post">
        <input type="hidden" name="action" value="add">
        ID: <input type="text" name="id">
        Name: <input type="text" name="name">
        Dept: <input type="text" name="dept">
        Salary: <input type="text" name="salary">
        <input type="submit" value="Add">
    </form>

    <h3>Update Employee</h3>
    <form method="post">
        <input type="hidden" name="action" value="update">
        ID: <input type="text" name="id">
        New Name: <input type="text" name="name">
        New Dept: <input type="text" name="dept">
        New Salary: <input type="text" name="salary">
        <input type="submit" value="Update">
    </form>

    <h3>Delete Employee</h3>
    <form method="post">
        <input type="hidden" name="action" value="delete">
        ID: <input type="text" name="id">
        <input type="submit" value="Delete">
    </form>

    <h3>Employee Records</h3>
    <table border="1" cellpadding="5">
        <tr><th>ID</th><th>Name</th><th>Department</th><th>Salary</th></tr>
        <%
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM employee");
            while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("emp_id") %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getString("department") %></td>
            <td><%= rs.getDouble("salary") %></td>
        </tr>
        <% } con.close(); %>
    </table>
</body>
</html>