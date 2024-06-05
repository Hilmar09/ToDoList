package todolist;

import java.util.ArrayList;
import java.util.Scanner;

public class MarkCompledTasks {
    public static void markCompletedTasks(ArrayList<String> tasks, ArrayList<Boolean>completedTask, Scanner sc) {
        System.out.println("========================================================");
        System.out.println("TASKS LIST:");
        System.out.println("");

        int index = 1;
        for (String task : tasks) {
            System.out.println(index + ". " + task);
            index++;
        }

        System.out.print("Write the number of the task to mark as completed: ");
        int completeTaskIndex = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        if (completeTaskIndex > 0 && completeTaskIndex <= tasks.size()) {
            String taskToMark = tasks.get(completeTaskIndex - 1);
            System.out.println("========================================================");
            System.out.println("MARKED TASK AS COMPLETED: " + taskToMark);
            System.out.println("========================================================");
        } else {
            System.out.println("Invalid task number. Please try again.");
        }
    }
}
