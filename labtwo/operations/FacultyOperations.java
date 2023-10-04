package labtwo.operations;

import java.util.Scanner;

import labtwo.handlers.FacultyHandler;

public class FacultyOperations {
    public FacultyOperations(Scanner scanner){
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
