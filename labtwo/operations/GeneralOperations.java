package labtwo.operations;

import java.util.Objects;
import java.util.Scanner;

import labtwo.handlers.GeneralHandler;

public class GeneralOperations {
    public GeneralOperations(Scanner scanner){
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
