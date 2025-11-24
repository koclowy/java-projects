package oneminute.classes;

public class FamilyMemberStatus {
    private String name;
    private int health;
    private int hunger;
    private int thirst;
    private int morale;

    public FamilyMemberStatus(String name, int health, int hunger, int thirst, int morale) {
        this.name = name;
        this.health = health;
        this.hunger = hunger;
        this.thirst = thirst;
        this.morale = morale;
    }

    // Getters and setters for each attribute
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public int getMorale() {
        return morale;
    }

    public void setMorale(int morale) {
        this.morale = morale;
    }
}
