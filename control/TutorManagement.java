// Author: Tan Kok Wang

package control;

import adt.*;
import boundary.TutorManagementUI;
import dao.TutorDao;
import entity.Tutor;
import java.util.Scanner;
import utility.*;

public class TutorManagement {
    
  private JYListInterface<Tutor> tutorList = new JYArrayList<>();
  private TutorDao tutorDAO = new TutorDao();
  private TutorManagementUI tutorUI = new TutorManagementUI();

  public TutorManagement() {
    tutorList = tutorDAO.retrieveFromFile();
  }
  
   public void runTutorManagement() {
    int choice = 0;
    do {
      choice = tutorUI.getTutorManagementUI();
      switch(choice) {
        case 1:
          addNewTutor();
          break;
        case 2:
          tutorUI.listAllTutor(getAllTutor());
          removeTutor();
          break;
        case 3:
          findTutor();
          break;
        case 4:
          tutorUI.listAllTutor(getAllTutor());
          amendTutorDetails();
          break;
        case 5:
          tutorUI.listAllTutor(getAllTutor());
          break;
        case 6:
          filterTutor();
          break;
        case 7:
          generateRelevantReport();
          break;
        case 8:
          TutorMessageUI.displayExitMessage();
          break;
        default:
          TutorMessageUI.displayInvalidMessage();
      } 
    } while (choice != 8);
  }
 
   
  private void addNewTutor() {
    Tutor newTutor = inputTutorDetails();
    
    // Check if the tutor ID already exists in the list
    boolean idExists = false;
    for (int i = 1; i <= tutorList.getNumberOfEntries(); i++) {
        if (newTutor.getTutorID().equals(tutorList.getEntry(i).getTutorID())) {
            idExists = true;
            break;
        }
    }
    
    if (idExists) {
        TutorMessageUI.displayExistMessage();
    } else {
        //save to list if ID not same
        tutorList.add(newTutor);
        tutorDAO.saveToFile(tutorList);
    }
  }
  
  private void removeTutor() {
    //remove from list if no. matched
    int position = tutorUI.getRemovePosition();
    tutorList.remove(position);
    tutorDAO.saveToFile(tutorList);
  }
   
