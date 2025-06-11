import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {

    private static final ArrayList<String> tasks = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = getUserChoice();
            handleUserChoice(choice);
        } while (choice != 4);

        System.out.println("Goodbye! 👋");
    }

    private static void printMenu() {
        System.out.println("\n===== TO-DO LIST MENU =====");
        System.out.println("1. Add Task");
        System.out.println("2. View All Tasks");
        System.out.println("3. Remove Task");
        System.out.println("4. Exit");
        System.out.print("Choose an option (1-4): ");
    }

    private static int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next(); // clear invalid input
        }
        return scanner.nextInt();
    }

    private static void handleUserChoice(int choice) {
        scanner.nextLine(); // consume newline
        switch (choice) {
            case 1:
                addTask();
                break;
            case 2:
                viewTasks();
                break;
            case 3:
                removeTask();
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid option. Try again.");
        }
    }

    private static void addTask() {
        System.out.print("Enter task description: ");
        String task = scanner.nextLine().trim();
        if (!task.isEmpty()) {
            tasks.add(task);
            System.out.println("Task added!");
        } else {
            System.out.println("Task cannot be empty.");
        }
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }
        System.out.println("\nYour Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, tasks.get(i));
        }
    }

    private static void removeTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to remove.");
            return;
        }

        System.out.print("Enter task number or exact name to remove: ");
        String input = scanner.nextLine().trim();

        try {
            int index = Integer.parseInt(input);
            if (index >= 1 && index <= tasks.size()) {
                System.out.println("Removed: " + tasks.remove(index - 1));
            } else {
                System.out.println("Invalid index.");
            }
        } catch (NumberFormatException e) {
            if (tasks.remove(input)) {
                System.out.println("Task removed successfully.");
            } else {
                System.out.println("Task not found.");
            }
        }
    }
}
