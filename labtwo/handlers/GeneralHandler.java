package labtwo.handlers;

import java.util.List;

import labtwo.models.StudyField;
import labtwo.models.Faculty;
import labtwo.models.Student;

public class GeneralHandler {
    private static FacultyHandler facultyHandler = new FacultyHandler();
    private static List<Faculty> faculties = facultyHandler.getFaculties();

    public void setFaculties(List<Faculty> faculties) {
        GeneralHandler.faculties = faculties;
    }

    // public void addFaculty(Faculty faculty) {
    //     faculties.add(faculty);
    // }


    public List<Faculty> getFaculties() {
        return faculties;
    }

    public static void createFaculty(String[] commands){
        String facultyName = commands[1];
        String facultyAbbrev = commands[2];
        StudyField field = StudyField.valueOf(commands[3]);
        
        Faculty createdFaculty = new Faculty(facultyName, facultyAbbrev, field);
        System.out.println("Faculty created: " + createdFaculty);

        faculties.add(createdFaculty);
    }

    public static void searchStudent(String[] commands){
        String email = commands[1];
        boolean present = false;
        for(Faculty faculty : faculties){
            for(Student student : faculty.getStudents()){
                if(student.getEmail().equals(email)){
                    present = true;
                    System.out.println("Student with email " + email + " is from the " + faculty + " faculty.\n");
                    System.out.println();
                }
                if(present){
                    break;
                }
            }
            if(present){
                break;
            }
        }
        if(!present){
            System.out.println("Student with email " + email + " doesn't exist.");
            System.out.println();
        }
        
    }

    public static void displayFaculties(String[] commands){
        StringBuilder facultiesString = new StringBuilder();

        if(commands.length == 2){
            boolean facultiesByField = false;

            for(Faculty faculty : faculties){
                if(faculty.getStudyField().equals(StudyField.valueOf(commands[1]))){
                    facultiesString.append(faculty);
                    facultiesString.append("\n");
                    facultiesByField = true;
                }
            }

            if(!facultiesByField){
                System.out.println("Faculty list is empty.");
                System.out.println();
            } else {
                System.out.println("List of faculties: \n");
                System.out.println(facultiesString);
                System.out.println();
            }

        } else if (commands.length == 1){
            if(faculties.isEmpty()){
                System.out.println("There are no faculties.");
                System.out.println();
            } else {
                for(Faculty faculty : faculties){
                    facultiesString.append(faculty);
                    facultiesString.append('\n');
                }

                System.out.println("List of all faculties: ");
                System.out.println(facultiesString);
                System.out.println();
            }
        }
    }
}
