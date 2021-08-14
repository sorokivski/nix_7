package level1;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class t2_knightsMove {

    public static void chessMove(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter x, y for start position and x, y for moveTo position:");
        if(isPossible(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt())) System.out.println("Correct move of knight");
        else System.out.println( "Incorrect move of knight");
    }
    public static boolean isPossible(int x1, int y1, int x2, int y2) {
        if (Math.abs(x1 - x2) == 1 && Math.abs(y1 - y2) == 2 || Math.abs(x1 - x2) == 2 && Math.abs(y1 - y2) == 1) return true;
        return false;
    }



}
