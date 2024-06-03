package todolist;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SaveTasks {

    @SuppressWarnings("unchecked")
    public static void saveTasks(String filePath, Set<String> tasks) {
        // Crear un objeto JSONParser para leer el archivo JSON existente
        JSONParser parser = new JSONParser();
        JSONArray tasksList = new JSONArray();

        try {
            // Leer el archivo JSON existente
            tasksList = (JSONArray) parser.parse(new FileReader(filePath));
        } catch (IOException | ParseException e) {
            // Si ocurre un error al leer, se asume que el archivo no existe o está vacío
        }

        // Convertir el JSONArray existente a un Set para evitar duplicados
        Set<String> existingTasks = new HashSet<>();
        Iterator<JSONObject> iterator = tasksList.iterator();
        while (iterator.hasNext()) {
            JSONObject taskObject = iterator.next();
            String taskName = (String) taskObject.get("task");
            existingTasks.add(taskName);
        }

        // Añadir las nuevas tareas al Set
        existingTasks.addAll(tasks);

        // Limpiar el JSONArray y volver a añadir todas las tareas
        tasksList.clear();
        for (String task : existingTasks) {
            JSONObject taskObject = new JSONObject();
            taskObject.put("task", task);
            tasksList.add(taskObject);
        }

        // Escribir el JSONArray actualizado en el archivo
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(tasksList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
