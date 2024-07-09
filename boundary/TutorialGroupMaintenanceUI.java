
//Author: Kam Bee Foong

package boundary;

import entity.Student;
import entity.TutorialGroup;
import java.util.Scanner;

public class TutorialGroupMaintenanceUI {

    Scanner scanner = new Scanner(System.in);

    public int getMenuChoice() {
        System.out.println("\n=================================================");
        System.out.println("|TUTORIAL GROUP MAINTENANCE MENU                |");             
        System.out.println("=================================================");
        System.out.println("|1.| Add a student to a tutorial group          |");
        System.out.println("|2.| Remove a student from a tutorial group     |");
        System.out.println("|3.| Change the tutorial group for a student    |");
        System.out.println("|4.| Find a student in a tutorial group         |");
        System.out.println("|5.| List all students in a tutorial group      |");
        System.out.println("|6.| Filter tutorial groups based on alphabet   |");
        System.out.println("|7.| Generate student enrollment report         |");
        System.out.println("|0.| Quit                                       |");
        System.out.println("=================================================");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
    }
    
    public void listAllTutorialGroups(String outputStr) {
    System.out.println("\nList of Tutorial Groups:\n" + outputStr);
}
    
    public String inputStudentID() {
        System.out.print("Enter student ID: ");
        String studentID = scanner.nextLine();
        return studentID;
    }

    public String inputGroupID() {
        System.out.print("Enter group ID: ");
        String groupID = scanner.nextLine();
        return groupID;
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }

    public void printSuccessMessage(String successMessage) {
        System.out.println(successMessage);
    }

    public void printTutorialGroupDetails(TutorialGroup group) {
        System.out.println("Tutorial Group Details");
        System.out.println("Group ID: " + group.getGroupID());
        System.out.println("Faculty Name: " + group.getFacultyName());
        System.out.println("Programme Name: " + group.getProgrammeName());
        System.out.println("Number of Students: " + group.getNumberOfStudents());
    }

    public void printStudentDetails(Student student) {
        System.out.println("Student Details");
        System.out.println("Student ID: " + student.getStudentID());
        System.out.println("Name: " + student.getName());
        System.out.println("Gender: " + student.getGender());
    }

    public TutorialGroup inputTutorialGroupDetails() {
        scanner.nextLine();
        String groupID = inputGroupID();
        System.out.print("Enter faculty name: ");
        String facultyName = scanner.nextLine();
        System.out.print("Enter programme name: ");
        String programmeName = scanner.nextLine();
        return new TutorialGroup(groupID, facultyName, programmeName);
    }
    
    public Student inputStudentDetails() {
    String studentID = inputStudentID();
    System.out.print("Enter student name: ");
    String studentName = scanner.nextLine();
    System.out.print("Enter gender name (M/F): ");
    char gender = scanner.next().charAt(0);

    return new Student(studentID, studentName, gender);
}

}

