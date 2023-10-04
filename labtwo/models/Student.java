package labtwo.models;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable{
    private String firstName;
    private String lastName;
    private String email;
    private Date enrollmentDate;
    private Date dateOfBirth;
    private boolean graduated;

    public Student(String firstName, String lastName, String email, Date enrollDate, Date birthDate, boolean grad){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enrollmentDate = enrollDate;
        this.dateOfBirth = birthDate;
        this.graduated = grad;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmail(){
        return email;
    }

    public Date getEnrollmentDate(){
        return enrollmentDate;
    }

    public Date getBirthDate(){
        return dateOfBirth;
    }

    public boolean isGraduated(){
        return graduated;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setEnrollmentDate(Date enrollDate){
        this.enrollmentDate = enrollDate;
    }

    public void setDateOfBirth(Date birthDate){
        this.enrollmentDate = birthDate;
    }

    public void setGraduation(boolean grad){
        this.graduated = grad;
    }
}
