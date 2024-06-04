package todolist;

import java.util.ArrayList;
import java.util.Scanner;

public class AddTask {
    public static void addTask(ArrayList<String> tasks, Scanner sc) { 
        boolean exit = false;

        while (!exit) {
            System.out.print("Enter task name: ");
            String name = sc.nextLine();
            tasks.add(name);
            System.out.println("Task added successfully!");

            System.out.print("¿Quiere introducir una nueva tarea? y: para Sí, n: para No:---> ");
            String choiceAdd = sc.nextLine().trim().toLowerCase();

            while (!choiceAdd.equals("y") && !choiceAdd.equals("n")) {
                System.out.println("Respuesta inválida. Por favor, responda con 'y' para Sí o 'n' para No: --->");
                System.out.print("¿Quiere introducir una nueva tarea? y: para Sí, n: para No: --->");
                choiceAdd = sc.nextLine().trim().toLowerCase();
            }

            if (choiceAdd.equals("n")) {
                exit = true;
            }
        }
    }


}
