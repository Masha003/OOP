package labtwo.handlers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import labtwo.models.Faculty;
import labtwo.models.Student;

public class FacultyHandler {
    private static List<Faculty> faculties = new ArrayList<>();

    public void setFaculties(List<Faculty> faculties){
        FacultyHandler.faculties = faculties;
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public static void createStudent(String[] commands){
        if(commands.length != 8){
            System.out.println("Not enought parameters.");
        } 

        String facultyAbbrev = commands[1];
        Faculty faculty = findFacultyByAbbrev(facultyAbbrev);

        if (faculty == null) {
            System.out.println("Faculty with abbreviation " + facultyAbbrev + " not found.");
            return;
        }

        String firstName = commands[2];
        String lastName = commands[3];
        String email = commands[4];
        String birthDay = commands[5] + "/" + commands[6] + "/" + commands[7];
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        Date dateOfBirth;
        try {
            dateOfBirth = formatDate.parse(birthDay);
        } catch (ParseException e) {
            dateOfBirth = new Date();
        }

        Student student = new Student(firstName, lastName, email, new Date(), dateOfBirth, false);
        faculty.enrollStudent(student);
    }

    public static Faculty findFacultyByAbbrev(String abbr){
        for(Faculty faculty : faculties){
            if(faculty.getAbbreviation().equals(abbr)){
                return faculty;
            }
        }
        return null;
    }

    public static Student searchStudentByEmail(String email){
        for(Faculty faculty : faculties){
            for(Student student : faculty.getStudents()){
                if(student.getEmail().equals(email)){
                    return student;
                }
            }
        }
        return null;
    }

    public static void graduateStudent(String[] commands){
        Student student = searchStudentByEmail(commands[1]);

        if(student == null){
            System.out.println("The student with email " + commands[1] + " is not present.");
        }
        
        student.setGraduation(true);
        System.out.println("Student " + student.getFirstName() + " " + student.getLastName() + " successfully graduated!");
    }

    public static void displayEnrolledStudents(String[] commands){
        if(commands.length != 2){
            System.out.println("Not enought parameters.");
        }

        Faculty faculty = findFacultyByAbbrev(commands[1]);
        if(faculty == null){
            System.out.println("Faculty with abbreviation " + commands[1] + " not found.");
            return;
        }

        if(faculty.getStudents().isEmpty()){
            System.out.println("There are no students in this faculty.");
            return;
        }

        StringBuilder studentsString = new StringBuilder();
        studentsString.append("Students from " + faculty.getName() + " \n");
        System.lineSeparator();
        for(Student student : faculty.getStudents()){
            studentsString.append(student);
            studentsString.append("\n");
        }

        System.out.println(studentsString);
    }

    public static void displayGraduatedStudents(String[] commands){
        if(commands.length != 2){
            System.out.println("Not enought parameters.");
        }
        
        Faculty faculty = findFacultyByAbbrev(commands[1]);
        if(faculty == null){
            System.out.println("Faculty with abbreviation " + commands[1] + " not found.");
            return;
        }

        if(faculty.getStudents().isEmpty()){
            System.out.println("There are no students in this faculty.");
            return;
        }

        StringBuilder studentsString = new StringBuilder();
        studentsString.append("Students graduated from " + faculty.getName() + " ");
        System.lineSeparator();
        for(Student student : faculty.getStudents()){
            if(student.isGraduated()){
                studentsString.append(student);
                studentsString.append("\n");
            }
        }

        System.out.println(studentsString);
    }

    public static void checkStudent(String[] commands){
        String facultyAbbrev = commands[1];
        String studentEmail = commands[2];
        Student student = searchStudentByEmail(studentEmail);
        Faculty faculty = findFacultyByAbbrev(facultyAbbrev);

        if(student != null){
            if(faculty != null){
                for(Student stud : faculty.getStudents()){
                    if(stud.equals(student)){
                        System.out.println("Student with email " + studentEmail + " belongs to the " + faculty.getName() + " faculty.");
                        return;
                    }
                }
            } else {
                System.out.println("Faculty does not exist.");
                return;
            }
        } else {
            System.out.println("Student with email " + studentEmail + " does not exist.");
        }

        System.out.println("Student with email " + studentEmail + " does not belong to this faculty.");
    }
}
