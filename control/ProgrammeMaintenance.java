// Author: Chai Jia You

package control;

import adt.*;
import boundary.ProgrammeMaintenanceUI;
import entity.*;
import java.awt.BorderLayout;
import java.util.Scanner;
import utility.ProgrammeMessageUI;

public class ProgrammeMaintenance {

    public JYListInterface<Programme> programmeList = new JYArrayList<>();
    private JYListInterface<TutorialGroup> tutGroupList = new JYArrayList<>();
    private JYMapInterface<String, TutorialGroup> groupMap = new JYTreeMap<>();
    private ProgrammeMaintenanceUI programmeUI = new ProgrammeMaintenanceUI();

    public ProgrammeMaintenance() {
        TutorialGroup tut = new TutorialGroup("RSWG5", "2", "3");
        TutorialGroup tut2 = new TutorialGroup("RSWG2", "2", "3");
        TutorialGroup tut3 = new TutorialGroup("RSDG1", "2", "3");
        TutorialGroup tut4 = new TutorialGroup("RSDG2", "2", "3");
        TutorialGroup tut5 = new TutorialGroup("RSDG3", "2", "3");
        TutorialGroup tut6 = new TutorialGroup("RSDG4", "2", "3");
        TutorialGroup tut7 = new TutorialGroup("RSDG5", "2", "3");
        TutorialGroup tut8 = new TutorialGroup("RSDG6", "2", "3");
        groupMap.put(tut.getGroupID(), tut);
        groupMap.put(tut2.getGroupID(), tut2);
        groupMap.put(tut3.getGroupID(), tut3);
        groupMap.put(tut4.getGroupID(), tut4);
        groupMap.put(tut5.getGroupID(), tut5);
        groupMap.put(tut6.getGroupID(), tut6);
        groupMap.put(tut7.getGroupID(), tut7);
        groupMap.put(tut8.getGroupID(), tut8);
        for (int i = 1; i <= groupMap.size(); i++) {
            tutGroupList.add(groupMap.getValue(i));
        }

        programmeList.add(new Programme("Bachelor in software engineering", 1));
        programmeList.getEntry(1).addTutorialGroup(tutGroupList.remove(1));
        programmeList.add(new Programme("Diploma in computer science", 1));
        programmeList.getEntry(2).addTutorialGroup(tutGroupList.remove(2));
        programmeList.add(new Programme("Diploma in internatinoal business", 1));
        programmeList.add(new Programme("Diploma in accounting", 2));
        programmeList.add(new Programme("Diploma in advertising", 3));
        programmeList.add(new Programme("Diploma in Aquaculture", 4));
        programmeList.add(new Programme("Diploma in Banking & Finance", 2));
    }

