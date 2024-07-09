// Author: Tan Hao Yang

package control;

import boundary.MainUI;

public class MainManagement{
    private TutorialGroupMaintenance tutGrpM = new TutorialGroupMaintenance();
    private ProgrammeMaintenance progM = new ProgrammeMaintenance();
    private CourseManagement courseM = new CourseManagement(progM);
    private TutorManagement tutorM = new TutorManagement();
    private MainUI mainUI = new MainUI();
    
    public void mainMenu(){
        int option;
        
        do{
            option = mainUI.mainMenuChoice();
            
            switch(option){
                case 0:
                    break;
                case 1:
                    courseM.runCourseManagement();
                    break;
                case 2:
                    progM.runProgrammeMaintenance();
                    break;
                case 3:
                    tutGrpM.runTutorialGroupMaintenance();
                    break;
                case 4:
                    tutorM.runTutorManagement();
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }while(option != 0);
    }
    
    public static void main(String[] args){
        MainManagement mainSys = new MainManagement();
        mainSys.mainMenu();
    }
}