  private void findTutor() {
    int choice = 0;
    do {
        choice = tutorUI.findTutorUI();
        switch (choice) {
            case 1:
                //successful to find tutor if name matched
                String name = getTutorName();
                boolean found = false;
                for (int i = 1; i <= tutorList.getNumberOfEntries(); i++) {
                    if (name.equals(tutorList.getEntry(i).getTutorName())) {
                        tutorUI.printTutorDetails(tutorList.getEntry(i));
                        found = true;
                    }
                }
                if (!found) {
                    TutorMessageUI.displayNotFoundMessage();
                }
                break;
            case 2:
                //successful to find tutor if ID matched
                String ID = getTutorID();
                boolean foundID = false;
                for (int i = 1; i <= tutorList.getNumberOfEntries(); i++) {
                    if (ID.equals(tutorList.getEntry(i).getTutorID())) {
                        tutorUI.printTutorDetails(tutorList.getEntry(i));
                        foundID = true;
                    }
                }
                if (!foundID) {
                    TutorMessageUI.displayNotFoundMessage();
                }
                break;
            case 3:
                TutorMessageUI.displayExitMessage();
                break;
            default:
                TutorMessageUI.displayInvalidMessage();
                break;
        }
    } while (choice != 3);
}

   
   private void amendTutorDetails() {
    int listSize = tutorList.getNumberOfEntries();

    if (listSize == 0) {
        TutorMessageUI.displayNullMessage();
        return;
    }

    int position;

    do {
        position = tutorUI.getAmendPosition();

        if (position < 1 || position > listSize) {
            TutorMessageUI.displayInvalidMessage();
            System.out.println("Valid position is between 1 and " + listSize + ".");
            System.out.println();
        }
    } while (position < 1 || position > listSize);

    Tutor amendTutor = tutorList.getEntry(position);
    tutorUI.printTutorDetails(amendTutor);
    int choice = 0;
    
    do {
        choice = tutorUI.amendTutorDetailsUI();
        
        if (choice >= 1 && choice <= 5) {
            switch (choice) {
                case 1:
                    //edit tutor name
                    String name = getTutorName();
                    amendTutor.setTutorName(name);
                    break;
                case 2:
                    //edit tutor faculty
                    String faculty = getFaculty();
                    amendTutor.setTutorFaculty(faculty);
                    break;
                case 3:
                    //edit tutor campus
                    String campus = getCampus();
                    amendTutor.setTutorCampus(campus);
                    break;
                case 4:
                    //edit tutor jobtime
                    String jobTime = getJobTime();
                    amendTutor.setTutorJobTime(jobTime);
                    break;
                case 5:
                    TutorMessageUI.displayExitMessage();
                    break;
                default:
                    TutorMessageUI.displayInvalidMessage();
            }
        } else {
            TutorMessageUI.displayInvalidMessage();
        }
    } while (choice != 5);
    
    //save the edited details to list
    tutorDAO.saveToFile(tutorList);
   }

   
 private void filterTutor() {
    int choice = 0;
    String outputStr = "";

    do {
        choice = tutorUI.getFilterUI();
        //Check if tutors were added
        boolean tutorsAdded = false; 

        switch (choice) {
            case 1:
                // Filter tutors by faculty selected
                String faculty = tutorUI.getFacultyUI();

                for (int i = 1; i <= tutorList.getNumberOfEntries(); i++) {
                    if (faculty.equals(tutorList.getEntry(i).getTutorFaculty())) {
                        if (!outputStr.contains(tutorList.getEntry(i).toString())) {
                            outputStr += tutorList.getEntry(i) + "\n";
                            tutorsAdded = true;
                        }
                    }
                }
                break;

            case 2:
                // Filter tutors by campus selected
                String campus = tutorUI.getCampusUI();

                for (int i = 1; i <= tutorList.getNumberOfEntries(); i++) {
                    if (campus.equals(tutorList.getEntry(i).getTutorCampus())) {
                        if (!outputStr.contains(tutorList.getEntry(i).toString())) {
                            outputStr += tutorList.getEntry(i) + "\n";
                            tutorsAdded = true;
                        }
                    }
                }
                break;

            case 3:
                // Filter tutors by jobtime selected
                String jobTime = tutorUI.getJobTimeUI();

                for (int i = 1; i <= tutorList.getNumberOfEntries(); i++) {
                    if (jobTime.equals(tutorList.getEntry(i).getTutorJobTime())) {
                        if (!outputStr.contains(tutorList.getEntry(i).toString())) {
                            outputStr += tutorList.getEntry(i) + "\n";
                            tutorsAdded = true;
                        }
                    }
                }
                break;

            case 4:
                TutorMessageUI.displayExitMessage();
                break;

            default:
                TutorMessageUI.displayInvalidMessage();
                break;
        }

        if (tutorsAdded) {
            // Display the tutors if any were added
            tutorUI.listAllTutor(outputStr);
        } else {
            TutorMessageUI.displayNotFoundMessage();
        }

        // Clear outputStr for the next filter
        outputStr = "";

    } while (choice != 4);
}


   
  private void generateRelevantReport() {
    Scanner scanner = new Scanner(System.in);

    do {
        int choice;
        
        //count number of tutor by campus or faculty
        do {
            System.out.println("Choose the report type:");
            System.out.println("1. Campus Count");
            System.out.println("2. Faculty Count");
            System.out.println("3. Exit");
            System.out.println();
            System.out.print("Enter your choice (1-3): ");

            while (!scanner.hasNextInt()) {
                TutorMessageUI.displayInvalidMessage();
                System.out.println();
                System.out.print("Enter your choice (1-3): ");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice < 1 || choice > 3) {
                TutorMessageUI.displayInvalidMessage();
            }
        } while (choice < 1 || choice > 3);

        switch (choice) {
            case 1:
                countAndPrintCampusTutors();
                break;

            case 2:
                countAndPrintFacultyTutors();
                break;

            case 3:
                TutorMessageUI.displayExitMessage();
                return;

            default:
                TutorMessageUI.displayInvalidMessage();
        }

        int generateAnother;
        do {
            System.out.println();
            System.out.print("Generate another report? (1 for Yes, 2 for No): ");

            while (!scanner.hasNextInt()) {
                TutorMessageUI.displayInvalidMessage();
                System.out.println();
                System.out.print("Generate another report? (1 for Yes, 2 for No): ");
                scanner.next();
            }

            generateAnother = scanner.nextInt();
            scanner.nextLine();

            if (generateAnother != 1 && generateAnother != 2) {
                TutorMessageUI.displayInvalidMessage();
            }
        } while (generateAnother != 1 && generateAnother != 2);

        if (generateAnother != 1) {
            break;
        }
    } while (true);
  }

