//Author: Kam Bee Foong
package control;

import adt.MapInterface; // Import your MapInterface when it's ready
import adt.TreeMap; // Import your TreeMap when it's ready
import boundary.TutorialGroupMaintenanceUI;
import entity.Student;
import entity.TutorialGroup;
import java.util.Scanner;
import utility.MessageUI;

public class TutorialGroupMaintenance {

    private MapInterface<Student, TutorialGroup> tutorialGroupMap = new TreeMap<>();
    private MapInterface<String, Student> studentMap = new TreeMap<>();
    private MapInterface<String, TutorialGroup> groupMap = new TreeMap<>();
    private final TutorialGroupMaintenanceUI tutorialGroupUI = new TutorialGroupMaintenanceUI();

    public TutorialGroupMaintenance() {
        // Creating students
        Student student1 = new Student("S001", "Tan Joe Yee", 'F');
        Student student2 = new Student("S002", "Lim Kheng Lian", 'M');
        Student student3 = new Student("S003", "Joseph", 'M');
        Student student4 = new Student("S004", "Janice", 'F');

        // Creating tutorial groups
        TutorialGroup group1 = new TutorialGroup("RSW1", "FOCS", "SOFTWARE ENGINEERING");
        TutorialGroup group2 = new TutorialGroup("RSW2", "FOCS", "DATA SCIENCE");
        TutorialGroup group3 = new TutorialGroup("RIB1", "FAFB", "INTERNATIONAL BUSINESS");

        studentMap.put(student1.getStudentID(), student1);
        studentMap.put(student2.getStudentID(), student2);
        studentMap.put(student3.getStudentID(), student3);
        studentMap.put(student4.getStudentID(), student4);

        groupMap.put(group1.getGroupID(), group1);
        groupMap.put(group2.getGroupID(), group2);
        groupMap.put(group3.getGroupID(), group3);

        tutorialGroupMap.put(student1, group1);
        tutorialGroupMap.put(student2, group1);
        tutorialGroupMap.put(student3, group2);

    }

