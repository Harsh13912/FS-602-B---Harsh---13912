# 🌩️ Nimbus Submission — Web Applications Using Servlets and JSP

This project contains three independent web applications demonstrating Servlets, JSP, and JDBC for user input handling, database interaction, and dynamic content generation.

Each part can be deployed separately on Apache Tomcat or run together in the same environment.

---

## 📁 Project Structure

Nimbus_WebApp/
│
├── PartA_UserLogin/
│   ├── web/
│   │   ├── login.html
│   │   └── WEB-INF/web.xml
│   └── src/com/nimbus/servlets/LoginServlet.java
│
├── PartB_EmployeeRecords/
│   ├── web/
│   │   ├── employees.html
│   │   └── WEB-INF/web.xml
│   └── src/com/nimbus/servlets/EmployeeServlet.java
│   └── database/create_employee_table.sql
│
├── PartC_AttendancePortal/
│   ├── web/
│   │   ├── attendance.jsp
│   │   ├── success.jsp
│   │   └── WEB-INF/web.xml
│   └── src/com/nimbus/servlets/AttendanceServlet.java
│   └── database/create_attendance_table.sql
│
└── README.md

---

## ⚙️ Requirements

* Apache Tomcat 9.0 or above
* Java JDK 11 or above
* MySQL Server 8.0 or above
* JDBC driver: mysql-connector-j.jar (place in Tomcat’s lib folder)

---

## 🧩 Part A — User Login Using Servlet and HTML

**Objective:** Create a simple login form handled by a Java Servlet.

**Features:**

* HTML form for username and password
* Servlet validates credentials (hardcoded)
* Displays personalized message on success

**How to Run:**

1. Copy the `PartA_UserLogin` folder into Tomcat’s `webapps` directory.
2. Start the Tomcat server.
3. Open `http://localhost:8080/PartA_UserLogin/login.html`.
4. Use credentials:
   Username: admin
   Password: 12345

---

## 🧩 Part B — Display Employee Records (Servlet + JDBC)

**Objective:** Integrate Servlets with a database to display and search employee data.

**Database Table:**
CREATE TABLE Employee (
EmpID INT PRIMARY KEY,
Name VARCHAR(50),
Salary DECIMAL(10,2)
);

**Features:**

* View all employee records
* Search employee by ID
* Results displayed in an HTML table

**How to Run:**

1. Run `create_employee_table.sql` in MySQL to create and populate the Employee table.
2. Update the database username and password in `EmployeeServlet.java`.
3. Copy the `PartB_EmployeeRecords` folder into Tomcat’s `webapps` directory.
4. Start Tomcat and open `http://localhost:8080/PartB_EmployeeRecords/employees.html`.

---

## 🧩 Part C — Student Attendance Portal (JSP + Servlet + JDBC)

**Objective:** Develop a student attendance portal using JSP (frontend) and Servlets (backend).

**Database Table:**
CREATE TABLE Attendance (
StudentID INT,
AttendanceDate DATE,
Status VARCHAR(10)
);

**Features:**

* JSP form for attendance input
* Servlet inserts data into the database
* Success message shown via JSP

**How to Run:**

1. Run `create_attendance_table.sql` in MySQL to create the Attendance table.
2. Update the database username and password in `AttendanceServlet.java`.
3. Copy the `PartC_AttendancePortal` folder into Tomcat’s `webapps` directory.
4. Start Tomcat and open `http://localhost:8080/PartC_AttendancePortal/attendance.jsp`.

---

## 🧠 Concepts Demonstrated

| Part | Concept                                | Technologies Used    |
| ---- | -------------------------------------- | -------------------- |
| A    | Handling HTML form data using Servlets | HTML, Java Servlet   |
| B    | Database integration using JDBC        | HTML, Servlet, MySQL |
| C    | MVC architecture with JSP and Servlet  | JSP, Servlet, MySQL  |

---

## 🚀 Running the Whole Project Together

If you want to run all three parts under a single Tomcat instance:

1. Make sure **MySQL** is running and both `Employee` and `Attendance` tables are created.

2. Place all three folders (`PartA_UserLogin`, `PartB_EmployeeRecords`, `PartC_AttendancePortal`) inside Tomcat’s `webapps` directory.

3. Start Tomcat using `bin/startup.bat` (Windows) or `bin/startup.sh` (Linux/Mac).

4. Access each part from the browser:

   * Part A (Login): `http://localhost:8080/PartA_UserLogin/login.html`
   * Part B (Employees): `http://localhost:8080/PartB_EmployeeRecords/employees.html`
   * Part C (Attendance): `http://localhost:8080/PartC_AttendancePortal/attendance.jsp`

5. Verify database connectivity and credentials in each Servlet file.

---

## 👨‍💻 Author

Nimbus Submission by
Harsh Kumar
23BCS13912
3rd Year CSE Student
Submitted for: *Web Application Development using Servlets & JSP*
