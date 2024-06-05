package todolist;

import java.util.ArrayList;
import java.util.Scanner;

public class ListTask {

    public static void listTasks(ArrayList<String> tasks, ArrayList<Boolean>completedTask,Scanner sc){
        //Scanner input = new Scanner(System.in);
        //ArrayList<String> tasks = new ArrayList<>();
            
           // tasks.add("buy fruits");
           //tasks.add("buy meat");
           // tasks.add("buy fish");
           // tasks.add("buy vegetables");

        System.out.println("========================================================");
        System.out.println("TASKS LIST:");
        System.out.println("");

        for (int i=0; i<tasks.size(); i++){
                
            System.out.println((i+1) +" "+ tasks.get(i));
                
        }
        System.out.println("========================================================");       
    }

}



