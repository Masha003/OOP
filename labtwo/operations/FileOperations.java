package labtwo.operations;

import java.util.Scanner;

import labtwo.handlers.FacultyHandler;

public class FileOperations {
    public FileOperations(Scanner scanner){
        String nextReq = null;
        String[] reqList = null;
        PrintOperations.printFacultyOperations();
        nextReq = scanner.nextLine();
        reqList = nextReq.split("/");

        switch(reqList[0]){
            case "sd":
                // FacultyHandler.createStudent(reqList);
                // save data function
                break;
            case "rd":
                // read data from file
                // FacultyHandler.graduateStudent(reqList);
                break;
            case "res": 
                // restore data from file
                // FacultyHandler.displayEnrolledStudents(reqList);
                break;
            case "rs": 
                // read all students from file
                // FacultyHandler.displayGraduatedStudents(reqList);
                break;
            case "rg": 
                // read graduated students from file
                // FacultyHandler.checkStudent(reqList);
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
