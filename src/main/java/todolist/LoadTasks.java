package todolist;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LoadTasks {
    public static void loadTasks(String filePath, ArrayList<String> tasks, ArrayList<Boolean> completed) {
        Gson gson = new Gson();
        try {
            String json = new String(Files.readAllBytes(Paths.get(filePath)));
            ArrayList<String> loadedTasks = gson.fromJson(json, new TypeToken<ArrayList<String>>() {}.getType());
            if (loadedTasks != null) {
                tasks.addAll(loadedTasks);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
