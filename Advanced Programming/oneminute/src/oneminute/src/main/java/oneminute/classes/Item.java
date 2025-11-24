package oneminute.classes;

public class Item {
    private final String itemName;
    private final String itemDescription;
    private final String itemUrl; 

    public Item(String itemName, String itemDescription, String itemUrl) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemUrl = itemUrl;
    }

    public String getItemname() {
        return itemName;
    }

    public String getDescription() {
        return itemDescription;
    }
    
    public String getItemUrl() {
        return itemUrl;
    }
}
