package PartA_UserLogin.src.com.nimbus.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Hardcoded credentials (can be replaced with DB validation)
        String validUser = "admin";
        String validPass = "12345";

        out.println("<html><body style='font-family:Arial; text-align:center; margin-top:100px;'>");

        if (username.equals(validUser) && password.equals(validPass)) {
            out.println("<h2>Welcome, " + username + "!</h2>");
            out.println("<p>Login successful. You have access to the system.</p>");
        } else {
            out.println("<h3 style='color:red;'>Invalid username or password.</h3>");
            out.println("<a href='login.html'>Try Again</a>");
        }

        out.println("</body></html>");
        out.close();
    }
}
