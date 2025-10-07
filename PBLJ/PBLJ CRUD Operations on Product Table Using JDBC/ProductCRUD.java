import java.sql.*;
import java.util.Scanner;

public class ProductCRUD {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/your_database_name"; // replace with your DB
    private static final String username = "your_username";  // replace with your DB username
    private static final String password = "your_password";  // replace with your DB password

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             Scanner scanner = new Scanner(System.in)) {

            connection.setAutoCommit(false);  // Enable transaction management

            int choice;

            do {
                System.out.println("\nProduct Management System");
                System.out.println("1. Create Product");
                System.out.println("2. Read All Products");
                System.out.println("3. Update Product");
                System.out.println("4. Delete Product");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        createProduct(connection, scanner);
                        break;
                    case 2:
                        readProducts(connection);
                        break;
                    case 3:
                        updateProduct(connection, scanner);
                        break;
                    case 4:
                        deleteProduct(connection, scanner);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            } while (choice != 5);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createProduct(Connection conn, Scanner scanner) {
        String insertSQL = "INSERT INTO Product (ProductID, ProductName, Price, Quantity) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            System.out.print("Enter Product ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Product Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Price: ");
            double price = scanner.nextDouble();

            System.out.print("Enter Quantity: ");
            int qty = scanner.nextInt();
            scanner.nextLine();

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setDouble(3, price);
            pstmt.setInt(4, qty);

            int rows = pstmt.executeUpdate();
            conn.commit();

            System.out.println(rows + " product(s) inserted successfully.");

        } catch (SQLException e) {
            try {
                conn.rollback();
                System.out.println("Insertion failed. Transaction rolled back.");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void readProducts(Connection conn) {
        String selectSQL = "SELECT * FROM Product";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {

            System.out.println("\nProductID | ProductName        | Price    | Quantity");
            System.out.println("----------------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("ProductID");
                String name = rs.getString("ProductName");
                double price = rs.getDouble("Price");
                int qty = rs.getInt("Quantity");

                System.out.printf("%-9d | %-18s | %-8.2f | %-8d%n", id, name, price, qty);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching data: " + e.getMessage());
        }
    }

    private static void updateProduct(Connection conn, Scanner scanner) {
        String updateSQL = "UPDATE Product SET ProductName = ?, Price = ?, Quantity = ? WHERE ProductID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
            System.out.print("Enter Product ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter new Product Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter new Price: ");
            double price = scanner.nextDouble();

            System.out.print("Enter new Quantity: ");
            int qty = scanner.nextInt();
            scanner.nextLine();

            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.setInt(3, qty);
            pstmt.setInt(4, id);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                conn.commit();
                System.out.println("Product updated successfully.");
            } else {
                System.out.println("No product found with the given ID.");
                conn.rollback();
            }

        } catch (SQLException e) {
            try {
                conn.rollback();
                System.out.println("Update failed. Transaction rolled back.");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void deleteProduct(Connection conn, Scanner scanner) {
        String deleteSQL = "DELETE FROM Product WHERE ProductID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
            System.out.print("Enter Product ID to delete: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                conn.commit();
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("No product found with the given ID.");
                conn.rollback();
            }

        } catch (SQLException e) {
            try {
                conn.rollback();
                System.out.println("Delete failed. Transaction rolled back.");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("Error: " + e.getMessage());
        }
    }
}
