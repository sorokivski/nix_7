package controller;

import tasks.CommisVoyageur;
import tasks.convertDate;
import tasks.uniqName;

import java.util.Scanner;

public class ModuleController {
    public void runTasks() {
        Scanner in = new Scanner(System.in);
        int choice = 11;
        while (choice != 0) {
            System.out.println("Chose task to run or 0 to stop program: ");
            try {
                choice = in.nextInt();
            } catch (Exception e) {
                System.out.println("Incorrect input");
                in.nextLine();
                choice = in.nextInt();
            }
            switch (choice) {
                case 1:
                    new convertDate().run();
                    break;
                case 2:
                    new uniqName().findFirstUniq();
                    break;
                case 3:
                    new CommisVoyageur().lessCost();
                    break;
                case 0:
                    break;
                default:
                    new convertDate().run();
                    new uniqName().findFirstUniq();
                    new CommisVoyageur().lessCost();

            }
        }
    }
}
