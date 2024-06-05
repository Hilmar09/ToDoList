package todolist;


import java.util.ArrayList;
import java.util.Scanner;



public class taskList {
    public static void main(String[] args) {
        ArrayList<tasks> taskList = new ArrayList<>();
        Scanner sc = new Scanner (System.in);
       

        taskList.add(new tasks("Buy fruits", false));
        taskList.add(new tasks("Buy meat", false));
        taskList.add(new tasks("Buy fish", false));
        taskList.add(new tasks("Buy vegetables", false));
        
        System.out.println("Task list:");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println(i + ". " + taskList.get(i).getName());
        }

        System.out.print("Enter the task number you want to mark as completed: ");
        int taskIndex = sc.nextInt();

        if (taskIndex >= 0 && taskIndex < taskList.size()) {
            taskList.get(taskIndex).setcompleted(true);
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid task index. Please try again.");
        
           
        }
           sc.close();

    }

        }
    
    
  

