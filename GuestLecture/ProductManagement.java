package GuestLecture;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Product Management System using JDBC (MySQL).
 * Fields: prod_id, prod_name, prod_price
 *
 * Compile: javac ProductManagement.java
 * Run    : java -cp .:mysql-connector-j-8.x.x.jar ProductManagement      (Linux/Mac)
 *          java -cp .;mysql-connector-j-8.x.x.jar ProductManagement      (Windows)
 */
public class ProductManagement {

    // ===================== Model =====================
    static class Product {
        private int prodId;
        private String prodName;
        private double prodPrice;

        Product(int prodId, String prodName, double prodPrice) {
            this.prodId = prodId;
            this.prodName = prodName;
            this.prodPrice = prodPrice;
        }

        int getProdId()        { return prodId; }
        String getProdName()   { return prodName; }
        double getProdPrice()  { return prodPrice; }

        @Override
        public String toString() {
            return String.format("%-8d %-30s %10.2f", prodId, prodName, prodPrice);
        }
    }

    // ===================== DB Connection =====================
    static class DBConnection {
        private static final String URL  = "jdbc:mysql://localhost:3306/product_db";
        private static final String USER = "root";        // change to your DB user
        private static final String PASS = "advait123";        // change to your DB password

        static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASS);
        }
    }

    // ===================== DAO (all JDBC operations) =====================
    static class ProductDAO {

        boolean addProduct(Product p) throws SQLException {
            String sql = "INSERT INTO product (prod_id, prod_name, prod_price) VALUES (?, ?, ?)";
            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, p.getProdId());
                ps.setString(2, p.getProdName());
                ps.setDouble(3, p.getProdPrice());
                return ps.executeUpdate() > 0;
            }
        }

        List<Product> getAllProducts() throws SQLException {
            String sql = "SELECT prod_id, prod_name, prod_price FROM product ORDER BY prod_id";
            List<Product> list = new ArrayList<>();
            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Product(rs.getInt("prod_id"),
                                         rs.getString("prod_name"),
                                         rs.getDouble("prod_price")));
                }
            }
            return list;
        }

        Product getProductById(int id) throws SQLException {
            String sql = "SELECT prod_id, prod_name, prod_price FROM product WHERE prod_id = ?";
            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return new Product(rs.getInt("prod_id"),
                                           rs.getString("prod_name"),
                                           rs.getDouble("prod_price"));
                    }
                }
            }
            return null;
        }

        boolean updateProduct(Product p) throws SQLException {
            String sql = "UPDATE product SET prod_name = ?, prod_price = ? WHERE prod_id = ?";
            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, p.getProdName());
                ps.setDouble(2, p.getProdPrice());
                ps.setInt(3, p.getProdId());
                return ps.executeUpdate() > 0;
            }
        }

        boolean deleteProduct(int id) throws SQLException {
            String sql = "DELETE FROM product WHERE prod_id = ?";
            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, id);
                return ps.executeUpdate() > 0;
            }
        }
    }

    // ===================== Console UI =====================
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== PRODUCT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Search Product by ID");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            try {
                switch (choice) {
                    case 1: {
                        System.out.print("Product ID   : ");
                        int id = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Product Name : ");
                        String name = sc.nextLine().trim();
                        System.out.print("Product Price: ");
                        double price = Double.parseDouble(sc.nextLine().trim());
                        System.out.println(dao.addProduct(new Product(id, name, price))
                                ? "Product added successfully." : "Failed to add product.");
                        break;
                    }
                    case 2: {
                        List<Product> products = dao.getAllProducts();
                        if (products.isEmpty()) {
                            System.out.println("No products found.");
                        } else {
                            System.out.printf("%-8s %-30s %10s%n", "ID", "NAME", "PRICE");
                            System.out.println("-".repeat(50));
                            products.forEach(System.out::println);
                        }
                        break;
                    }
                    case 3: {
                        System.out.print("Enter Product ID: ");
                        Product p = dao.getProductById(Integer.parseInt(sc.nextLine().trim()));
                        if (p == null) {
                            System.out.println("Product not found.");
                        } else {
                            System.out.printf("%-8s %-30s %10s%n", "ID", "NAME", "PRICE");
                            System.out.println(p);
                        }
                        break;
                    }
                    case 4: {
                        System.out.print("Product ID to update: ");
                        int id = Integer.parseInt(sc.nextLine().trim());
                        if (dao.getProductById(id) == null) {
                            System.out.println("Product not found.");
                            break;
                        }
                        System.out.print("New Name : ");
                        String name = sc.nextLine().trim();
                        System.out.print("New Price: ");
                        double price = Double.parseDouble(sc.nextLine().trim());
                        System.out.println(dao.updateProduct(new Product(id, name, price))
                                ? "Product updated successfully." : "Update failed.");
                        break;
                    }
                    case 5: {
                        System.out.print("Product ID to delete: ");
                        int id = Integer.parseInt(sc.nextLine().trim());
                        System.out.println(dao.deleteProduct(id)
                                ? "Product deleted successfully." : "Product not found.");
                        break;
                    }
                    case 6:
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number entered.");
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }
        }
    }
}