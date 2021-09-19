package controller;

import entity.Calendar;
import entity.CustomDateTime;
import service.DateTimeService;
import service.FormatService;
import util.DateTimeCalculator;
import util.DateTimeConverter;

import java.util.*;

public class CalendarController {
    private static final Scanner in = new Scanner(System.in);
    private static final FormatService FORMAT_SERVICE = new FormatService();
    private static final DateTimeService DATETIME_SERVICE = new DateTimeService();
    private static final DateTimeCalculator CALCULATOR = new DateTimeCalculator();
    private static final DateTimeConverter CONVERTER = new DateTimeConverter();

    public void run() {
        int choice = 11;
        while (choice != 0) {
            System.out.println("Chose function to proceed:\n" +
                    "1 - find difference between dates\n" +
                    "2 - add time or period to date\n" +
                    "3 - subtract time or period from date\n" +
                    "4 - compare list of dates in desc or asc order\n" +
                    "0 - EXIT\n");
            try {
                if (in.hasNextInt()) choice = in.nextInt();
                else choice = 11;
            } catch (Exception e) {
                System.out.println("Incorrect input, try again");
                in.nextLine();
                if (in.hasNextInt()) choice = in.nextInt();
                else choice = 11;
            }

            switch (choice) {
                case 1:
                    difference();
                    break;
                case 2:
                    addition();
                    break;
                case 3:
                    subtraction();
                    break;
                case 4:
                    comparation();
                    break;
                default:
                    break;
            }
            System.out.println("________________________________________________________________________________________________________________________________________");

        }
    }

    public CustomDateTime createDateTimeInSelectedFormatOfInputDates() {

        int choice = 11;
        while (choice != 0) {
            System.out.println("Chose format for entering date:\n" +
                    "dd/mm/yyyy \t- 1\n" +
                    "mm/dd/yyyy \t- 2\n" +
                    "month-d-yy \t- 3\n" +
                    "dd-mm-yyyy hh:mn- 4\n" +
                    "dd-mm-yyyy hh:mn:ss - 5\n" +
                    "dd-mm-yyyy hh:mn:ss:msc - 6\n" +
                    "yyyy hh:mn \t- 7\n" +
                    "dd-month-yyyy hh:mn - 8\n");
            try {
                if (in.hasNextInt()) choice = in.nextInt();
                else choice = 11;
            } catch (Exception e) {
                System.out.println("Incorrect input, try again");
                if (in.hasNextInt()) choice = in.nextInt();
                else choice = 11;

            }
            in.nextLine();
            System.out.println("Enter date: ");
            String date = in.nextLine();
            CustomDateTime newDate;
            switch (choice) {
                case 1: {
                    newDate = DATETIME_SERVICE.createDateTime(FORMAT_SERVICE.createDateTime(date, "ddmmyyyy"));
                    if (newDate != null) return newDate;
                    else break;
                }
                case 2: {
                    newDate = DATETIME_SERVICE.createDateTime(FORMAT_SERVICE.createDateTime(date, "mmddyyyy"));
                    if (newDate != null) return newDate;
                    else break;
                }
                case 3: {
                    newDate = DATETIME_SERVICE.createDateTime(FORMAT_SERVICE.createDateTime(date, "monthdyy"));
                    if (newDate != null) return newDate;
                    else break;
                }

                case 4: {
                    newDate = DATETIME_SERVICE.createDateTime(FORMAT_SERVICE.createDateTime(date, "ddmmyyyyhhmn"));
                    if (newDate != null) return newDate;
                    else break;
                }
                case 5: {
                    newDate = DATETIME_SERVICE.createDateTime(FORMAT_SERVICE.createDateTime(date, "ddmmyyyyhhmnss"));
                    if (newDate != null) return newDate;
                    else break;
                }
                case 6: {
                    newDate = DATETIME_SERVICE.createDateTime(FORMAT_SERVICE.createDateTime(date, "ddmmyyyyhhmnssmsc"));
                    if (newDate != null) return newDate;
                    else break;
                }
                case 7: {
                    newDate = DATETIME_SERVICE.createDateTime(FORMAT_SERVICE.createDateTime(date, "yearhhmn"));
                    if (newDate != null) return newDate;
                    else break;
                }
                case 8: {
                    newDate = DATETIME_SERVICE.createDateTime(FORMAT_SERVICE.createDateTime(date, "ddmonthyyyyhhmn"));
                    if (newDate != null) return newDate;
                    else break;
                }
                default:
                    break;
            }

            System.out.println("Date was not created, try again.");

        }
        return null;
    }


