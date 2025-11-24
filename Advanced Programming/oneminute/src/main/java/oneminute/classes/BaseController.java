package oneminute.classes;

public class BaseController {
    protected DayCounterApp dayCounterApp;

    public void setDayCounterApp(DayCounterApp dayCounterApp) {
        this.dayCounterApp = dayCounterApp;
        callDayCounterApp(); // Call an overridable method when the app is set
    }

    public DayCounterApp getDayCounterApp() {
        return dayCounterApp;
    }

    protected void callDayCounterApp() {
        System.out.println("DayCounterApp set in BaseController: " + dayCounterApp);
    }
}