package PartB_EmployeeRecords.src.com.nimbus.servlets;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EmployeeServlet extends HttpServlet {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/nimbusdb";
    private static final String DB_USER = "root";       // change as per your MySQL setup
    private static final String DB_PASS = "password";   // change as per your MySQL setup

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String empid = request.getParameter("empid");
        String viewAll = request.getParameter("all");

        out.println("<html><body style='font-family:Arial; text-align:center;'>");
        out.println("<h2>Employee Records</h2>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

            String query;
            PreparedStatement stmt;

            if (empid != null && !empid.trim().isEmpty()) {
                query = "SELECT * FROM Employee WHERE EmpID = ?";
                stmt = conn.prepareStatement(query);
                stmt.setInt(1, Integer.parseInt(empid));
            } else if (viewAll != null) {
                query = "SELECT * FROM Employee";
                stmt = conn.prepareStatement(query);
            } else {
                out.println("<p>Please use the form to search or view all records.</p>");
                conn.close();
                out.println("</body></html>");
                return;
            }

            ResultSet rs = stmt.executeQuery();

            out.println("<table border='1' style='margin:auto; border-collapse:collapse;'>");
            out.println("<tr><th>EmpID</th><th>Name</th><th>Salary</th></tr>");

            boolean hasData = false;
            while (rs.next()) {
                hasData = true;
                out.println("<tr>");
                out.println("<td>" + rs.getInt("EmpID") + "</td>");
                out.println("<td>" + rs.getString("Name") + "</td>");
                out.println("<td>" + rs.getDouble("Salary") + "</td>");
                out.println("</tr>");
            }

            if (!hasData) {
                out.println("<tr><td colspan='3'>No employee found.</td></tr>");
            }

            out.println("</table>");
            out.println("<br><a href='employees.html'>Back</a>");

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
        }

        out.println("</body></html>");
        out.close();
    }
}
