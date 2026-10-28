<%@ page import="java.sql.*" %>
<%
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/hospital", "root", "root");

    String action = request.getParameter("action");
    String msg = "";

    if ("add".equals(action)) {
        PreparedStatement ps = con.prepareStatement("INSERT INTO patient VALUES (?,?,?,?,?)");
        ps.setInt(1, Integer.parseInt(request.getParameter("id")));
        ps.setString(2, request.getParameter("name"));
        ps.setInt(3, Integer.parseInt(request.getParameter("age")));
        ps.setString(4, request.getParameter("disease"));
        ps.setString(5, request.getParameter("status"));
        ps.executeUpdate();
        msg = "Patient added.";
    } else if ("update".equals(action)) {
        PreparedStatement ps = con.prepareStatement(
            "UPDATE patient SET name=?, age=?, disease=?, treatment_status=? WHERE patient_id=?");
        ps.setString(1, request.getParameter("name"));
        ps.setInt(2, Integer.parseInt(request.getParameter("age")));
        ps.setString(3, request.getParameter("disease"));
        ps.setString(4, request.getParameter("status"));
        ps.setInt(5, Integer.parseInt(request.getParameter("id")));
        msg = ps.executeUpdate() > 0 ? "Patient updated." : "Patient not found.";
    } else if ("delete".equals(action)) {
        PreparedStatement ps = con.prepareStatement("DELETE FROM patient WHERE patient_id=?");
        ps.setInt(1, Integer.parseInt(request.getParameter("id")));
        msg = ps.executeUpdate() > 0 ? "Patient deleted." : "Patient not found.";
    }
%>
<html>
<body>
    <h2>Patient Records (CRUD)</h2>
    <p style="color:green"><%= msg %></p>

    <h3>Add Patient</h3>
    <form method="post">
        <input type="hidden" name="action" value="add">
        ID: <input type="text" name="id">
        Name: <input type="text" name="name">
        Age: <input type="text" name="age">
        Disease: <input type="text" name="disease">
        Status: <input type="text" name="status">
        <input type="submit" value="Add">
    </form>

    <h3>Update Patient</h3>
    <form method="post">
        <input type="hidden" name="action" value="update">
        ID: <input type="text" name="id">
        Name: <input type="text" name="name">
        Age: <input type="text" name="age">
        Disease: <input type="text" name="disease">
        Status: <input type="text" name="status">
        <input type="submit" value="Update">
    </form>

    <h3>Delete Patient</h3>
    <form method="post">
        <input type="hidden" name="action" value="delete">
        ID: <input type="text" name="id">
        <input type="submit" value="Delete">
    </form>

    <h3>Patient List</h3>
    <table border="1" cellpadding="5">
        <tr><th>ID</th><th>Name</th><th>Age</th><th>Disease</th><th>Treatment Status</th></tr>
        <%
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM patient");
            while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("patient_id") %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getInt("age") %></td>
            <td><%= rs.getString("disease") %></td>
            <td><%= rs.getString("treatment_status") %></td>
        </tr>
        <% } con.close(); %>
    </table>
</body>
</html>