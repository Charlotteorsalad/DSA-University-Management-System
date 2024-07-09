// Author: Chai Jia You

package boundary;

import entity.Programme;
import entity.TutorialGroup;
import java.util.*;
import utility.ProgrammeMessageUI;

public class ProgrammeMaintenanceUI {

    Scanner scanner = new Scanner(System.in);

    public int menuInput() {
        int choice = 0;
        boolean success;

        do {
            try {
                System.out.print("Enter choice : ");
                choice = scanner.nextInt();
                success = true;

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter valid input.");
                success = false;

            } finally {
                scanner.nextLine();
            }
        } while (!success);
        return choice;
    }

    public int getProgrammeMenu() {

        System.out.println("\nProgramme Menu");
        System.out.println(" 1. Add new programme");
        System.out.println(" 2. Remove a programme");
        System.out.println(" 3. Find programme");
        System.out.println(" 4. Amend programme details");
        System.out.println(" 5. List all programmes");
        System.out.println(" 6. Add a tutorial group to a programme");
        System.out.println(" 7. Remove a tutorial group from a programme");
        System.out.println(" 8. List all tutorial groups for a programme");
        System.out.println(" 9. Generate reports");
        System.out.println(" 0. Back to main menu");

        return menuInput();
    }

    public int getReportMenu() {

        System.out.println("\nProgramme Report Generation");
        System.out.println(" 1. Programme Tutorial Group Assigned Report");
        System.out.println(" 2. Tutorial Group Assigned Status");
        System.out.println(" 0. Back to main menu");

        return menuInput();
    }

    public int ReportOperationMenu() {
        System.out.println("Report Operation");
        System.out.println("=======================");
        System.out.println("0. Back to report menu");
        System.out.println("1. View Details");
        
        return menuInput();
    }

    public int inputNo() {
        boolean success = true;
        int ans = 0;
        do {
            try {
                System.out.print("Enter Number of the program( -1 to exit): ");
                ans = scanner.nextInt();
                success = true;

                if (ans <= 0 && ans != -1) {
                    System.out.println("Invalid input.");
                    success = false;
                } else if (ans == -1) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                success = false;
            } finally {
                scanner.nextLine();
            }
        } while (!success);
        return ans;
    }

    public String inputTutgroupid() {
        System.out.print("Enter id: ");
        return scanner.nextLine();
    }

    public String inputName() {
        System.out.print("Enter name(-1 to exit): ");
        return scanner.nextLine();
    }

    public int inputDuration() {
        boolean success = true;
        int ans = 0;
        do {
            try {
                System.out.print("Enter duration(without years): ");
                ans = scanner.nextInt();
                success = true;

                if (ans <= 0) {
                    System.out.println("Invalid input. Please enter an integer.");
                    success = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                success = false;
            } finally {
                scanner.nextLine();
            }
        } while (!success);
        return ans;
    }

    public String inputSearch() {
        System.out.print("Search : ");
        return scanner.nextLine();
    }

    public Programme inputProgrammeDetails() {
        //used for add a new programme
        String name = "";
        int duration = 0;
        name = inputName();
        if (!name.equals("-1")) {
            duration = inputDuration();
            System.out.println("");

        }
        return new Programme(name, duration);
    }

    public boolean inputYN(String ask) {
        boolean valid = true;
        String ans = "";
        boolean yn = false;
        do {
            System.out.print("Are you sure you want to " + ask + " (Y\\N)? : ");
            ans = scanner.nextLine().toLowerCase();
            if (ans.contains("yes") || ans.contains("y")) {

                valid = true;
                yn = true;

            } else if (ans.contains("no") || ans.contains("n")) {
                valid = true;
                yn = false;
            } else {
                System.out.println("Invalid input");
                valid = false;
            }
        } while (!valid);
        return yn;
    }

    public String inputNameTut() {
        System.out.print("Name(-1 to exit): ");
        return scanner.nextLine();
    }

    public void listAllProgramme(String outputStr, int number) {
        System.out.println("============================================================");
        System.out.print("Programmes List   ");
        printNumberOfProgramme(number);
        System.out.printf("NO   %-40s DURATION\n", "NAME");
        System.out.print(outputStr);
        if (number == 0) {
            ProgrammeMessageUI.printRedMessage("No Result");
        }
        System.out.println("============================================================");
    }

    public void listProgramme(String outputStr) {
        System.out.println("============================================================");
        System.out.println("Programmes List   ");
        System.out.printf("NO   %-40s DURATION\n", "NAME");
        System.out.print(outputStr);
        System.out.println("============================================================");

    }

    public void listModifyProgramme(String before, String after) {
        System.out.println("============================================================");
        System.out.println("Programmes List   ");
        System.out.printf("NO   %-40s DURATION\n", "NAME");
        System.out.print(before);
        System.out.printf("%-4s%-40s    %s\n", "|", "|", "|");
        System.out.printf("%-4s%-40s    %s\n", "|", "|", "|");
        System.out.println(after);
        System.out.println("============================================================");
    }

    public void listAssignOfProgramme(String outputStr) {
        System.out.println("============================================================");
        System.out.println("Programmes List   ");
        System.out.printf("NO   %-40s DURATION    STATUS\n", "NAME");
        System.out.print(outputStr);
        System.out.println("============================================================");
    }

    public void listTutorialProgmme(Programme prog) {
        System.out.println("");
        System.out.println("Programme Details");
        System.out.println("=================================================================");
        System.out.println("Programme Name : " + prog.getName());
        System.out.println("Duration : " + prog.getDuration() + " Years");
        System.out.println("=================================================================");
        System.out.printf("%-24s\t%33s\n", "Tutorial Assigned", "Faculty Name");
        if (prog.getTutorialGroup().getNumberOfEntries() == 0) {
            System.out.println("           No tutorial group Assigned");
        } else {
            for (int i = 1; i <= prog.getTutorialGroup().getNumberOfEntries(); i++) {
                System.out.printf("%-24s\t%33s\n", prog.getTutorialGroup().getEntry(i).getGroupID(), prog.getTutorialGroup().getEntry(i).getFacultyName());
            }
        }
        System.out.println("=================================================================");
    }

    public void showAvailableTutorialGroup(String output) {
        System.out.printf("%-24s\t%33s\n", "Available Tutorial Group", "Faculty Name");
        if (!output.equals("")) {
            System.out.print(output);
        } else {
            System.out.println("                Not Available Tutorial Group");
        }
        System.out.println("=================================================================");
    }

    public void printNumberOfProgramme(int number) {
        System.out.println("Number of Programme : " + number);
    }

}
