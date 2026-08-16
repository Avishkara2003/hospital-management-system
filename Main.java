package com.avishkar.hospital;

import com.avishkar.hospital.dao.*;
import com.avishkar.hospital.factory.DAOFactory;
import com.avishkar.hospital.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PatientDAO patientDAO = DAOFactory.getPatientDAO();
    private static final DoctorDAO doctorDAO = DAOFactory.getDoctorDAO();
    private static final AppointmentDAO appointmentDAO = DAOFactory.getAppointmentDAO();

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("       HOSPITAL MANAGEMENT SYSTEM");
        System.out.println("==========================================");

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1" -> addPatient();
                    case "2" -> listPatients();
                    case "3" -> addDoctor();
                    case "4" -> listDoctors();
                    case "5" -> bookAppointment();
                    case "6" -> listAppointments();
                    case "7" -> deletePatient();
                    case "8" -> deleteDoctor();
                    case "9" -> deleteAppointment();
                    case "0" -> running = false;
                    default -> System.out.println("Invalid option. Please try again.");
                }
            } catch (RuntimeException e) {
                System.out.println("Operation failed: " + e.getMessage());
            }
        }

        System.out.println("Thank you for using the Hospital Management System.");
    }

    private static void printMenu() {
        System.out.println("\n1. Add Patient");
        System.out.println("2. List Patients");
        System.out.println("3. Add Doctor");
        System.out.println("4. List Doctors");
        System.out.println("5. Book Appointment");
        System.out.println("6. List Appointments");
        System.out.println("7. Delete Patient");
        System.out.println("8. Delete Doctor");
        System.out.println("9. Delete Appointment");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addPatient() {
        System.out.print("Patient name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        int id = patientDAO.save(new Patient(name, age, gender, phone));
        System.out.println("Patient added successfully. ID = " + id);
    }

    private static void listPatients() {
        List<Patient> patients = patientDAO.findAll();
        System.out.println("\n--- Patients ---");
        if (patients.isEmpty()) System.out.println("No patients found.");
        else patients.forEach(System.out::println);
    }

    private static void addDoctor() {
        System.out.print("Doctor name: ");
        String name = scanner.nextLine();
        System.out.print("Specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        int id = doctorDAO.save(new Doctor(name, specialization, phone));
        System.out.println("Doctor added successfully. ID = " + id);
    }

    private static void listDoctors() {
        List<Doctor> doctors = doctorDAO.findAll();
        System.out.println("\n--- Doctors ---");
        if (doctors.isEmpty()) System.out.println("No doctors found.");
        else doctors.forEach(System.out::println);
    }

    private static void bookAppointment() {
        System.out.print("Patient ID: ");
        int patientId = Integer.parseInt(scanner.nextLine());
        if (patientDAO.findById(patientId) == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Doctor ID: ");
        int doctorId = Integer.parseInt(scanner.nextLine());
        if (doctorDAO.findById(doctorId) == null) {
            System.out.println("Doctor not found.");
            return;
        }

        System.out.print("Appointment date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        System.out.print("Reason: ");
        String reason = scanner.nextLine();

        int id = appointmentDAO.save(new Appointment(patientId, doctorId, date, reason));
        System.out.println("Appointment booked successfully. ID = " + id);
    }

    private static void listAppointments() {
        List<Appointment> appointments = appointmentDAO.findAll();
        System.out.println("\n--- Appointments ---");
        if (appointments.isEmpty()) System.out.println("No appointments found.");
        else appointments.forEach(System.out::println);
    }

    private static void deletePatient() {
        System.out.print("Patient ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println(patientDAO.delete(id) ? "Patient deleted." : "Patient not found.");
    }

    private static void deleteDoctor() {
        System.out.print("Doctor ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println(doctorDAO.delete(id) ? "Doctor deleted." : "Doctor not found.");
    }

    private static void deleteAppointment() {
        System.out.print("Appointment ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println(appointmentDAO.delete(id) ? "Appointment deleted." : "Appointment not found.");
    }
}
