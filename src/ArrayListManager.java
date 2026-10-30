package JavaCollectionsChallenge;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListManager {

    private ArrayList<String> books;

    public ArrayListManager() {
        books = new ArrayList<>();
    }

    // Add a book
    public void addBook(Scanner sc) {
        System.out.print("Enter book title: ");
        String title = sc.nextLine().trim();

        if (title.isEmpty()) {
            System.out.println("Book title cannot be empty.");
            return;
        }

        books.add(title);
        System.out.println("Book added successfully!");
    }

    // Display all books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n----- BOOK LIST -----");

        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    // Search for a book
    public void searchBook(Scanner sc) {
        System.out.print("Enter book title to search: ");
        String title = sc.nextLine().trim();

        if (books.contains(title)) {
            System.out.println("Book found: " + title);
        } else {
            System.out.println("Book not found.");
        }
    }

    // Update a book
    public void updateBook(Scanner sc) {
        if (books.isEmpty()) {
            System.out.println("No books available to update.");
            return;
        }

        displayBooks();

        int index = readBookNumber(sc, "Enter book number to update: ");

        if (index < 1 || index > books.size()) {
            System.out.println("Invalid book number.");
            return;
        }

        System.out.print("Enter new book title: ");
        String newTitle = sc.nextLine().trim();

        if (newTitle.isEmpty()) {
            System.out.println("Book title cannot be empty.");
            return;
        }

        books.set(index - 1, newTitle);
        System.out.println("Book updated successfully!");
    }

    // Remove a book
    public void removeBook(Scanner sc) {
        if (books.isEmpty()) {
            System.out.println("No books available to remove.");
            return;
        }

        displayBooks();

        int index = readBookNumber(sc, "Enter book number to remove: ");

        if (index < 1 || index > books.size()) {
            System.out.println("Invalid book number.");
            return;
        }

        String removedBook = books.remove(index - 1);
        System.out.println("Removed book: " + removedBook);
    }

    // Read an integer safely
    private int readBookNumber(Scanner sc, String message) {
        while (true) {
            System.out.print(message);

            try {
                int number = Integer.parseInt(sc.nextLine().trim());
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a whole number.");
            }
        }
    }
}