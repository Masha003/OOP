package labtwo.operations;

import java.util.List;
import java.util.Scanner;

import labtwo.handlers.FacultyHandler;
import labtwo.handlers.FileHandler;
import labtwo.models.Faculty;

public class FileOperations {
    public FileOperations(Scanner scanner){
        String nextReq = null;
        String[] reqList = null;
        PrintOperations.printFileOperations();
        nextReq = scanner.nextLine();
        reqList = nextReq.split("/");

        switch(reqList[0]){
            case "sd":
                saveData();
                break;
            case "ld":
                FileHandler.loadData();
                break;
            case "b":
                break;
            case "q":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid command. \n");
                break;
        }
    }

    private void saveData() {
        FacultyHandler facultyHandler = new FacultyHandler();
        List<Faculty> faculties = facultyHandler.getFaculties();
        FileHandler.saveData(faculties);
        System.out.println("Data saved successfully.");
    }
}
