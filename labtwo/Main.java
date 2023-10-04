package labtwo;

import java.util.Objects;
import java.util.Scanner;

import labtwo.operations.FacultyOperations;
import labtwo.operations.GeneralOperations;
import labtwo.operations.PrintOperations;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String req = null;
        String[] reqList = null;

        while(!Objects.equals(req, "q")){
            PrintOperations.printMainOperations();
            req = scan.nextLine();
            reqList = req.split("/");

            switch(reqList[0]){
                case "g":
                    new GeneralOperations(scan);
                    break;
                case "f":
                    new FacultyOperations(scan);
                    break;
                case "q":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid request");
                    break;

            }

        }

        scan.close();

    }
    
}
