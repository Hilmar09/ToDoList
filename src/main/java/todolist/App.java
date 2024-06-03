package todolist;

import java.util.Scanner;

public final class App {
    static final String FILE_PATH = "tasks.json";
    static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        try (sc) {
            System.out.println("Hello World! Welcome To task organizer");
            
            boolean exit = false;
            
            while (!exit) {
                showMenu();
                String choice = sc.nextLine();
                
                switch (choice) {
                    case "1" -> AddTask.addTask();
                    case "2" -> {
                    }
                    case "3" -> {
                    }
                    case "4" -> {
                    }
                    case "5" -> {
                        System.out.println("Exiting application. Goodbye!");
                        exit = true;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
                // Lógica para borrar tarea
                // Lógica para listar tareas
                // Lógica para marcar tarea como completada
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
