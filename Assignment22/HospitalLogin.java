package Assignment22;
import java.sql.*;
import java.util.Scanner;

public class HospitalLogin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hospital", "root", "root");

            System.out.print("Enter Login ID: ");
            String id = sc.nextLine();
            System.out.print("Enter Password: ");
            String pass = sc.nextLine();

            PreparedStatement ps = con.prepareStatement(
                "SELECT role FROM staff WHERE login_id=? AND password=?");
            ps.setString(1, id);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                System.out.println("Access granted. Logged in as " + rs.getString("role"));
            else
                System.out.println("Access denied. Invalid Login ID or Password.");
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}