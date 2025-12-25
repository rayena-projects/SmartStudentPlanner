import java.util.ArrayList;
import java.io.*;

public class Planner {
    private ArrayList<Task> tasks;
    private final String FILE_NAME = "tasks.txt";

    public Planner() {
        tasks = new ArrayList<>();
        loadTasksFromFile();
    }

    public void addTask(Task task) {
        tasks.add(task);
        saveTasksToFile();
    }

    public void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private void saveTasksToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            for (Task task : tasks) {
                writer.write(task.toFileString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

    private void loadTasksFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return; 

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue; 

                String[] parts = line.split("\\|");
                if (parts.length < 3) {
                    System.out.println("Skipping malformed line: " + line);
                    continue; 
                }

                tasks.add(new Task(parts[0], parts[1], parts[2]));
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }
}