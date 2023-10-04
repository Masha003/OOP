package labtwo.operations;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import labtwo.handlers.GeneralHandler;
import labtwo.models.Faculty;

public class GeneralOperations {
    private List<Faculty> faculties;

    public GeneralOperations(Scanner scanner, List<Faculty> faculties){
        this.faculties = faculties; 
        String nextReq = null;
        String[] reqList = null;
        while(!Objects.equals(nextReq, "b")){
            PrintOperations.printGeneralOperations();
            nextReq = scanner.nextLine();
            reqList = nextReq.split("/");

            switch(reqList[0]){
                case "nf":
                    GeneralHandler.createFaculty(reqList);
                    break;
                case "ss":
                    GeneralHandler.searchStudent(reqList);
                    break;
                case "df":
                    GeneralHandler.displayFaculties(reqList);
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
    }
}
