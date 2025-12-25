import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Planner planner = new Planner();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSmart Student Planner");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter subject: ");
                String subject = scanner.nextLine();

                System.out.print("Enter task description: ");
                String description = scanner.nextLine();

                System.out.print("Enter deadline (dd/mm/yyyy): ");
                String deadline = scanner.nextLine();

                planner.addTask(new Task(subject, description, deadline));
                System.out.println("Task added successfully.");

            } else if (choice == 2) {
                planner.showTasks();

            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;

            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}