import controller.CalendarController;

public class CalendarMain {

    public static void main(String[] args) {
        System.out.println("-------------------------------------------------------------- Console Calendar --------------------------------------------------------------------------------");
        System.out.println("\n  Program provides possibility to:\n\n" +
                "- find difference between dates\n" +
                "- add to date time-period\n" +
                "- subtract from date some time-period\n" +
                "- compare dates in desc and asc order\n" +
                "\n_______________________________________________________________________________________________________________________________________________________________\n");
        new CalendarController().run();
    }
}
