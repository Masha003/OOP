package labtwo.models;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String name;
    private String abbreviation;
    private List<Student> students;
    private StudyField studyField;
    
    public Faculty(String name, String abbrev, StudyField studyField){
        this.name = name;
        this.abbreviation = abbrev;
        this.students = new ArrayList<>();
        this.studyField = studyField;
    }

    public Faculty(String facultyName, String facultyAbbreviation, ArrayList<Object> objects, StudyField studyField) {
    }

    public String getName(){
        return name;
    }

    public String getAbbreviation(){
        return abbreviation;
    }

    public List<Student> getStudents(){
        return students;
    }

    public StudyField getStudyField(){
        return studyField;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAbbreviation(String abbrev){
        this.abbreviation = abbrev;
    }

    public void setStudents(List<Student> students){
        this.students = students;
    }

    public void setStudyField(StudyField studyField){
        this.studyField = studyField;
    }    
}