    public void runTutorialGroupMaintenance() {
        int choice = 0;
        do {
            choice = tutorialGroupUI.getMenuChoice();
            switch (choice) {
                case 0:
                    MessageUI.displayExitMessage();
                    break;
                case 1:
                    //Added student to the tutorial group
                    tutorialGroupUI.listAllTutorialGroups(getAllTutorialGroup());

                    addStudentToGroup();
                    break;
                case 2:
                    //Remove student from the group
                    removeStudentFromGroup();
                    break;
                case 3:
                    //Change the tutorial group of the student
                    tutorialGroupUI.listAllTutorialGroups(getAllTutorialGroup());

                    changeGroupForStudent();
                    tutorialGroupUI.listAllTutorialGroups(getAllTutorialGroup());
                    break;
                case 4:
                    //Find the student in which tutorial group
                    findStudentInGroup();
                    break;
                case 5:
                    //List all student that belongs to a group

                    listStudentsInGroup();
                    break;
                case 6:
                    //Filter the group based on the entered
                    filterGroup();
                case 7:
                    generateEnrollReport();
                    break;
                default:
                    MessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != 0);
    }

    public void addStudentToGroup() {

        Student student = (Student) tutorialGroupUI.inputStudentDetails();
        studentMap.put(student.getStudentID(), student);
        System.out.println(studentMap.contains(student.getStudentID()));
        TutorialGroup group = (TutorialGroup) tutorialGroupUI.inputTutorialGroupDetails();
        groupMap.put(group.getGroupID(), group);
        tutorialGroupMap.put(student, group);
        System.out.println("Added successfully!");
    }

    public void removeStudentFromGroup() {
        String studentID = tutorialGroupUI.inputStudentID();
        if (studentMap.contains(studentID)) {
            Student stud = studentMap.get(studentID);
            if (tutorialGroupMap.contains(stud)) {
                tutorialGroupMap.remove(stud);
                System.out.println("The student done removed!");
            } else {
                tutorialGroupUI.printErrorMessage("Student not found in any group.");
            }
        } else {
            tutorialGroupUI.printErrorMessage("Don't have this student");
        }
    }

    public void changeGroupForStudent() {
        String studentID = tutorialGroupUI.inputStudentID();
        Student student = studentMap.get(studentID);

        if (student != null) {
            if (tutorialGroupMap.contains(student)) {
                System.out.println("Current tutorial group: " + tutorialGroupMap.get(student).getGroupID());
                System.out.println("Please enter the new group. ");
                String newGroupID = tutorialGroupUI.inputGroupID();
                TutorialGroup newgroup = groupMap.get(newGroupID);
                if (newgroup != null) {

                    tutorialGroupMap.remove(student);
                    tutorialGroupMap.put(student, newgroup);
                } else {
                    System.out.println("Tutorial group not exist.");

                }
            } else {
                System.out.println("Student is not in any tutorial group");
            }
        } else {
            tutorialGroupUI.printErrorMessage("Student not exist.");
        }
    }

    public void findStudentInGroup() {
        String studentID = tutorialGroupUI.inputStudentID();
        if (studentMap.contains(studentID)) {
            Student stud = studentMap.get(studentID);
            if (tutorialGroupMap.contains(stud)) {
                System.out.println("The student is in the " + tutorialGroupMap.get(stud));
            } else {
                tutorialGroupUI.printErrorMessage("Student not found in any group.");
            }
        } else {
            System.out.println("Student not exist.");
        }
    }

    public void listStudentsInGroup() {
        String groupID = tutorialGroupUI.inputGroupID();
        TutorialGroup tut = groupMap.get(groupID);
        if (groupMap.get(groupID) != null) {
            for (int i = 0; i < studentMap.size(); i++) {
                if (tutorialGroupMap.get(studentMap.getValue(i)) != null) {
                    if (tutorialGroupMap.get(studentMap.getValue(i)).equals(tut)) {
                        System.out.println(studentMap.getValue(i).toString());
                    }
                }
            }
        } else {
            tutorialGroupUI.printErrorMessage("This group is not exist.Please enter again.");
        }
    }

    public void filterGroup() {

        String groupID = tutorialGroupUI.inputGroupID();
        groupID = groupID.toLowerCase();
        for (int i = 0; i < groupMap.size(); i++) {
            if (groupMap.getValue(i).getGroupID().toLowerCase().contains(groupID)) {
                System.out.println(groupMap.getValue(i).toString());
            }
        }
    }

    public void generateEnrollReport() {
        System.out.println("Enrollment Report");

        int totalEnrollment = 0;
        int totalMaleCount = 0;
        int totalFemaleCount = 0;

        for (int i = 0; i < groupMap.size(); i++) {
            int maleCount = 0; // Counter for male students
            int femaleCount = 0; // Counter for female students
            TutorialGroup tut = groupMap.getValue(i);
            System.out.println("\n");
            System.out.println(tut.getGroupID());
            for (int index = 0; index < studentMap.size(); index++) {
                Student stud = studentMap.getValue(index);
                if (tutorialGroupMap.get(stud) != null && tutorialGroupMap.get(stud).equals(tut)) {
                    if (stud.getGender() == 'M') {
                        maleCount += 1;
                        totalMaleCount += 1;
                        totalEnrollment += 1;

                    } else {
                        femaleCount += 1;
                        totalFemaleCount += 1;
                        totalEnrollment += 1;
                    }
                }
            }
            System.out.println("Total male for this tutorial group :" + maleCount);
            System.out.println("Total female for this tutorial group :" + femaleCount);

        }

        System.out.println("========================================================");
        System.out.println("Total male that in all tutorial group :" + totalMaleCount);
        System.out.println("Total female that in all tutorial group :" + totalFemaleCount);
        System.out.println("Total student that in all tutorial group :" + totalEnrollment);
        System.out.println("========================================================");

    }

    public String getAllTutorialGroup() {
        String outputStr = "";
        for(int i = 0;i < groupMap.size();i++)
        {
            TutorialGroup group = groupMap.getValue(i);
                        outputStr += group + "\n";

        }
        return outputStr;
    }

    public int getMaleCount(String groupID) {
        int count = 0;
        TutorialGroup group = groupMap.get(groupID);
        if (group != null) {
            for (int i = 0; i < studentMap.size(); i++) {
                Student studentList = studentMap.getValue(i);
//            for (Student studentList : studentMap.values()) {

                if (studentList.getGender() == 'M') {
                    count++;
                } else {
                    tutorialGroupUI.printErrorMessage("Group is not found.");
                }
            }

        }
        return count;
    }

    public int getFemaleCount(String groupID) {
        int count = 0;
        TutorialGroup group = groupMap.get(groupID);
        if (group != null) {
            for (int i = 0; i < studentMap.size(); i++) {
                Student studentList = studentMap.getValue(i);
//            for (Student studentList : studentMap.values()) {1.

                if (studentList.getGender() == 'F') {
                    count++;
                } else {
                    tutorialGroupUI.printErrorMessage("Group is not found.");
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        // Creating students
        Student student1 = new Student("S001", "Tan Joe Yee", 'F');
        Student student2 = new Student("S002", "Lim Kheng Lian", 'M');
        Student student3 = new Student("S003", "Joseph", 'M');

        // Creating tutorial groups
        TutorialGroup group1 = new TutorialGroup("RSW1", "FOCS", "SOFTWARE ENGINEERING");
        TutorialGroup group2 = new TutorialGroup("RDS1", "FOCS", "DATA SCIENCE");
        TutorialGroup group3 = new TutorialGroup("RIB", "FAFB", "INTERNATIONAL BUSINESS");

        // Adding students to tutorial groups
        group1.addStudent(student1);
        group1.addStudent(student2);
        group3.addStudent(student3);

        TutorialGroupMaintenance tutorialGroupMaintenance = new TutorialGroupMaintenance();
        tutorialGroupMaintenance.runTutorialGroupMaintenance();

        // Displaying information
        System.out.println(group1);
        System.out.println(group1.getTutorialGroup());
    }

}
