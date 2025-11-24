package oneminute.classes;

public class DayCounter {
    private int currentDay;

    public DayCounter() {
        currentDay = 1; // Start at day 1
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public void incrementDay() {
        if (currentDay < 14) {
            currentDay++;
        }
    }

    public boolean isMaxDayReached() {
        return currentDay >= 14;
    }
}