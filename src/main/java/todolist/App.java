package todolist;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private static boolean task;

    public static void main(String[] args) {
        String FILE_PATH = "tasks.json";
        Scanner sc = new Scanner(System.in); // Se abre al inicio de App
        ArrayList<String> tasks = new ArrayList<>();
        ArrayList<Boolean> completedTask = new ArrayList<>();
        LoadTasks.loadTasks(FILE_PATH, tasks, completedTask);
        System.out.println(task);
        System.out.println("Hello World! Welcome To task organizer");
        boolean exit = false;

        while (!exit) {
            showMenu();
            if (sc.hasNextLine()) {
                String choice = sc.nextLine();
                
                switch (choice) {
                    case "1" -> AddTasks.addTask(tasks, completedTask, sc); 
                    case "2" -> DeleteTasks.deleteTask(tasks, completedTask, sc); 
                    case "3" -> ListTasks.listTasks(tasks, completedTask, sc);
                    case "4" -> MarkCompledTasks.markCompletedTasks(tasks, completedTask, sc);
                    case "5" -> {
                        SaveTasks.saveTasks(FILE_PATH, tasks, completedTask);
                        System.out.println("Exiting application. Goodbye!");
                        exit = true;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        }sc.close();
        
    }

    private static void showMenu() {
        System.out.println("\nMenu");
        System.out.println("Elige la opción que deseas:");
        System.out.println("1 - Add Task");
        System.out.println("2 - Delete Task");
        System.out.println("3 - List Tasks");
        System.out.println("4 - Done Task");
        System.out.println("5 - Quit");
        System.out.print("Enter your choice: ");
    }
}