    public void comparation() {
        int datesSize = 2;
        List<CustomDateTime> datesToCompare = new LinkedList<>();
        System.out.println("Enter how many dates you`d like to compare: ");
        try {
            datesSize = in.nextInt();
        } catch (Exception e) {
            System.out.println("Incorrect input, try again");
            in.nextLine();
            datesSize = in.nextInt();
        }
        System.out.println("Enter list of dates to compare: ");
        for (int i = 0; i < datesSize; i++) {
            System.out.println("Enter date " + (i + 1) + " : ");
            datesToCompare.add(createDateTimeInSelectedFormatOfInputDates());
        }
        Comparator<CustomDateTime> comparator
                = (date1, date2) -> date1.compareTo(date2);
        System.out.println("Chose order to compare: asc - 1, desc - 2");
        switch (in.nextLine()) {
            case "1":
                datesToCompare.sort(comparator);
                break;
            case "2": {
                datesToCompare.sort(comparator.reversed());
            }
            break;
            default: {
                datesToCompare.sort(comparator);
                System.out.println("SORTED DATES IN ASC ORDER: ");
                CONVERTER.showResultsInSelectedFormatOfOutputDates(datesToCompare);
                datesToCompare.sort(comparator.reversed());
            }
            break;
        }
        System.out.println("SORTED DATES: ");
        CONVERTER.showResultsInSelectedFormatOfOutputDates(datesToCompare);
    }

    public void subtraction() {
        System.out.println("What you`d like to subtract from date:\n" +
                "1 - hours\n" +
                "2 - days\n" +
                "3 - years\n" +
                "4 - minutes\n" +
                "5 - seconds\n" +
                "6 - milliseconds");
        int choice;
        if (in.hasNextInt()) choice = in.nextInt();
        else choice = 3;
        switch (choice) {
            case 1:{
                System.out.println("Enter hours to subtract:");
                int toSubtract = 0;
                if (in.hasNextInt()) toSubtract = in.nextInt();
                CONVERTER.showResultsInSelectedFormatOfOutputDates(Collections.singletonList(CALCULATOR.subtractHours(createDateTimeInSelectedFormatOfInputDates(), toSubtract)));
            }break;
            case 2:{
                System.out.println("Enter days to subtract:");
                int toSubtract = 0;
                if (in.hasNextInt()) toSubtract = in.nextInt();
                CONVERTER.showResultsInSelectedFormatOfOutputDates(Collections.singletonList(CALCULATOR.subtractDays(createDateTimeInSelectedFormatOfInputDates(), toSubtract)));
            }break;
            case 3: {
                CustomDateTime date = createDateTimeInSelectedFormatOfInputDates();
                if (date != null) {
                    System.out.println("Enter years to subtract:");
                    int yearsToSubstract = 0;
                    if (in.hasNextInt()) yearsToSubstract = Math.abs(in.nextInt());
                    CONVERTER
                            .showResultsInSelectedFormatOfOutputDates(Collections
                                    .singletonList(new CustomDateTime(new Calendar(date
                                            .getCalendar().getDay(), date.getCalendar().getMonth(), date.getCalendar().getYear() - yearsToSubstract), date.getClock())));
                } else System.out.println("Failed to subtract year");
            }
            break;
            case 4:{
                System.out.println("Enter minutes to subtract:");
                int toSubtract = 0;
                if (in.hasNextInt()) toSubtract = in.nextInt();
                CONVERTER.showResultsInSelectedFormatOfOutputDates(Collections.singletonList(CALCULATOR.subtractMinutes(createDateTimeInSelectedFormatOfInputDates(), toSubtract)));
            }break;
            case 5:{
                System.out.println("Enter seconds to subtract:");
                int toSubtract = 0;
                if (in.hasNextInt()) toSubtract = in.nextInt();
                CONVERTER.showResultsInSelectedFormatOfOutputDates(Collections.singletonList(CALCULATOR.subtractSeconds(createDateTimeInSelectedFormatOfInputDates(), toSubtract)));
            }break;
            case 6:{
                System.out.println("Enter milliseconds to subtract:");
                int toSubtract = 0;
                if (in.hasNextInt()) toSubtract = in.nextInt();
                CONVERTER.showResultsInSelectedFormatOfOutputDates(Collections.singletonList(CALCULATOR.subtractMillis(createDateTimeInSelectedFormatOfInputDates(), toSubtract)));
            }break;
            default:
                break;
        }
    }

