package todolist;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.plaf.nimbus.State;

/* create two functions to list tasks
array string for descriptions
array boolean for state */ 

public class ListTask {
    public static void main(String[] args) {
        String[] tasks = {"Comprar leche", "Pasear al perro", "Tirar la basura", "Cita medica"};
        boolean[] state = {false, true, false, true};
        int size = tasks.length;
        // Call the function to list tasks
        listTasks (tasks, state, size);
    }

    /**
     * @param tasks
     * @param state
     * @param size
     */
    private static void listTasks(String[] tasks, boolean[] state, int size) {
        //Check if the task list is empty
        if (size == 0) {
            //Show message indicating that there are no tasks
            System.out.println("There is no task in the list");
        } 
        else {
            //Loop through the array of tasks
            for (int i = 0; i < size; i++) {
                //Build task status as text string
            String taskstate = state[i] ? "completed" : "no completed";
               System.out.println((i + 1 ) + ": " + tasks[i] + " [" + taskstate + "]");
            }
        }

        }
    }
