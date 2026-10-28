package Assignment23;
import java.sql.*;

public class EmployeeResultSet {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/company", "root", "root");
            Statement stmt = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

            System.out.println("Employee Records (one by one):");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("emp_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("Salary: " + rs.getDouble("salary"));
                System.out.println("-------------------------");
            }

            System.out.println("Going back to first record:");
            if (rs.first())
                System.out.println(rs.getInt("emp_id") + " - " + rs.getString("name"));

            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}