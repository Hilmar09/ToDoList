package todolist;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SaveTasks {
    public static void saveTasks(String filePath, ArrayList<String> tasks, ArrayList<Boolean> completedTasks) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        
        // Ensure completedTasks has the same size as tasks
        while (completedTasks.size() < tasks.size()) {
            completedTasks.add(false);
        }

        try (FileWriter writer = new FileWriter(filePath)) {
            TaskWrapper wrapper = new TaskWrapper();
            wrapper.setTasks(tasks);
            wrapper.setCompletedTasks(completedTasks);
            gson.toJson(wrapper, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class TaskWrapper {
        private ArrayList<String> tasks;
        private ArrayList<Boolean> completedTasks;

        public void setTasks(ArrayList<String> tasks) {
            this.tasks = tasks;
        }

        public void setCompletedTasks(ArrayList<Boolean> completedTasks) {
            this.completedTasks = completedTasks;
        }
    }
}
