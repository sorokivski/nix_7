package tasks;

import java.util.Scanner;

public class WhenLessonEnds {

    public static void calculateTime() {
        System.out.println("Enter lesson`s number:");
        Scanner in = new Scanner(System.in);
        int lesson = in.nextInt();
        int time = lesson * 45 + (lesson - 1) / 2 * (20) + (lesson - 1) % 2 * 5;
        System.out.println("lesson " + lesson + " ends in " + (time / 60 + 9) + ":" + (time % 60));
    }
}