  private void countAndPrintCampusTutors() {
    System.out.println();
    System.out.println("Tutor Count Report (Based on campus):");
    System.out.println();

    //Create an array to store campus names and an array to store campus counts
    String[] campuses = new String[tutorList.getNumberOfEntries()];
    int[] campusCounts = new int[tutorList.getNumberOfEntries()];

    int uniqueCampuses = 0;

    //Loop through the tutor list to count tutors for each campus
    for (int i = 1; i <= tutorList.getNumberOfEntries(); i++) {
        Tutor tutor = tutorList.getEntry(i);
        String campus = tutor.getTutorCampus();

        //Check if this campus has already been counted
        boolean found = false;
        for (int j = 0; j < uniqueCampuses; j++) {
            if (campuses[j].equals(campus)) {
                found = true;
                campusCounts[j]++;
                break;
            }
        }

        //If the campus is not found in the campuses array, add it
        if (!found) {
            campuses[uniqueCampuses] = campus;
            campusCounts[uniqueCampuses] = 1;
            uniqueCampuses++;
        }
    }

    //Print the campus counts
    for (int i = 0; i < uniqueCampuses; i++) {
        System.out.println(campuses[i] + ": " + campusCounts[i] + " tutor(s)");
    }
  }

  private void countAndPrintFacultyTutors() {
    System.out.println();
    System.out.println("Tutor Count Report (Based on faculty):");
    System.out.println();

    //Create an array to store faculty names and an array to store faculty counts
    String[] faculties = new String[tutorList.getNumberOfEntries()];
    int[] facultyCounts = new int[tutorList.getNumberOfEntries()];

    int uniqueFaculties = 0;

    //Loop through the tutor list to count tutors for each faculty
    for (int i = 1; i <= tutorList.getNumberOfEntries(); i++) {
        Tutor tutor = tutorList.getEntry(i);
        String faculty = tutor.getTutorFaculty();

        //Check if this faculty has already been counted
        boolean found = false;
        for (int j = 0; j < uniqueFaculties; j++) {
            if (faculties[j].equals(faculty)) {
                found = true;
                facultyCounts[j]++;
                break;
            }
        }

        //If the faculty is not found in the faculties array, add it
        if (!found) {
            faculties[uniqueFaculties] = faculty;
            facultyCounts[uniqueFaculties] = 1;
            uniqueFaculties++;
        }
    }

    //Print the faculty counts
    for (int i = 0; i < uniqueFaculties; i++) {
        System.out.println(faculties[i] + ": " + facultyCounts[i] + " tutor(s)");
    }
  }

   
   private Tutor inputTutorDetails() {
    String ID = getTutorID();
    String name = getTutorName();
    String campus = getCampus();
    String faculty = getFaculty();
    String jobTime = getJobTime();
    System.out.println();
    return new Tutor(ID, name, campus, faculty, jobTime);
  }
   
   private String getTutorID(){
    String ID = "";
    ID = tutorUI.inputTutorIdUI();
    return ID;
  }
   
   private String getTutorName(){
      String name = "";
      name = tutorUI.inputTutorNameUI();
      return name;
  }
   
  private String getFaculty(){
    String faculty = "";
    faculty = tutorUI.getFacultyUI();
    return faculty;
  }
 
   private String getCampus(){
      String campus = "";
      campus =  tutorUI.getCampusUI();
      return campus;
  }
    private String getJobTime(){
      String jobTime = "";
      jobTime =  tutorUI.getJobTimeUI();
      return jobTime;
  } 
   
  private String getAllTutor() {
    String outputStr = "";
    for (int i = 1; i <= tutorList.getNumberOfEntries(); i++) {
        String list = String.valueOf(i);
      outputStr += list + tutorList.getEntry(i) + "\n";
    }
    return outputStr;
  }
  
  public static void main(String[] args) {
    TutorManagement tutorManagement = new TutorManagement();
    tutorManagement.runTutorManagement();
  }
}