    public void difference() {
        System.out.println("In which format you`d like to find difference:\n" +
                "1 - in hours\n" +
                "2 - in days\n" +
                "3 - in years\n" +
                "4 - in minutes\n" +
                "5 - in seconds\n" +
                "6 - in milliseconds");
        int choice;
        if (in.hasNextInt()) choice = in.nextInt();
        else choice = 1;

        switch (choice) {
            case 1:
                System.out.println(CALCULATOR.calculateDifference(
                        createDateTimeInSelectedFormatOfInputDates(), createDateTimeInSelectedFormatOfInputDates()) * 24
                        + " hours of difference");
                break;
            case 2:
                System.out.println(CALCULATOR.calculateDifference(
                        createDateTimeInSelectedFormatOfInputDates(), createDateTimeInSelectedFormatOfInputDates())
                        + " days of difference");
                break;
            case 3:
                System.out.println((double) CALCULATOR.calculateDifference(
                        createDateTimeInSelectedFormatOfInputDates(), createDateTimeInSelectedFormatOfInputDates()) / 365.0
                        + " years of difference");
                break;
            case 4:
                System.out.println(CALCULATOR.calculateDifference
                        (createDateTimeInSelectedFormatOfInputDates(), createDateTimeInSelectedFormatOfInputDates()) * 24 * 60
                        + " minutes of difference");
                break;
            case 5:
                System.out.println(CALCULATOR.calculateDifference(
                        createDateTimeInSelectedFormatOfInputDates(), createDateTimeInSelectedFormatOfInputDates()) * 24 * 60 * 60
                        + " seconds of difference");
                break;
            case 6:
                System.out.println((long) CALCULATOR.calculateDifference(
                        createDateTimeInSelectedFormatOfInputDates(), createDateTimeInSelectedFormatOfInputDates()) * 24 * 60 * 60 * 1000 + " milliseconds of difference");
                break;
            default:
                break;
        }

    }

    public void addition() {
        System.out.println("What you`d like to add to date:\n" +
                "1 - hours\n" +
                "2 - days\n" +
                "3 - years\n" +
                "4 - minutes\n" +
                "5 - seconds\n" +
                "6 - milliseconds");
        int choice;
        if (in.hasNextInt()) choice = in.nextInt();
        else choice = 3;
        switch (choice) {
            case 1:{
                System.out.println("Enter hours to add: ");
                int hoursToAdd = 0;
                if (in.hasNextInt()) hoursToAdd = in.nextInt();
              CONVERTER.showResultsInSelectedFormatOfOutputDates(Collections.singletonList(CALCULATOR.addHours(createDateTimeInSelectedFormatOfInputDates(), hoursToAdd)));

            }
            break;
            case 2: {
                System.out.println("Enter days to add:");
                 int daysToAdd = 0;
                if (in.hasNextInt()) daysToAdd = in.nextInt();
                CONVERTER.showResultsInSelectedFormatOfOutputDates(Collections.singletonList(CALCULATOR.addDays(createDateTimeInSelectedFormatOfInputDates(), daysToAdd)));
            }
            break;
            case 3: {
                CustomDateTime date = createDateTimeInSelectedFormatOfInputDates();
                if (date != null) {
                    System.out.println("Enter years to add:");
                    int yearsToAdd = 0;
                    if (in.hasNextInt()) yearsToAdd = Math.abs(in.nextInt());
                    CONVERTER
                            .showResultsInSelectedFormatOfOutputDates(Collections
                                    .singletonList(DATETIME_SERVICE
                                            .createDateTime(new CustomDateTime(new Calendar(date
                                            .getCalendar().getDay(), date.getCalendar().getMonth(), date.getCalendar().getYear() + yearsToAdd), date.getClock()))));
                } else System.out.println("Failed to add year");
            }
            break;
            case 4:{
                System.out.println("Enter minutes to add: ");
                int toAdd = 0;
                if (in.hasNextInt()) toAdd = in.nextInt();
                CONVERTER.showResultsInSelectedFormatOfOutputDates(Collections.singletonList(CALCULATOR.addMinutes(createDateTimeInSelectedFormatOfInputDates(), toAdd)));
            }break;
            case 5:{
                System.out.println("Enter seconds to add: ");
                int toAdd = 0;
                if (in.hasNextInt()) toAdd = in.nextInt();
                CONVERTER.showResultsInSelectedFormatOfOutputDates(Collections.singletonList(CALCULATOR.addSeconds(createDateTimeInSelectedFormatOfInputDates(), toAdd)));
            }break;
            case 6:{
                System.out.println("Enter milliseconds to add: ");
                int toAdd = 0;
                if (in.hasNextInt()) toAdd = in.nextInt();
                CONVERTER.showResultsInSelectedFormatOfOutputDates(Collections.singletonList(CALCULATOR.addMillis(createDateTimeInSelectedFormatOfInputDates(), toAdd)));
            }break;
            default:
                break;
        }
    }
}
