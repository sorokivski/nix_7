package level3;
import java.util.Scanner;
import java.util.Random;

public class LifeGame {
    public static void startGame(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter size of gameMatrix: ");
        int m = in.nextInt();
        int n = in.nextInt();
        int [][]gameMatrix = new int[m][n];

        for(int i =0; i<m; i++){
            for(int j=0; j<n; j++){
                gameMatrix[i][j] = boolRand();
                if(gameMatrix[i][j]== 1) System.out.printf(gameMatrix[i][j]+"   " );
                else System.out.printf(gameMatrix[i][j]+"   ");
            }
            System.out.println(" ");
        }
        System.out.println("Update gameMatrix: ");
        for(int i =0; i<m; i++){
            for(int j=0; j<n; j++){
                int nei = checkNeighbors(gameMatrix, m, n,i, j);
                if(nei <2) gameMatrix[i][j] = 0;
                if(nei==3) gameMatrix[i][j] = 1;
                if(nei>3) gameMatrix[i][j] = 0;
                if(gameMatrix[i][j]== 1) System.out.printf(gameMatrix[i][j]+"   " );
                else System.out.printf(gameMatrix[i][j]+"   " );
            }
            System.out.println(" ");
        }

    }
    public static int checkPoint(int[][] gameMatrix,int length, int width,int x, int y) {
        if (x >= length || x < 0) {
            return 0;
        }
        if (y >= width|| y < 0) {
            return 0;
        }
        return gameMatrix[x][y];
    }
    public static int checkNeighbors(int[][] gameMatrix,int length, int width, int x, int y){
        int numOfAliveNeighbors=0;

        if (checkPoint(gameMatrix, length, width, x - 1, y - 1) == 1) numOfAliveNeighbors++;
        if (checkPoint(gameMatrix, length, width, x + 1,y + 1) == 1) numOfAliveNeighbors++;
        if (checkPoint(gameMatrix, length, width, x,y - 1) == 1) numOfAliveNeighbors++;
        if (checkPoint(gameMatrix, length, width, x,y + 1) == 1) numOfAliveNeighbors++;
        if (checkPoint(gameMatrix, length, width, x - 1, y) == 1) numOfAliveNeighbors++;
        if (checkPoint(gameMatrix, length, width, x +1, y)  == 1) numOfAliveNeighbors++;
        if (checkPoint(gameMatrix, length, width, x - 1, y + 1) == 1) numOfAliveNeighbors++;
        if (checkPoint(gameMatrix, length, width, x + 1, y - 1) == 1) numOfAliveNeighbors++;

        return numOfAliveNeighbors;
    }
    private static int boolRand()
    {
        Random rand = new Random();
        return rand.nextInt(2);
    }
}
