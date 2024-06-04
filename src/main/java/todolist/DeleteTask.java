package todolist;

import java.util.ArrayList;
import java.util.Scanner;

public class DeleteTask {
    public static void deleteTask(ArrayList<String> tasks, Scanner sc) { // Recibí el Scanner como parámetro
        System.out.println("========================================================");
        System.out.println("TASKS LIST:");
        System.out.println("");

        int index = 1;
        for (String task : tasks) {
            System.out.println(index + ". " + task);
            index++;
        }

        while (true) {
            System.out.println("========================================================");
            System.out.print("Do you want to delete a task? yes/no: ");
            String condition = sc.nextLine().trim().toLowerCase();

            if (condition.equals("yes")) {
                System.out.print("Write the number: ");
                if (sc.hasNextInt()) {
                int removeTaskIndex = sc.nextInt();
                sc.nextLine(); // Consume the newline character

                    if (removeTaskIndex > 0 && removeTaskIndex <= tasks.size()) {
                        String taskToRemove = tasks.remove(removeTaskIndex - 1);

                        System.out.println("========================================================");
                        System.out.println("DELETE TASK: " + taskToRemove);
                        System.out.println("========================================================");
                        System.out.println("TASKS LIST:");
                        System.out.println("");

                        index = 1;
                        for (String task : tasks) {
                            System.out.println(index + ". " + task);
                            index++;
                        }
                    } 
                }else {
                    System.out.println("Invalid task number. Please try again.");
                }

            } else if (condition.equals("no")) {
                System.out.println("========================================================");
                System.out.println("TASKS LIST:");
                System.out.println("");

                index = 1;
                for (String task : tasks) {
                    System.out.println(index + ". " + task);
                    index++;
                }

                System.out.println("========================================================");
                break;
            } else {
                System.out.println("Invalid response. Please answer 'yes' or 'no'.");
            }
        }
    }
}
