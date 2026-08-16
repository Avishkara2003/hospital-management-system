# Hospital Management System

A Java-based Hospital Management System built to demonstrate **DAO (Data Access Object) Pattern**, **Factory Pattern**, JDBC, MySQL, and object-oriented programming.

## Project Overview

This console-based application manages basic hospital operations including patients, doctors, and appointments. The application separates database access from business/model classes using the DAO pattern and uses a Factory class to create DAO implementations.

## Features

- Add and list patients
- Add and list doctors
- Book appointments
- List appointments
- Delete patients, doctors, and appointments
- MySQL database persistence
- JDBC database connectivity
- DAO pattern for data access
- Factory pattern for DAO object creation
- Maven dependency management

## Technologies Used

- Java 17
- JDBC
- MySQL
- Maven
- SQL
- DAO Design Pattern
- Factory Design Pattern
- Object-Oriented Programming

## Project Structure

```text
hospital-management-system/
├── database/
│   └── schema.sql
├── src/main/java/com/avishkar/hospital/
│   ├── config/
│   │   └── DBConnection.java
│   ├── dao/
│   │   ├── PatientDAO.java
│   │   ├── DoctorDAO.java
│   │   ├── AppointmentDAO.java
│   │   └── impl/
│   │       ├── PatientDAOImpl.java
│   │       ├── DoctorDAOImpl.java
│   │       └── AppointmentDAOImpl.java
│   ├── factory/
│   │   └── DAOFactory.java
│   ├── model/
│   │   ├── Patient.java
│   │   ├── Doctor.java
│   │   └── Appointment.java
│   └── Main.java
├── pom.xml
├── .gitignore
└── README.md
```

## Design Patterns

### DAO Pattern
DAO interfaces define database operations, while implementation classes handle JDBC and SQL. This keeps database logic separate from the application models.

### Factory Pattern
`DAOFactory` creates DAO implementations, reducing direct dependency on implementation classes in the main application.

## Setup

1. Install Java 17, Maven, and MySQL.
2. Open MySQL and execute:
   `database/schema.sql`
3. If your MySQL username/password is different, update `DBConnection.java`.
4. Open the project in IntelliJ IDEA, Eclipse, or VS Code.
5. Run the Maven project with:

```bash
mvn clean compile
mvn exec:java
```

## Database

The application uses a MySQL database named `hospital_db` with:

- `patients`
- `doctors`
- `appointments`

## Resume Description

> Built a Java-based Hospital Management System using the DAO pattern for database access and the Factory pattern for object creation, with JDBC and MySQL to provide modular, maintainable, and scalable application architecture.

## Author

**Avishkar Poojary**  
BCA Graduate | Java Developer | QA & Software Testing
