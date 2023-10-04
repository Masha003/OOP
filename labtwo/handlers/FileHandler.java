package labtwo.handlers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import labtwo.models.Faculty;

public class FileHandler {
    private static String FILE_PATH = "labtwo/data/students_system_data.txt";

    public static void saveData(List<Faculty> faculties){
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            outputStream.writeObject(faculties);
            System.out.println("Data saved to " + FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error saving data: " + e.getMessage());
        }
        
    } 

    public static List<Faculty> loadData() {
        List<Faculty> faculties = new ArrayList<Faculty>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            faculties = (List<Faculty>) inputStream.readObject();
            System.out.println("Data loaded from " + FILE_PATH);
            return faculties;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error loading data: " + e.getMessage());
        }
        
        FacultyHandler facultyHandler = new FacultyHandler();
        facultyHandler.setFaculties(faculties);

        return faculties;
    }
    
}
