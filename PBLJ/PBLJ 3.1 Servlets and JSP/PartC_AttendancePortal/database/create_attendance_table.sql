CREATE DATABASE IF NOT EXISTS nimbusdb;
USE nimbusdb;

CREATE TABLE IF NOT EXISTS Attendance (
    StudentID INT,
    AttendanceDate DATE,
    Status VARCHAR(10)
);
