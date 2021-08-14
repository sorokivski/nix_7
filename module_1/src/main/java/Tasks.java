import static level1.t1_uniqNum.inputValues;
import static level1.t2_knightsMove.chessMove;
import static level1.t3_triangleSquare.triangleSquare;
import static level3.LifeGame.startGame;
import static level2.CorrectString.checkString;

public class Tasks {
    public static void main(String[] args){

        System.out.println("level1 tasks: ");
        inputValues();
        chessMove();
        triangleSquare();
        System.out.println("level2 task: ");
        checkString();
        System.out.println("level3 task: ");
        startGame();

    }
}
