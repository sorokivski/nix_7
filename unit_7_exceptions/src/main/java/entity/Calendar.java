package entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Locale;

public
@Data
class Calendar implements Comparable<Calendar> {
    private static final int STARTING_YEAR = 1;
    private static final int STARTING_MONTH = 1;
    private static final int STARTING_DAY = 1;
    int year;
    int month;
    int day;

    public Calendar(int year) {
        this.day = STARTING_DAY;
        this.month = STARTING_MONTH;
        this.year = year;
    }

    public Calendar() {
        this.day = STARTING_DAY;
        this.month = STARTING_MONTH;
        this.year = STARTING_YEAR;
    }

    public Calendar(int day, int month, int year) {
        this.day = day;
        this.year = year;
        this.month = month;
    }

    public static ArrayList<Integer> getLongMonth() {
        ArrayList<Integer> longMonth = new ArrayList<>();
        longMonth.add(1);
        longMonth.add(3);
        longMonth.add(5);
        longMonth.add(7);
        longMonth.add(8);
        longMonth.add(10);
        longMonth.add(12);
        return longMonth;
    }

    public static int getMonthByName(String name) {
        switch (name.toLowerCase(Locale.ROOT)) {
            case "january":
                return 1;
            case "february":
                return 2;
            case "march":
                return 3;
            case "april":
                return 4;
            case "may":
                return 5;
            case "june":
                return 6;
            case "july":
                return 7;
            case "august":
                return 8;
            case "september":
                return 9;
            case "october":
                return 10;
            case "november":
                return 11;
            case "december":
                return 12;
            default:
                return 1;
        }
    }

    public String toStringAll() {
        return " " + day + "/" + month + "/" + year;
    }

    @Override
    public int compareTo(Calendar calendar) {

        if (this.getDay() == calendar.getDay() && this.getMonth() == calendar.getMonth() && calendar.getYear() == this.getYear())
            return 0;
        else {
            if (this.year > calendar.getYear()) return 1;
            else {
                if (this.year == calendar.getYear() && this.month > calendar.getMonth()) return 1;
                else {
                    if (this.year == calendar.getYear() && this.month == calendar.getMonth() && this.day > calendar.getDay())
                        return 1;
                    else return -1;
                }
            }
        }
    }

    public String getMonthToName(int month) {
        switch (month) {
            case 1:
                return "january";
            case 2:
                return "february";
            case 3:
                return "march";
            case 4:
                return "april";
            case 5:
                return "may";
            case 6:
                return "june";
            case 7:
                return "july";
            case 8:
                return "august";
            case 9:
                return "september";
            case 10:
                return "october";
            case 11:
                return "november";
            case 12:
                return "december";
            default:
                return "none";
        }
    }
}
