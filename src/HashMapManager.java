package JavaCollectionsChallenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapManager {

    private HashMap<Integer, Double> students;

    public HashMapManager() {
        students = new HashMap<>();
    }

    // Insert student ID and marks
    public void addStudent(Scanner sc) {
        int id = readInteger(sc, "Enter student ID: ");

        if (id <= 0) {
            System.out.println("Student ID must be positive.");
            return;
        }

        if (students.containsKey(id)) {
            System.out.println("Student ID already exists.");
            return;
        }

        double marks = readMarks(sc);

        if (Double.isNaN(marks)) {
            return;
        }

        students.put(id, marks);
        System.out.println("Student record added successfully!");
    }

    // Retrieve marks using student ID
    public void searchStudent(Scanner sc) {
        int id = readInteger(sc, "Enter student ID: ");

        if (students.containsKey(id)) {
            System.out.println(
                "Student ID: " + id +
                " | Marks: " + students.get(id)
            );
        } else {
            System.out.println("Student record not found.");
        }
    }

    // Update student marks
    public void updateMarks(Scanner sc) {
        int id = readInteger(sc, "Enter student ID: ");

        if (!students.containsKey(id)) {
            System.out.println("Student record not found.");
            return;
        }

        double marks = readMarks(sc);

        if (Double.isNaN(marks)) {
            return;
        }

        students.put(id, marks);
        System.out.println("Student marks updated successfully!");
    }

    // Check whether student ID exists
    public void checkStudent(Scanner sc) {
        int id = readInteger(sc, "Enter student ID: ");

        if (students.containsKey(id)) {
            System.out.println("Student ID exists.");
        } else {
            System.out.println("Student ID does not exist.");
        }
    }

    // Display all student records
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        System.out.println("\n----- STUDENT RECORDS -----");

        for (Map.Entry<Integer, Double> entry : students.entrySet()) {
            System.out.println(
                "Student ID: " + entry.getKey() +
                " | Marks: " + entry.getValue()
            );
        }
    }

    // Read and validate marks
    private double readMarks(Scanner sc) {
        System.out.print("Enter student marks (0-100): ");

        try {
            double marks = Double.parseDouble(sc.nextLine().trim());

            if (!Double.isFinite(marks) || marks < 0 || marks > 100) {
                System.out.println("Marks must be between 0 and 100.");
                return Double.NaN;
            }

            return marks;

        } catch (NumberFormatException e) {
            System.out.println("Invalid marks! Enter a numeric value.");
            return Double.NaN;
        }
    }

    // Read integer safely
    private int readInteger(Scanner sc, String message) {
        while (true) {
            System.out.print(message);

            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a whole number.");
            }
        }
    }
}