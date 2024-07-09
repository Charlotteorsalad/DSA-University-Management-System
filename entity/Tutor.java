// Author: Tan Kok Wang

package entity;

import java.io.Serializable;

public class Tutor implements Serializable{
    private String ID;
    private String name;
    private String campus;
    private String faculty;
    private String jobTime;

    public Tutor() {
    }

    public Tutor(String ID, String name, String campus, String faculty, String jobTime) {
        this.ID = ID;
        this.name = name;
        this.campus = campus;
        this.faculty = faculty;
        this.jobTime = jobTime;
    }
  
    public void setTutorID(String ID){
        this.ID = ID;
    }
  
    public String getTutorID(){
        return ID;
    }

    public void setTutorName(String name){
        this.name = name;
    }
  
    public String getTutorName(){
        return name;
    }
  
    public void setTutorCampus(String campus){
        this.campus = campus;
    }
  
    public String getTutorCampus(){
        return campus;
    }
  
    public void setTutorFaculty(String faculty){
        this.faculty = faculty;
    }
    
    public String getTutorFaculty(){
        return faculty;
    }
  
    public void setTutorJobTime(String jobTime){
        this.jobTime = jobTime;
    }
  
    public String getTutorJobTime(){
        return jobTime;
    }
  
    @Override
    public String toString() {
        return String.format("\t%-7s %-29s %-22s %-53s %s",
            ID, name, campus, faculty, jobTime);
    }
  
}