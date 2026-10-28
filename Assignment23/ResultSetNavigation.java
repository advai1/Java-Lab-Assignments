package Assignment23;
import java.sql.*;

public class ResultSetNavigation {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college", "root", "root");
            Statement stmt = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            System.out.println("--- Forward using next() ---");
            while (rs.next())
                System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3));

            System.out.println("--- Last record ---");
            if (rs.last())
                System.out.println(rs.getInt(1) + " | " + rs.getString(2));

            System.out.println("--- Previous record ---");
            if (rs.previous())
                System.out.println(rs.getInt(1) + " | " + rs.getString(2));

            System.out.println("--- First record ---");
            if (rs.first())
                System.out.println(rs.getInt(1) + " | " + rs.getString(2));

            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}