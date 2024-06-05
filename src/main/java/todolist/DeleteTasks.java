package todolist;

import java.util.ArrayList;
import java.util.Scanner;

public class DeleteTasks {
    public static void deleteTask(ArrayList<String> tasks, ArrayList<Boolean> completedTasks, Scanner input) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        while (true) {
            System.out.println("========================================================");
            System.out.println("TASKS LIST:");
            System.out.println("");

            for (int i = 0; i < tasks.size(); i++) {
                String task = tasks.get(i);
                boolean isCompleted = (completedTasks.size() > i) ? completedTasks.get(i) : false;
                System.out.println((i + 1) + ". " + (isCompleted ? "[X] " : "[ ] ") + task);
            }

            System.out.println("========================================================");
            System.out.print("Do you want to delete a task? y/n: ");
            String condition = input.nextLine().trim().toLowerCase();

            if (condition.equals("y")) {
                System.out.print("Write the number: ");
                int removeTaskIndex = input.nextInt();
                input.nextLine(); // Consume the newline character

                if (removeTaskIndex > 0 && removeTaskIndex <= tasks.size()) {
                    tasks.remove(removeTaskIndex - 1);
                    completedTasks.remove(removeTaskIndex - 1);

                    System.out.println("========================================================");
                    System.out.println("DELETE TASK: " + removeTaskIndex);
                } else {
                    System.out.println("Invalid task number. Please try again.");
                }
            } else if (condition.equals("n")) {
                break;
            } else {
                System.out.println("Invalid response. Please answer 'y' or 'n'.");
            }
        }

        // Display final task list
        System.out.println("========================================================");
        System.out.println("FINAL TASKS LIST:");
        System.out.println("");
        for (int i = 0; i < tasks.size(); i++) {
            String task = tasks.get(i);
            boolean isCompleted = (completedTasks.size() > i) ? completedTasks.get(i) : false;
            System.out.println((i + 1) + ". " + (isCompleted ? "[X] " : "[ ] ") + task);
        }
        System.out.println("========================================================");
    }
}
