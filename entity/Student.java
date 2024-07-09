
// Author: Kam Bee Foong

package entity;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Comparable<Student>, Serializable {
    private String studentID;
    private String name;
    private char gender;

    public Student(String studentID, String name, char gender) {
        this.studentID = studentID;
        this.name = name;
        this.gender = gender;
    }

    // Getters and setters for the attributes
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
    
    @Override
    public int compareTo(Student otherStudent) {
     return this.studentID.compareTo(otherStudent.studentID);
    }
    
    @Override
    public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Student student = (Student) obj;
    return studentID.equals(student.studentID);
}
    @Override
    public int hashCode() {
    return Objects.hash(studentID);
}

    @Override
    public String toString() {
    return "Student ID: " + studentID + ", Name: " + name + ", Gender: " + gender;
}
}

