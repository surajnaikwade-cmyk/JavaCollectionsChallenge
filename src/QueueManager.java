package JavaCollectionsChallenge;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueManager {

    private Queue<String> customers;

    public QueueManager() {
        customers = new LinkedList<>();
    }

    // Add customer to queue
    public void addCustomer(Scanner sc) {
        System.out.print("Enter customer name: ");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Customer name cannot be empty.");
            return;
        }

        customers.offer(name);
        System.out.println("Customer added to queue successfully!");
    }

    // Remove and serve next customer
    public void serveCustomer() {
        String customer = customers.poll();

        if (customer == null) {
            System.out.println("No customers waiting.");
            return;
        }

        System.out.println("Now serving: " + customer);
    }

    // View next customer
    public void peekCustomer() {
        String customer = customers.peek();

        if (customer == null) {
            System.out.println("No customers waiting.");
            return;
        }

        System.out.println("Next customer: " + customer);
    }

    // Display all waiting customers
    public void displayQueue() {
        if (customers.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("\n----- CUSTOMER QUEUE -----");

        int position = 1;

        for (String customer : customers) {
            System.out.println(position + ". " + customer);
            position++;
        }
    }
}