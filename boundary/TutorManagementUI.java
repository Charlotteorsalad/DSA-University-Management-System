// Author: Tan Kok Wang

package boundary;

import entity.Tutor;
import java.util.Scanner;
import utility.*;

public class TutorManagementUI {
    Scanner scanner = new Scanner(System.in);
 
  public int getTutorManagementUI() {    
    int choice = 0;
    boolean isValidChoice = false;
    
    //choose function of tutor management module
    do {
        System.out.println("\nTutor Management ");
        System.out.println("1. Add a new tutor");
        System.out.println("2. Remove a tutor");
        System.out.println("3. Search for a tutor");
        System.out.println("4. Amend a tutor details");
        System.out.println("5. List all tutors");
        System.out.println("6. Filter tutor function");
        System.out.println("7. Generate report");
        System.out.println("8. Exit");
        System.out.println();
        System.out.print("Enter your choice (1-8): ");
        
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice >= 1 && choice <= 8) {
                isValidChoice = true;
            } else {
                TutorMessageUI.displayInvalidMessage();
            }
        } else {
            TutorMessageUI.displayInvalidMessage();
            scanner.nextLine();
        }
    } while (!isValidChoice);
    
    System.out.println();
    return choice;
    }

  public void listAllTutor(String outputStr) {
    //list all tutor details
    System.out.println("\nList of Tutor:\n" +
        "No.\tID\tName\t\t\t\tCampus\t\t\tFaculty\t\t\t\t\t\t\tJobTime\n" + outputStr);
  }

  public void printTutorDetails(Tutor tutor) {
    //display certain tutor details 
    System.out.println("Tutor Details");
    System.out.println("Tutor ID  : " + tutor.getTutorID());
    System.out.println("Tutor Name: " + tutor.getTutorName());
    System.out.println("Campus    : " + tutor.getTutorCampus());
    System.out.println("Faculty   : " + tutor.getTutorFaculty());
    System.out.println("Job Time  : " + tutor.getTutorJobTime());
  }

  public String inputTutorIdUI() {
    System.out.print("Enter Tutor ID: ");
    String ID = scanner.nextLine();
    
    //input not exceed 6 characters
    if (ID.length() > 6) {
        ID = ID.substring(0, 6);
    }
    
    return ID;
  }
   
  public String inputTutorNameUI() {
    String name;
    boolean isValid = false;
    
    //input only allow in characters
    do {
        System.out.print("Enter Tutor name: ");
        name = scanner.nextLine().trim();
        
        if (name.matches("^[a-zA-Z\\s]+$")) {
            isValid = true;
        } else {
            TutorMessageUI.displayInvalidMessage();
        }
    } while (!isValid);

    return name;
  }
  
  public String getFacultyUI() {
    int choice = 0;
    String faculty = "";

    // Assign faculty to tutor
    do {
        System.out.println("\nChoose the Tutor Faculty: ");
        System.out.println("1. Faculty of Accountancy, Finance And Business(FAFB)");
        System.out.println("2. Faculty of Applied Sciences(FOAS)");
        System.out.println("3. Faculty of Built Environment(FOBE)");
        System.out.println("4. Faculty of Computing And Information Technology(FOCS)");
        System.out.println("5. Faculty of Engineering And Technology(FOET)");
        System.out.println();
        System.out.print("Enter your choice (1-5): ");

        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice >= 1 && choice <= 5) {
                faculty = TutorDetails.getFaculty(choice);
            } else {
                TutorMessageUI.displayInvalidMessage();
            }
        } else {
            TutorMessageUI.displayInvalidMessage();
            scanner.nextLine();
        }
    } while (choice < 1 || choice > 5);

    System.out.println();
    return faculty;
  }

  
  public String getCampusUI() {
    int choice = 0;
    String campus = "";
    
    //assign campus to tutor
    do {
        System.out.println("\nChoose the Tutor Campus: ");
        System.out.println("1. Kuala Lumpur Campus");
        System.out.println("2. Penang Branch");
        System.out.println("3. Perak Branch");
        System.out.println("4. Johor Branch");
        System.out.println("5. Pahang Branch");
        System.out.println("6. Sabah Branch");
        System.out.println();
        System.out.print("Enter your choice (1-6): ");
        
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice >= 1 && choice <= 6) {
                campus = TutorDetails.getCampus(choice);
            } else {
                TutorMessageUI.displayInvalidMessage();
            }
        } else {
            TutorMessageUI.displayInvalidMessage();
            scanner.nextLine();
        }
    } while (choice < 1 || choice > 6);
    
    System.out.println();
    return campus;
  }
  
   public String getJobTimeUI() {
    int choice = 0;
    String jobTime = "";
    
    //assign jobtime to tutor
    do {
        System.out.println("\nChoose the Tutor JobTime: ");
        System.out.println("1. Full Time");
        System.out.println("2. Part Time");
        System.out.println();
        System.out.print("Enter your choice (1-2): ");
        
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice == 1 || choice == 2) {
                jobTime = TutorDetails.getJobTime(choice);
            } else {
                TutorMessageUI.displayInvalidMessage();
            }
        } else {
            TutorMessageUI.displayInvalidMessage();
            scanner.nextLine();
        }
    } while (choice != 1 && choice != 2);
    
    System.out.println();
    return jobTime;
   }
   
   public int getFilterUI() {
    int choice = 0;
    
    //filtering function to select tutor by faculty, campus or jobtime
    do {
        System.out.println("\nChoose the details to filter the tutor: ");
        System.out.println("1. Faculty");
        System.out.println("2. Campus");
        System.out.println("3. JobTime");
        System.out.println("4. Exit");
        System.out.println();
        System.out.print("Enter your choice (1-4): ");
        
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice < 1 || choice > 4) {
                TutorMessageUI.displayInvalidMessage();
            }
        } else {
            TutorMessageUI.displayInvalidMessage();
            scanner.nextLine();
        }
    } while (choice < 1 || choice > 4);
    
    System.out.println();
    return choice;
   }
    
   public int findTutorUI(){
    int choice = 0;
    
    //search function to find tutor by Name or ID
    do {
        System.out.println("\nChoose the tutor details to search for the tutor: ");
        System.out.println("1. Name");
        System.out.println("2. ID");
        System.out.println("3. Exit");
        System.out.println();
        System.out.print("Enter your choice (1-3): ");
        
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice < 1 || choice > 3) {
                TutorMessageUI.displayInvalidMessage();
            }
        } else {
            TutorMessageUI.displayInvalidMessage();
            scanner.nextLine();
        }
    } while (choice < 1 || choice > 3);
    
    System.out.println();
    return choice;
   }
    
   public int amendTutorDetailsUI(){
    int choice = 0;
    
    //Edit tutor details by changing name, faculty, campus or jobtime
    do {
        System.out.println("\nChoose the tutor details to amend: ");
        System.out.println("1. Name");
        System.out.println("2. Faculty");
        System.out.println("3. Campus");
        System.out.println("4. Jobtime");
        System.out.println("5. Exit");
        System.out.println();
        System.out.print("Enter your choice (1-5): ");
        
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice < 1 || choice > 5) {
                TutorMessageUI.displayInvalidMessage();
            }
        } else {
            TutorMessageUI.displayInvalidMessage();
            scanner.nextLine();
        }
    } while (choice < 1 || choice > 5);
    
    System.out.println();
    return choice;
   }
    
  public int getRemovePosition() {
    int position;
    while (true) {
        System.out.print("Enter the No. to remove the tutor: ");
        if (scanner.hasNextInt()) {
            position = scanner.nextInt();
            scanner.nextLine(); 
            break; 
        } else {
            TutorMessageUI.displayInvalidMessage();
            System.out.println();
            scanner.nextLine(); 
        }
    }
    return position;
  }

  public int getAmendPosition() {
    int position;
    while (true) {
        System.out.print("Enter the No. to amend the tutor details: ");
        if (scanner.hasNextInt()) {
            position = scanner.nextInt();
            scanner.nextLine();
            break; 
        } else {
            TutorMessageUI.displayInvalidMessage();
            System.out.println();
            scanner.nextLine(); 
        }
    }
    return position;
  }

}
