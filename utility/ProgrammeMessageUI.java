// Author: Chai Jia You

package utility;

public class ProgrammeMessageUI {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void displayInvalidChoiceMessage() {

        System.out.println(ANSI_RED  + "Invalid choice" + ANSI_RESET);

    }

    public static void displayExitMessage() {

        System.out.println("\nExiting system....");

    }

    public static void pressEnterToContinue() {
        System.out.print("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {

        }
    }

    public static void printGreenMessage(String str) {
        System.out.println(ANSI_GREEN + str + ANSI_RESET);
    }
    
        public static void printRedMessage(String str) {
        System.out.println(ANSI_RED  + str + ANSI_RESET);
    }

}
