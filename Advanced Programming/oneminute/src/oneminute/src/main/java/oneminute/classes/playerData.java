package oneminute.classes;

import java.io.Serializable;
import java.util.List;

    public class playerData implements Serializable {
    // Define attributes to be saved
    private String playerUID;
    private int currentDaySaved; //save current day stopped
    private String gwenStatus; //gwen's status "healthy, sick or dead"
    private String susanStatus;
    private String robertStatus;
    private List<String> inventoryItems; //assuming items are stored as a string
    
    // Constructor
    public playerData(String playerUID, int currentDaySaved, String gwenStatus, String susanStatus, String robertStatus, List<String> inventoryItems) {
        this.playerUID = playerUID; this.currentDaySaved = currentDaySaved; this.gwenStatus = gwenStatus; this.susanStatus = susanStatus; this.robertStatus = robertStatus; this.inventoryItems = inventoryItems;
}
    // Getters and setters
    public String getPlayerUID() {
        return playerUID;
    }

    public void setPlayerUid(String playerUid) {
        this.playerUID = playerUid;
    }

    public int getCurrentDaySaved() {
        return currentDaySaved;
    }

    public void setCurrentDaySaved(int currentDaySaved) {
        this.currentDaySaved = currentDaySaved;
    }

    public String getGwenStatus() {
        return gwenStatus;
    }

    public void setGwenStatus(String gwenStatus) {
        this.gwenStatus = gwenStatus;
    }
    
    public String getSusanStatus() {
        return susanStatus;
    }

    public void setSusanStatus(String susanStatus) {
        this.susanStatus = susanStatus;
    }
    
    public String getRobertStatus() {
        return robertStatus;
    }

    public void setRobertStatus(String robertStatus) {
        this.robertStatus = robertStatus;
    }

    public List<String> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(List<String> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }
    
    @Override 
    public String toString() {
        return "playerData {" + "UID = ' " + playerUID + '\'' + 
                            ", current day = " + currentDaySaved + 
                            ", Gwen Status = " + gwenStatus + 
                            ", Susan Status = " + susanStatus + 
                            ", Robert Status = " + robertStatus + 
                            ", inventory = " + inventoryItems + '}';
    }
}