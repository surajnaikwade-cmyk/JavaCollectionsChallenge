package JavaCollectionsChallenge;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayListManager arrayListManager = new ArrayListManager();
        HashMapManager hashMapManager = new HashMapManager();
        QueueManager queueManager = new QueueManager();

        boolean running = true;

        while (running) {

            System.out.println("\n================================");
            System.out.println("     JAVA COLLECTIONS CHALLENGE");
            System.out.println("================================");
            System.out.println("1. ArrayList - Book Manager");
            System.out.println("2. HashMap - Student Marks Manager");
            System.out.println("3. Queue - Customer Token System");
            System.out.println("4. Exit");
            System.out.println("================================");

            int choice = readChoice(sc, "Enter your choice: ");

            switch (choice) {

                case 1:
                    arrayListMenu(sc, arrayListManager);
                    break;

                case 2:
                    hashMapMenu(sc, hashMapManager);
                    break;

                case 3:
                    queueMenu(sc, queueManager);
                    break;

                case 4:
                    System.out.println(
                        "Thank you for using Java Collections Challenge!"
                    );
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Select between 1 and 4.");
            }
        }

        sc.close();
    }

    // ArrayList menu
    private static void arrayListMenu(
            Scanner sc, ArrayListManager manager) {

        boolean running = true;

        while (running) {

            System.out.println("\n========== BOOK MANAGER ==========");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Update Book");
            System.out.println("4. Search Book");
            System.out.println("5. Display Books");
            System.out.println("6. Back to Main Menu");

            int choice = readChoice(sc, "Enter your choice: ");

            switch (choice) {

                case 1:
                    manager.addBook(sc);
                    break;

                case 2:
                    manager.removeBook(sc);
                    break;

                case 3:
                    manager.updateBook(sc);
                    break;

                case 4:
                    manager.searchBook(sc);
                    break;

                case 5:
                    manager.displayBooks();
                    break;

                case 6:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // HashMap menu
    private static void hashMapMenu(
            Scanner sc, HashMapManager manager) {

        boolean running = true;

        while (running) {

            System.out.println("\n====== STUDENT MARKS MANAGER ======");
            System.out.println("1. Add Student Record");
            System.out.println("2. Retrieve Student Marks");
            System.out.println("3. Update Student Marks");
            System.out.println("4. Check Student ID");
            System.out.println("5. Display All Students");
            System.out.println("6. Back to Main Menu");

            int choice = readChoice(sc, "Enter your choice: ");

            switch (choice) {

                case 1:
                    manager.addStudent(sc);
                    break;

                case 2:
                    manager.searchStudent(sc);
                    break;

                case 3:
                    manager.updateMarks(sc);
                    break;

                case 4:
                    manager.checkStudent(sc);
                    break;

                case 5:
                    manager.displayStudents();
                    break;

                case 6:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Queue menu
    private static void queueMenu(
            Scanner sc, QueueManager manager) {

        boolean running = true;

        while (running) {

            System.out.println("\n====== CUSTOMER TOKEN SYSTEM ======");
            System.out.println("1. Add Customer");
            System.out.println("2. Serve Customer");
            System.out.println("3. View Next Customer");
            System.out.println("4. Display Queue");
            System.out.println("5. Back to Main Menu");

            int choice = readChoice(sc, "Enter your choice: ");

            switch (choice) {

                case 1:
                    manager.addCustomer(sc);
                    break;

                case 2:
                    manager.serveCustomer();
                    break;

                case 3:
                    manager.peekCustomer();
                    break;

                case 4:
                    manager.displayQueue();
                    break;

                case 5:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Safely read menu choices
    private static int readChoice(Scanner sc, String message) {

        while (true) {

            System.out.print(message);

            try {
                return Integer.parseInt(sc.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println(
                    "Invalid input! Please enter a whole number."
                );
            }
        }
    }
}