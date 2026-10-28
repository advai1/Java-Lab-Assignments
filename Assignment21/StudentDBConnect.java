package Assignment21;
import java.sql.*;

public class StudentDBConnect {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DATABASE()");
            if (rs.next())
                System.out.println("Connected to database: " + rs.getString(1));
            System.out.println("Student database is connected successfully.");
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}