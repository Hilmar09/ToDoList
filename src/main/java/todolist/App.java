package todolist;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class App {

    static ArrayList<String> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static final String FILE_PATH = "tasks.json";

    public static void main(String[] args) {
        loadTasks(); // Cargar las tareas al inicio

        System.out.println("Hello World! Welcome To task organizer");

        boolean exit = false;

        while (!exit) {
            showMenu();
            String choice = sc.nextLine();

            if ("1".equals(choice)) {
                addTask();
            } else if ("2".equals(choice)) {
                deleteTask();
            } else if ("3".equals(choice)) {
                listTasks();
            } else if ("4".equals(choice)) {
                doneTask();
            } else if ("5".equals(choice)) {
                System.out.println("Exiting application. Goodbye!");
                exit = true;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
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

    private static void addTask() {
        boolean exit = false;

        while (!exit) {
            System.out.print("Enter task name: ");
            String name = sc.nextLine();
            tasks.add(name);
            System.out.println("Task added successfully!");

            System.out.println("¿Quiere introducir una nueva tarea? y: para Sí, n: para No");
            String choiceadd = sc.nextLine();

            if (!"y".equalsIgnoreCase(choiceadd)) {
                exit = true;
                saveTasks();

            }
        }
    }

    private static void deleteTask() {
        if (tasks.isEmpty()) {
            System.out.println("No hay tareas para borrar.");
            return;
        }

        boolean exit = false;

        while (!exit) {
            System.out.println("\nTareas disponibles:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }

            System.out.print("Introduce el número de la tarea que deseas borrar: ");
            int taskNumber = sc.nextInt();
            sc.nextLine(); // Consume newline

            if (taskNumber > 0 && taskNumber <= tasks.size()) {
                String task = tasks.remove(taskNumber - 1);
                System.out.println("Tarea '" + task + "' borrada exitosamente!");

                if (tasks.isEmpty()) {
                    System.out.println("No hay más tareas para borrar.");
                    exit = true;
                } else {
                    System.out.println("¿Quieres borrar otra tarea? y: para Sí, n: para No");
                    String choice = sc.nextLine();
                    if (!"y".equalsIgnoreCase(choice)) {
                        exit = true;
                    }
                }
            } else {
                System.out.println("Número de tarea inválido.");
            }
        }
    }

    private static void listTasks() {
        if (!tasks.isEmpty()){
            for (String task : tasks  ){
                System.out.println("Task: " + task);
            }
        } else {
            System.out.println("No hay tares para mostrar");
        }
    }

    private static void doneTask() {
        System.out.println("Estas en done!");
    }

    private static void saveTasks() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(tasks, writer);
            System.out.println("Tareas guardadas en el archivo " + FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadTasks() {
        try {
            String json = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<String>>(){}.getType();
            tasks = gson.fromJson(json, type);
        } catch (IOException e) {
            // Si hay un error al leer el archivo, se deja la lista de tareas vacía
            System.out.println("No se pudo cargar el archivo de tareas. Creando uno nuevo.");
            tasks = new ArrayList<>();
        }
    }
}
