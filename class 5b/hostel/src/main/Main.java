package main;

import domain.Student;
import observer.AdminObserver;
import observer.Notifier;
import observer.StudentObserver;
import pipefilter.DistanceFilter;
import pipefilter.FeeFilter;
import pipefilter.Pipe;
import service.RoomService;
import service.ServiceSelection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize an array of students with different distances and eligibility criteria
        Student[] students = new Student[] {
            new Student("John Doe", 60, true), // Eligible (Paid fee)
            new Student("Jane Smith", 45, false), // Not eligible (Unpaid fee)
            new Student("Mark Johnson", 80, true) // Eligible (Paid fee)
        };

        // Create observers
        AdminObserver admin = new AdminObserver();
        Notifier notifier = new Notifier();
        notifier.addObserver(admin);  // Admin always receives notifications

        // Create Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Loop through each student and process their application manually
        for (Student student : students) {
            // Create a student-specific observer
            StudentObserver studentObserver = new StudentObserver(student.getName());
            notifier.addObserver(studentObserver); // Add student observer for notifications

            // Pipe and Filter for each student
            Pipe pipe = new Pipe();
            pipe.addFilter(new DistanceFilter(50));  // Distance threshold of 50 km
            pipe.addFilter(new FeeFilter());  // Fee filter

            // Step 1: Application process - Notify that a new application is received
            System.out.println("\nProcessing application for " + student.getName());
            notifier.notifyObservers("New application received for " + student.getName());

            // Step 2: Process application and check eligibility
            System.out.println("Checking eligibility for " + student.getName());
            boolean eligible = pipe.process(student);
            if (!eligible) {
                // Notify admin and student that the student is not eligible
                notifier.notifyObservers(student.getName() + " is not eligible.");
                notifier.removeObserver(studentObserver);  // Remove student observer if not eligible
                System.out.println(student.getName() + " is not eligible for hostel.");
                continue; // Skip to next student if not eligible
            }

            // Step 3: Notify that the student is eligible
            System.out.println(student.getName() + ", you are eligible!");
            notifier.notifyObservers(student.getName() + " is eligible.");

            // **Manual Intervention Step: Room Selection**
            System.out.print("Please select your room (Luxury/Simple): ");
            String roomType = scanner.nextLine();
            student.setRoomType(roomType.equalsIgnoreCase("Luxury") ? "Luxury" : "Simple");

            // **Manual Intervention Step: Fee Payment**
            System.out.print("Have you paid the fee? (yes/no): ");
            String feePaid = scanner.nextLine();
            student.setFeePaid(feePaid.equalsIgnoreCase("yes"));

            // Notify about room and payment selection
            notifier.notifyObservers("Fee paid and room selected for " + student.getName());

            // **Manual Intervention Step: Room Assignment**
            RoomService roomService = new RoomService();
            roomService.assignRoom(student);
            notifier.notifyObservers("Room assigned to " + student.getName());

            // **Manual Intervention Step: Select Additional Services**
            System.out.println("Select additional services (Food, Ironing, Washing):");
            System.out.print("Food (yes/no): ");
            boolean food = scanner.nextLine().equalsIgnoreCase("yes");
            System.out.print("Ironing (yes/no): ");
            boolean ironing = scanner.nextLine().equalsIgnoreCase("yes");
            System.out.print("Washing (yes/no): ");
            boolean washing = scanner.nextLine().equalsIgnoreCase("yes");

            // Select services
            ServiceSelection serviceSelection = new ServiceSelection();
            serviceSelection.selectServices(student, food, ironing, washing);

            // Notify that services are confirmed
            notifier.notifyObservers("Services confirmed for " + student.getName());

            // Remove the student observer after processing to avoid further notifications
            notifier.removeObserver(studentObserver);
        }

        // Close the scanner
        scanner.close();
    }
}
