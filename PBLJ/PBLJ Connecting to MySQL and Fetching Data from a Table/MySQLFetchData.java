import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLFetchData {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database_name";  // Replace with your DB name
        String username = "your_username";                                // Replace with your DB username
        String password = "your_password";                                // Replace with your DB password

        String query = "SELECT EmpID, Name, Salary FROM Employee";

        try {
            // 1. Load JDBC driver (optional for newer JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish connection
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            // 3. Create statement
            Statement statement = connection.createStatement();

            // 4. Execute query
            ResultSet resultSet = statement.executeQuery(query);

            // 5. Process the result set
            System.out.println("EmpID\tName\t\tSalary");
            System.out.println("-----------------------------------");
            while (resultSet.next()) {
                int empId = resultSet.getInt("EmpID");
                String name = resultSet.getString("Name");
                double salary = resultSet.getDouble("Salary");

                System.out.printf("%d\t%-15s\t%.2f%n", empId, name, salary);
            }

            // 6. Close resources
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
