package todolist;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LoadTasks {
    public static void loadTasks(String filePath, ArrayList<String> tasks, ArrayList<Boolean> completedTasks) {
        Gson gson = new GsonBuilder().serializeNulls().create(); // Usar GsonBuilder para crear Gson

        try {
            if (Files.exists(Paths.get(filePath))) { // Verificar si el archivo existe
                String json = new String(Files.readAllBytes(Paths.get(filePath)));
                if (!json.isEmpty()) { // Verificar si el archivo no está vacío
                    TaskWrapper wrapper = gson.fromJson(json, TaskWrapper.class);
                    if (wrapper != null) { // Verificar si el wrapper no es nulo
                        if(wrapper.getTasks() != null)
                            tasks.addAll(wrapper.getTasks());
                        if(wrapper.getCompletedTasks() != null)
                            completedTasks.addAll(wrapper.getCompletedTasks());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class TaskWrapper {
        private ArrayList<String> tasks;
        private ArrayList<Boolean> completedTasks;

        public ArrayList<String> getTasks() {
            return tasks;
        }

        public ArrayList<Boolean> getCompletedTasks() {
            return completedTasks;
        }
    }
}
