package labtwo.operations;

import java.util.List;
import java.util.Scanner;

import labtwo.handlers.FacultyHandler;
import labtwo.models.Faculty;

public class FacultyOperations {
    private List<Faculty> faculties;

    public FacultyOperations(Scanner scanner, List<Faculty> faculties){
        this.faculties = faculties; 

        // FacultyHandler facultyHandler = new FacultyHandler(faculties);

        String nextReq = null;
        String[] reqList = null;
        PrintOperations.printFacultyOperations();
        nextReq = scanner.nextLine();
        reqList = nextReq.split("/");

        switch(reqList[0]){
            case "ns":
                FacultyHandler.createStudent(reqList);
                break;
            case "gs":
                FacultyHandler.graduateStudent(reqList);
                break;
            case "ds": //display enrolled students
                FacultyHandler.displayEnrolledStudents(reqList);
                break;
            case "dg": //display graduated students
                FacultyHandler.displayGraduatedStudents(reqList);
                break;
            case "bf": //check if student belongs to faculty
                FacultyHandler.checkStudent(reqList);
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
