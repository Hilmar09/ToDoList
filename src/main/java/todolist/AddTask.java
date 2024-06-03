package todolist;



import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AddTask {
    private static final Scanner sc = new Scanner(System.in);
    private static final Set<String> tasks = new HashSet<>();


    public static void addTask() {
        boolean exit = false;

        while (!exit) {
            System.out.print("Enter task name: ");
            String name = sc.nextLine();
            tasks.add(name);
            System.out.println("Task added successfully!");

            System.out.print("¿Quiere introducir una nueva tarea? y: para Sí, n: para No:---> ");
            String choiceadd = sc.nextLine().trim().toLowerCase(); 
            
            while (!choiceadd.equals("y") && !choiceadd.equals("n")) {
                System.out.println("Respuesta inválida. Por favor, responda con 'y' para Sí o 'n' para No: --->");
                System.out.print("¿Quiere introducir una nueva tarea? y: para Sí, n: para No: --->");
                choiceadd = sc.nextLine().trim().toLowerCase(); 
            }

            if (choiceadd.equals("n")) {
                exit = true;
                SaveTasks.saveTasks(App.FILE_PATH, tasks);
                
            }
        }
    }
}