    public void runProgrammeMaintenance() {
        int choice = 0;
        do {
            choice = programmeUI.getProgrammeMenu();
            System.out.println("\n\n\n\n");
            switch (choice) {
                case 0:
                    //Exit to maine menu
                    break;
                case 1:
                    //Add a programme
                    System.out.println("");
                    System.out.println("============================================================");
                    System.out.println("                        Adding Programme");
                    programmeUI.listAllProgramme(getAllProgramme(), getNumberOfProgramme());
                    addProgramme();

                    break;
                case 2:
                    //Remove a programme
                    //list a programme first 
                    //let the user to ente 1 to end to choose what program need to remove
                    System.out.println("============================================================");
                    System.out.println("                        Removing Programme");
                    programmeUI.listAllProgramme(getAllProgramme(), getNumberOfProgramme());
                    removeProgramme();
                    break;
                case 3:
                    //Find programme
                    System.out.println("============================================================");
                    System.out.println("                        Searching Programme");
                    System.out.println("============================================================");
                    findProgramme();
                    ProgrammeMessageUI.pressEnterToContinue();
                    break;
                case 4:
                    System.out.println("============================================================");
                    System.out.println("                     Amend Programme Details");
                    programmeUI.listAllProgramme(getAllProgramme(), getNumberOfProgramme());
                    modifyProgramme();
                    //Amend programme details
                    break;
                case 5:
                    System.out.println("============================================================");
                    System.out.println("                        Listing All Programme");
                    programmeUI.listAllProgramme(getAllProgramme(), getNumberOfProgramme());
                    ProgrammeMessageUI.pressEnterToContinue();
                    //List all programme
                    break;
                case 6:
                    System.out.println("============================================================");
                    System.out.println("                  Adding Tutorial Group to Programme");
                    addTutGroupToProgramme();
                    //Add a tutorial group to a programme
                    break;
                case 7:
                    System.out.println("============================================================");
                    System.out.println("                 Remove Tutorial Group From A Programme");
                    removeTutGroupFromProgramme();
                    //Remove a tutorial group from a programme
                    break;
                case 8:
                    System.out.println("============================================================");
                    System.out.println("             Listing All Tutorial Groups For A Programme");
                    listAllTutorialLinked();
                    //List all tutorial groups for a programme
                    break;
                case 9:
                    runreportMenu();
                    //Generate reports
                    break;
                default:
                    ProgrammeMessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != 0);
    }

    public void runreportMenu() {
        int choice = 0;
        do {
            choice = programmeUI.getReportMenu();
            switch (choice) {
                case 0:

                    //Exit to maine menu
                    break;
                case 1:
                    //Show how many tutorial group are assigned to each programme
                    ReportShowProgrammeTutorial();
                    break;
                case 2:
                    //Show the status of the tutorial group assigned or not
                    ReportTutorialAssignedStatus();
                    break;
                default:
                    ProgrammeMessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != 0);
    }

    public String getAllProgramme() {

        String outputStr = "";
        for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
            outputStr += String.format("%2d.  %-40s  %d YEARS\n", i, programmeList.getEntry(i).getName(), programmeList.getEntry(i).getDuration());
        }
        return outputStr;
    }

    public String getProgramme(int[] index) {
        String outputStr = "";

        for (int i = 0; i < index.length; i++) {
            if (index[i] != 0) {
                outputStr += String.format("%2d.  %-40s  %d YEARS\n", i + 1, programmeList.getEntry(index[i]).getName(), programmeList.getEntry(index[i]).getDuration());
            }
        }
        return outputStr;
    }

    public String getProgramme(int index, Programme prog) {
        String outputStr = "";
        if (index != -1) {
            outputStr += String.format("%2d.  %-40s  %d YEARS\n", index, programmeList.getEntry(index).getName(), programmeList.getEntry(index).getDuration());
        } else if (prog != null) {
            outputStr += String.format("%2d.  %-40s  %d YEARS\n", 00, prog.getName(), prog.getDuration());
        }
        return outputStr;
    }

    public String getTutorialgroup(TutorialGroup tut) {
        return String.format("%-23s\t%33s\n", tut.getGroupID(), tut.getFacultyName());
    }

    public int getNumberOfProgramme() {
        return programmeList.getNumberOfEntries();
    }

    //add a new programme
    public void addProgramme() {
        Programme newProgramme = programmeUI.inputProgrammeDetails();
        if (!newProgramme.getName().equals("-1")) {
            if (programmeList.getExits(newProgramme.getName()) != null) {
                ProgrammeMessageUI.printRedMessage("Program already exists");
                programmeUI.listProgramme(getProgramme(-1, programmeList.getExits(newProgramme.getName())));
            } else {
                programmeList.add(newProgramme);
                ProgrammeMessageUI.printGreenMessage("Successful added new program");
                programmeUI.listAllProgramme(getAllProgramme(), getNumberOfProgramme());
                ProgrammeMessageUI.pressEnterToContinue();
            }

        }
    }

    public void removeProgramme() {

        int index = indexInputAndValidation();

        if (index != -1) {
            programmeUI.listProgramme(getProgramme(index, null));
            if (programmeUI.inputYN("delete")) {
                programmeList.remove(index);
                ProgrammeMessageUI.printGreenMessage("Successful remove the programme");

                programmeUI.listAllProgramme(getAllProgramme(), getNumberOfProgramme());
                ProgrammeMessageUI.pressEnterToContinue();
            }
        }
    }

    public void findProgramme() {
        int[] index = programmeList.searchPosition(programmeUI.inputSearch());
        programmeUI.listAllProgramme(getProgramme(index), filterSearch(index));
    }

    private int filterSearch(int[] index) {
        int count = 0;
        for (int i = 0; i < index.length; i++) {
            if (index[count] != 0) {
                count++;
            }
        }
        return count;
    }

    private int indexInputAndValidation() {
        boolean pass;
        int index;
        do {
            pass = true;
            index = programmeUI.inputNo();
            if (index > programmeList.getNumberOfEntries() || (index <= 0 && index != -1)) {
                pass = false;
                System.out.println("Invalid input");
            } else if (index == -1) {
                break;
            }
        } while (!pass);

        return index;
    }

    public void modifyProgramme() {
        int index = indexInputAndValidation();

        if (index != -1) {
            programmeUI.listProgramme(getProgramme(index, null));
            Programme prog = programmeList.getEntry(index);
            Programme newProgramme = programmeUI.inputProgrammeDetails();
            String before = String.format("%d.  %-40s  %d YEARS\n", index, prog.getName(), prog.getDuration());
            String after = String.format("%d.  %-40s  %d YEARS\n", index, newProgramme.getName(), newProgramme.getDuration());
            programmeUI.listModifyProgramme(before, after);
            if (programmeUI.inputYN("modify")) {
                programmeList.replace(index, newProgramme);
                ProgrammeMessageUI.printGreenMessage("Successful modified the programme details");
            }

        }
    }

    private String getAvailableTutorialGroup() {
        String outputStr = "";
        if (tutGroupList.getNumberOfEntries() != 0) {

            for (int i = 1; i <= tutGroupList.getNumberOfEntries(); i++) {
                TutorialGroup tut = tutGroupList.getEntry(i);
                outputStr += String.format("%-24s\t%33s\n", tut.getGroupID(), tut.getFacultyName());
            }

        }
        return outputStr;
    }

    public JYListInterface<TutorialGroup> getAssignedTutorial(Programme prog) {
        JYListInterface<TutorialGroup> AssignedtutorialList = new JYArrayList<>();
        for (int i = 1; i <= groupMap.size(); i++) {
            TutorialGroup TutorialCheck = groupMap.getValue(i);
            if (prog.getTutorialGroup().contains(TutorialCheck)) {
                AssignedtutorialList.add(TutorialCheck);
            }
        }
        return AssignedtutorialList;
    }

    private TutorialGroup getTutorialGroup(String index) {
        for (int i = 1; i <= groupMap.size(); i++) {
            if (groupMap.getValue(i).getGroupID().equals(index)) {
                return groupMap.getValue(i);
            }
        }
        return null;
    }

    public void addTutGroupToProgramme() {
        programmeUI.listAllProgramme(getAllProgramme(), getNumberOfProgramme());
        int index = indexInputAndValidation();

        if (index != -1) {
            //Show the programme details and the tutorial group assigned
            Programme prog = programmeList.getEntry(index); // Programme that want add tutorial group
            programmeUI.listTutorialProgmme(prog);

            //Show the available tutorial group
            programmeUI.showAvailableTutorialGroup(getAvailableTutorialGroup());
            if (tutGroupList.getNumberOfEntries() != 0) {
                String add = "-1";
                System.out.println("Enter the name of the Tutorial group wanted to add to this programme(one by one)");
                do {

                    if (tutGroupList.getNumberOfEntries() == 0) {
                        ProgrammeMessageUI.printRedMessage("All the tutorial group is assigned");
                        ProgrammeMessageUI.printRedMessage("Going back to the main menu");
                        break;
                    }

                    add = programmeUI.inputNameTut();
                    TutorialGroup tutAdd = getTutorialGroup(add);
                    // The tutorial want to add can't be:
                    // no inside the tutorial list
                    // already assigned in that programme
                    if (!add.equals("-1")) {
                        if (tutAdd != null) {
                            if (tutGroupList.contains(tutAdd)) {
                                prog.addTutorialGroup(tutAdd);
                                tutGroupList.remove(tutAdd);
                                ProgrammeMessageUI.printGreenMessage("Successful Added");
                            } else {
                                ProgrammeMessageUI.printRedMessage("Already assigned");
                            }
                        } else {
                            System.out.println("Invalid option. Please enter other name");
                        }
                    }
                } while (!add.equals("-1"));
                programmeList.replace(index, prog);

            }
        }
    }

    public void removeTutGroupFromProgramme() {
        programmeUI.listAllProgramme(getAllProgramme(), getNumberOfProgramme());
        int index = indexInputAndValidation();
        if (index != -1) {
            //Show the programme details and the tutorial assigned
            Programme prog = programmeList.getEntry(index); // Programme that want add tutorial group
            programmeUI.listTutorialProgmme(prog);

            //Process the tutorial group removing
            if (prog.getTutorialGroup().getNumberOfEntries() != 0) {
                String add = "-1";
                System.out.println("Enter the name of the Tutorial group wanted to delete( -1 to quit)");
                do {
                    if (prog.getTutorialGroup().getNumberOfEntries() == 0) {
                        ProgrammeMessageUI.printRedMessage("All the tutorial assigned to this programme is removed");
                        ProgrammeMessageUI.printRedMessage("Going back to the main menu");
                        break;
                    }
                    add = programmeUI.inputNameTut();
                    TutorialGroup tutAdd = getTutorialGroup(add);
                    // The tutorial want to add can't be:
                    // no inside the tutorial list
                    // already assigned in that programme
                    if (!add.equals("-1")) {
                        if (tutAdd != null) {
                            if (prog.getTutorialGroup().contains(tutAdd)) {
                                prog.removeTutorialGroup(tutAdd);
                                tutGroupList.add(tutAdd);
                                ProgrammeMessageUI.printGreenMessage("Successful deleted");
                            } else {
                                ProgrammeMessageUI.printRedMessage("No existing");
                            }
                        } else {
                            System.out.println("Invalid option. Please enter other name");
                        }
                    }
                } while (!add.equals("-1"));
                programmeList.replace(index, prog);

            } else {
                ProgrammeMessageUI.printRedMessage("\tNo tutorial group assigned to this programme!");
            }
        }

    }

    public void listAllTutorialLinked() {
        programmeUI.listAllProgramme(getAllProgramme(), getNumberOfProgramme());

        int index = indexInputAndValidation();

        if (index != -1) {
            Programme prog = programmeList.getEntry(index); // Programme that want add tutorial group
            System.out.println("\n\n\n\n");
            programmeUI.listTutorialProgmme(prog);
            ProgrammeMessageUI.pressEnterToContinue();

        }
    }

    public void ReportShowProgrammeTutorial() {
        System.out.println("======================================================================");
        System.out.println("  Number of the tutorial group assigned to each programme");
        System.out.println("======================================================================");
        System.out.printf("No.  %-40s DURATION\tTUTORIAL GROUP\n", "NAME");
        for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
            Programme prog = programmeList.getEntry(i);
            System.out.printf("%2d.  %-40s %2d YEARS\t%7d\n", i, prog.getName(), prog.getDuration(), prog.getTutorialGroup().getNumberOfEntries());
        }
        System.out.println("======================================================================");
        System.out.println("TOTAL NUMBER OF TUTORIAL GROUP NOT YET ASSIGNED = " + tutGroupList.getNumberOfEntries());

        int choice = 0;
        do {
            choice = programmeUI.ReportOperationMenu();
            switch (choice) {
                case 0:
                    //Exit to maine menu
                    break;
                case 1:
                    //Show how many tutorial group are assigned to each programme
                    int index = indexInputAndValidation();
                    Programme prog = programmeList.getEntry(index);

                    System.out.println("\n\n");
                    programmeUI.listTutorialProgmme(prog);
                    ProgrammeMessageUI.pressEnterToContinue();
                    break;
                default:
                    ProgrammeMessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != 0 && choice != 1 );

    }

    public void ReportTutorialAssignedStatus() {
        String assigned = "";
        String notassigned = "";
        System.out.println("==================================================================================");
        System.out.println("                     Tutorial Group Assigned Status");
        System.out.println("==================================================================================");

        System.out.printf("%-24s\t%-33s\t%10s\n", "Tutorial id", "Faculty Name", "Status");
        for (int i = 1; i <= groupMap.size(); i++) {
            TutorialGroup tut = groupMap.getValue(i);
            if (tutGroupList.contains(tut)) {
                notassigned += String.format("%-24s\t%-33s\t%10s\n", tut.getGroupID(), tut.getFacultyName(), "Unassigned");
            } else {
                assigned += String.format("%-24s\t%-33s\t%10s\n", tut.getGroupID(), tut.getFacultyName(), "Assigned");
            }
        }
        System.out.print(assigned);
        System.out.print(notassigned);
        System.out.println("==================================================================================");
    }

    public static void main(String[] args) {
        ProgrammeMaintenance programmeMaintenance = new ProgrammeMaintenance();
        programmeMaintenance.runProgrammeMaintenance();
    }
}
