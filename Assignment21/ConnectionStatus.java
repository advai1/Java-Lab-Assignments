package Assignment21;
import java.sql.*;

public class ConnectionStatus {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college", "root", "root");
            if (con != null && !con.isClosed())
                System.out.println("Database connection status: CONNECTED");
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Connection status: FAILED - " + e.getMessage());
        }
    }
}