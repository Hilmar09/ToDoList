package todolist;
import java.util.ArrayList;
import java.util.Scanner;

public class Exit{
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        ArrayList<Boolean> states = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a task (or type 'exit' to finish): ");
            String task = scanner.nextLine();

            if (task.equalsIgnoreCase("exit")) {
                break;
            }

            tasks.add(task);
            states.add(false); 
        }

        System.out.println("List of tasks:");
        for (String task : tasks) {
            System.out.println("- " + tasks);
        }

        scanner.close();
    }
}
