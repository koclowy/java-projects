package oneminute.classes;

import java.util.ArrayList;
import oneminute.controllers.JournalStatusController;

public class DayCounterApp {
    
    private final DayCounter dayCounter;
    private static JournalStatusController statusController;
    private final ArrayList<FamilyMemberStatus> familyMembers;
    private static DayCounterApp instance;

    private DayCounterApp() {
        
        this.dayCounter = new DayCounter();
        this.familyMembers = initializeFamilyMembers();
    }

    public static synchronized DayCounterApp getInstance() {
        if (instance == null) {
            instance = new DayCounterApp();
        }
        return instance;
    }
    

    // Family Members' Settings
    private ArrayList<FamilyMemberStatus> initializeFamilyMembers() {
        ArrayList<FamilyMemberStatus> members = new ArrayList<>();
        members.add(new FamilyMemberStatus("Susan", 80, 70, 70, 70));
        members.add(new FamilyMemberStatus("Robert", 80, 70, 70, 70));
        members.add(new FamilyMemberStatus("Gwen", 80, 70, 70, 70));
        return members;
    }


    // Getters and Setters
    public ArrayList<FamilyMemberStatus> getFamilyMembers() {
        return familyMembers;
    }

    public DayCounter getDayCounter() {
        return dayCounter;
    }

    public static JournalStatusController getStatusController() {
        return statusController;
    }

    public void setStatusController(JournalStatusController statusController) {
        DayCounterApp.statusController = statusController;
    }

    public String getFormattedFamilyMembersStatus() {
        StringBuilder statusBuilder = new StringBuilder();
        for (FamilyMemberStatus member : familyMembers) {
            statusBuilder.append(member.getName()).append(" Health Value: ").append(member.getHealth()).append("/100\n");
            statusBuilder.append(member.getName()).append(" Hunger Value: ").append(member.getHunger()).append("/100\n");
            statusBuilder.append(member.getName()).append(" Thirst Value: ").append(member.getThirst()).append("/100\n");
            statusBuilder.append(member.getName()).append(" Morale Value: ").append(member.getMorale()).append("/100\n");
        }
        return statusBuilder.toString();
    }
}