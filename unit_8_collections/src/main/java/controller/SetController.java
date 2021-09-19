package controller;

import utils.MathSet;

import java.util.Scanner;

public class SetController {
    private static final MathSet<Integer> numbers = new MathSet<>();
    private static final Scanner in = new Scanner(System.in);

    public void run() {
        int choice = 11;
        while (choice != 0) {
           options();
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
                    add();
                    break;
                case 3:{
                    if(numbers.get(0)== null) add();
                    sortDescAndDisplay();
                }
                    break;
                case 2:{
                    if(numbers.get(0)== null) add();
                    sortAscAndDisplay();
                } break;
                case 4: {
                    if(numbers.get(0)== null) add();
                    showMin();
                }
                break;
                case 5: {
                    if(numbers.get(0)== null) add();
                    showMax();
                }
                break;
                case 6:{
                    if(numbers.get(0)== null) add();
                    showAverage();
                } break;
                case 7: {
                    if(numbers.get(0)== null) add();
                    showMedian();
                } break;
                case 8: {
                    if(numbers.get(0)== null) add();
                    showAllValues();
                } break;
                default:
                    break;
            }
            System.out.println("________________________________________________________________________________________________________________________________________");

        }
    }

    private void showAllValues() {
        for (int i = 0; i < numbers.getCapacity(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println("\n");
    }

    private void showMedian() {
        System.out.println("MEDIAN: "+numbers.getMedian());
    }

    private void showAverage() {
        System.out.println("AVERAGE: "+numbers.getAverage());
    }

    private void showMax() {
        System.out.println("MAX: "+numbers.getMax());
    }

    private void showMin() {
        System.out.println("MIN: "+numbers.getMin());
    }

    private void sortAscAndDisplay() {
        numbers.sortAsc();

        for (int i = 0; i < numbers.getCapacity(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println("\n");
    }

    private void sortDescAndDisplay() {
        numbers.sortDesc();

            for (int i = 0; i < numbers.getCapacity(); i++) {
                System.out.print(numbers.get(i) + " ");
            }
        System.out.println("\n");
    }


    private void add() {
        try {
            System.out.print("Enter number of elements to add:");
            int numer = in.nextInt();
            for (int i = 0; i < numer; i++) {
                System.out.print("Enter value:");
                numbers.add(in.nextInt());
            }
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input");
        }
    }

    private void options() {
        System.out.println("***************************************************************** OPTIONS **********************************************************************************");
        System.out.println("1 - adding numbers to MathSet\n" +
                "2 - sorting in asc order\n" +
                "3 - sorting in desc order\n" +
                "4 - getting min element\n" +
                "5 - getting max element\n" +
                "6 - getting average value\n" +
                "7 - getting median value\n" +
                "8 - getting all values\n" +
                "0 - EXIT");
        System.out.println("****************************************************************** CHOSE OPTION TO PROCEED ******************************************************************************************");
    }
}
