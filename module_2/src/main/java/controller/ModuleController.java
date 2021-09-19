package controller;

import tasks.CommisVoyageur;
import tasks.СonvertDate;
import tasks.UniqName;

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
                    new СonvertDate().run();
                    break;
                case 2:
                    new UniqName().findFirstUniq();
                    break;
                case 3:
                    new CommisVoyageur().lessCost();
                    break;
                case 0:
                    break;
                default:
                    new СonvertDate().run();
                    new UniqName().findFirstUniq();
                    new CommisVoyageur().lessCost();

            }
        }
    }
}
