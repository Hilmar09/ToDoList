package todolist;

import java.util.ArrayList;
import java.util.Scanner;

public final class App {

    public static void main(String[] args) {
        String FILE_PATH = "tasks.json";
        Scanner sc = new Scanner(System.in , "UTF-8"); // Se abre al inicio de App
        ArrayList<String> tasks = new ArrayList<>();
        LoadTasks.loadTasks(FILE_PATH, tasks);
        System.out.println("Hello World! Welcome To task organizer");
        boolean exit = false;

        while (!exit) {
            showMenu();
            if (sc.hasNextLine()) {
                String choice = sc.nextLine();
                
                switch (choice) {
                    case "1" -> AddTask.addTask(tasks, sc); // Pasé el Scanner como parámetro
                    case "2" -> DeleteTask.deleteTask(tasks, sc); // Pasé el Scanner como parámetro
                    //case "3" -> ListTasks.listTasks(tasks);
                    //case "4" -> MarkCompletedTask.markTaskCompleted(tasks, sc); // Pasé el Scanner como parámetro
                    case "5" -> {
                        SaveTasks.saveTasks(FILE_PATH, tasks);
                        System.out.println("Exiting application. Goodbye!");
                        exit = true;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        }
        
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
