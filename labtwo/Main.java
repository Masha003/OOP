package labtwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import labtwo.operations.FacultyOperations;
import labtwo.operations.GeneralOperations;
import labtwo.operations.PrintOperations;

import labtwo.models.Faculty;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String req = null;
        String[] reqList = null;

        List<Faculty> faculties = new ArrayList<>();

        while(!Objects.equals(req, "q")){
            PrintOperations.printMainOperations();
            req = scan.nextLine();
            reqList = req.split("/");

            switch(reqList[0]){
                case "g":
                    new GeneralOperations(scan, faculties);
                    break;
                case "f":
                    new FacultyOperations(scan, faculties);
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
