# Nimbus Submission: Spring and Hibernate Applications

## Overview

This submission contains three parts demonstrating **Java applications using Spring and Hibernate**:

1. **Part A:** Dependency Injection using Spring with Java-based configuration.  
2. **Part B:** CRUD operations on a `Student` entity using Hibernate ORM with MySQL.  
3. **Part C:** Banking system demonstrating **transaction management** using Spring and Hibernate.  

Each part includes source code, configuration files, and instructions to run the application.

---

## Directory Structure

```

NimbusSubmission/
│
├── PartA_SpringDI/
│   ├── src/main/java/com/example/di/
│   │   ├── config/AppConfig.java
│   │   ├── model/Course.java
│   │   ├── model/Student.java
│   │   └── MainApp.java
│
├── PartB_HibernateCRUD/
│   ├── src/main/java/com/example/hibernatecrud/
│   │   ├── model/Student.java
│   │   ├── dao/StudentDAO.java
│   │   └── MainApp.java
│   └── resources/hibernate.cfg.xml
│
├── PartC_SpringHibernateTransaction/
│   ├── src/main/java/com/example/banking/
│   │   ├── config/AppConfig.java
│   │   ├── model/Account.java
│   │   ├── model/Transaction.java
│   │   ├── dao/AccountDAO.java
│   │   ├── service/BankingService.java
│   │   └── MainApp.java
│   └── resources/hibernate.cfg.xml
│
└── README.md

````

---

## Prerequisites

- **Java 17** or higher  
- **Maven** or manual JAR dependencies (Spring Core, Hibernate ORM, MySQL JDBC Driver)  
- **MySQL** installed and running  
- Database `nimbusdb` created for Parts B and C

---

## Part A: Dependency Injection in Spring

### Description

- Demonstrates **Dependency Injection** using Spring annotations.  
- `Student` depends on `Course`.  
- Java-based configuration using `@Configuration` and `@Bean`.

### How to Run

1. Navigate to `PartA_SpringDI/src/main/java`.  
2. Compile all Java files:

```bash
javac -cp "path_to_spring_jars/*" com/example/di/*.java com/example/di/config/*.java com/example/di/model/*.java
````

3. Run the application:

```bash
java -cp ".:path_to_spring_jars/*" com.example.di.MainApp
```

**Expected Output:**

```
Student Name: John Doe
Enrolled in course: Artificial Intelligence
```

---

## Part B: Hibernate CRUD Operations

### Description

* Performs **Create, Read, Update, Delete** operations on `Student` entity.
* Uses Hibernate ORM with MySQL database.
* Hibernate configuration in `hibernate.cfg.xml`.

### How to Run

1. Make sure MySQL is running and `nimbusdb` exists. Update `hibernate.cfg.xml` with your username/password.
2. Navigate to `PartB_HibernateCRUD/src/main/java`.
3. Compile all Java files:

```bash
javac -cp "path_to_hibernate_jars/*:path_to_jpa_jars/*:path_to_mysql_connector/*" com/example/hibernatecrud/*.java com/example/hibernatecrud/model/*.java com/example/hibernatecrud/dao/*.java
```

4. Run the application:

```bash
java -cp ".:path_to_hibernate_jars/*:path_to_jpa_jars/*:path_to_mysql_connector/*" com.example.hibernatecrud.MainApp
```

**Expected Output:**

* Adds sample students
* Displays all students
* Updates a student
* Deletes a student
* Shows final student list

---

## Part C: Spring + Hibernate Transaction Management

### Description

* Banking system demonstrating **transaction management** using Spring and Hibernate.
* `BankingService` ensures **atomic money transfer** between accounts.
* Uses `@Transactional` annotation for declarative transactions.

### How to Run

1. Make sure MySQL is running and `nimbusdb` exists. Update `hibernate.cfg.xml` with your credentials.
2. Navigate to `PartC_SpringHibernateTransaction/src/main/java`.
3. Compile all Java files:

```bash
javac -cp "path_to_spring_jars/*:path_to_hibernate_jars/*:path_to_jpa_jars/*:path_to_mysql_connector/*" com/example/banking/*.java com/example/banking/config/*.java com/example/banking/dao/*.java com/example/banking/model/*.java com/example/banking/service/*.java
```

4. Run the application:

```bash
java -cp ".:path_to_spring_jars/*:path_to_hibernate_jars/*:path_to_jpa_jars/*:path_to_mysql_connector/*" com.example.banking.MainApp
```

**Expected Output:**

* Creates two accounts
* Performs money transfer
* Prints updated balances
* If transfer fails (e.g., insufficient funds), the transaction is rolled back

---

## Notes

* All Spring beans are configured using **Java-based configuration**; no XML for Spring.
* Hibernate sessions are managed manually in Parts B and C.
* Ensure all dependencies are added to the classpath before compiling and running.
* You can use **Maven** or **Gradle** for easier dependency management.

```

---

## 👨‍💻 Author

Nimbus Submission by
Harsh Kumar
23BCS13912
3rd Year CSE Student
Submitted for: *Spring and Hibernate Applications*
