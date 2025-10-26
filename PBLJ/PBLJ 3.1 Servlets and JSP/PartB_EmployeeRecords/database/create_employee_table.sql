CREATE DATABASE IF NOT EXISTS nimbusdb;
USE nimbusdb;

CREATE TABLE IF NOT EXISTS Employee (
    EmpID INT PRIMARY KEY,
    Name VARCHAR(50),
    Salary DECIMAL(10,2)
);

INSERT INTO Employee VALUES
(101, 'Alice', 55000.00),
(102, 'Bob', 62000.00),
(103, 'Charlie', 48000.00),
(104, 'Diana', 70000.00);
