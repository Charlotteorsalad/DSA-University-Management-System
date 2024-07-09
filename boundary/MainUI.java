// Author: Tan Hao Yang

package boundary;

import java.util.Scanner;

public class MainUI {
    Scanner scanner = new Scanner(System.in);
    
    public int mainMenuChoice() {
        System.out.println("\n");
        System.out.println("University Management System");
        System.out.println("=============================");
        System.out.println("1. Course Management");
        System.out.println("2. Programme Management");
        System.out.println("3. Tutorial Group Management");
        System.out.println("4. Tutor Management");
        System.out.println("0. Exit");
        System.out.println("\n");        
        System.out.print("Enter an option: ");
        
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }
}

