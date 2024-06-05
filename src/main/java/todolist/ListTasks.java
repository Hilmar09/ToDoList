package todolist;

import java.util.ArrayList;
import java.util.Scanner;

public class ListTasks {
    public static void listTasks(ArrayList<String> tasks, ArrayList<Boolean> completedTask, Scanner sc) {
        System.out.println("========================================================");
        System.out.println("TASKS LIST:");
        System.out.println("");

        int index = 1;
        for (int i = 0; i < tasks.size() ; i++) {
            String task = tasks.get(i);
            boolean isCompleted = completedTask.get(i);
            System.out.println(index + ". " + (isCompleted ? "[X] " : "[ ] ") + task);
            index++;
        }
        System.out.println("========================================================");
    }

}
