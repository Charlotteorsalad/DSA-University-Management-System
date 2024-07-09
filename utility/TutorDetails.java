// Author: Tan Kok Wang

package utility;

public class TutorDetails {
    
    public static String getFaculty(int choice){ 
        String faculty = "";
        
        switch(choice) {
        case 1:
            faculty = "Faculty of Accountancy, Finance And Business(FAFB)";
            break;
        case 2:
            faculty = "Faculty of Applied Sciences(FOAS)";
            break;
        case 3:
            faculty = "Faculty of Built Environment(FOBE)";
            break;
        case 4:
            faculty = "Faculty of Computing And Information Technology(FOCS)";
            break;
        case 5:
            faculty = "Faculty of Engineering And Technology(FOET)";
            break;
        default:
            TutorMessageUI.displayInvalidMessage();
            break;
        } 
        return faculty;
    }
    
    public static String getCampus(int choice){
        String campus = "";
   
        switch(choice) {
        case 1:
            campus = "Kuala Lumpur Campus";
            break;
        case 2:
            campus = "Penang Branch";
            break;
        case 3:
            campus = "Perak Branch";
            break;
        case 4:
            campus = "Johor Branch";
            break;
        case 5:
            campus = "Pahang Branch";
            break;
        case 6:
            campus = "Sabah Branch";
            break;
        default:
            TutorMessageUI.displayInvalidMessage();
            break;
        } 
        return campus;
    }
    
    public static String getJobTime(int choice){
        String jobTime = "";
      
        switch(choice) {
        case 1:
            jobTime = "Full Time";
            break;
        case 2:
            jobTime = "Part Time";
            break;
        default:
            TutorMessageUI.displayInvalidMessage();
            break;
        } 
        return jobTime;
    }
     
}
