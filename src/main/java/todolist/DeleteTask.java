package todolist;

import java.util.ArrayList;
import java.util.Scanner;

public class DeleteTask {
    

        public static void main(String[] args) {
            


            Scanner input = new Scanner(System.in);
            ArrayList<String> tasks = new ArrayList<>();


            
            tasks.add("buy fruits");
            tasks.add("buy meat");
            tasks.add("buy fish");
            tasks.add("buy vegetables");

            System.out.println("========================================================");
            System.out.println("TASKS LIST:");
            System.out.println("");

            for (int i=0; i<tasks.size(); i++){
                
                System.out.println((i+1) +" "+ tasks.get(i));
                
            }
            
        
            while (true) {

            System.out.println("========================================================");
        
            System.out.print("Do you want to delete a task? yes/no: ");
            
            String condition = input.nextLine();

            
            
            if (condition.equals("yes")) {
   
                    System.out.print("Write the number: ");
                    
                    
                    int removeTask=input.nextInt();


                    String tasksRemoved = tasks.remove(removeTask-1);
                    
                    System.out.println("========================================================");
                    System.out.println("DELETE TASK: " + tasksRemoved);
                    System.out.println("========================================================");
                    System.out.println("TASKS LIST:");
                    System.out.println("");
        
        
        
                    for (int i=0; i<tasks.size(); i++){
                        
                        
                        System.out.println((i+1) +" "+ tasks.get(i));
        
                        
                    }
                    
                    
        
                    
                    input.nextLine();
        


            }else if (condition.equals("no")) {
                
                System.out.println("========================================================");
                System.out.println("TASKS LIST:");
                System.out.println("");


                for (int i=0; i<tasks.size(); i++){
                
                
                    System.out.println((i+1) +" "+ tasks.get(i));
                    
                    
                }

                
                System.out.println("========================================================");
                break;
                

            }


        }


            input.close();

        
        }


}
