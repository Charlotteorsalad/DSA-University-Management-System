// Author: Tan Kok Wang

package utility;

public class TutorMessageUI {

  public static void displayInvalidMessage() {
    System.out.println("\nInvalid input, please try again");
  }

  public static void displayExitMessage() {
    System.out.println("\nExit successfully");
  }
  
  public static void displayExistMessage() {
    System.out.println("\nThe ID record already exist");
  }
  
  public static void displayNotFoundMessage(){
    System.out.println("\nNot found in the list");
  }
  
  public static void displayNullMessage(){
    System.out.println("\nNo any data in the list");
  }
  
}