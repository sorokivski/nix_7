package board;

import ChessPieces.ChessPiece;
import ChessPieces.Statuses.*;

import static ChessPieces.Statuses.*;
import static ChessPieces.Types.*;

public class ChessBoard {

    public static String[][] fillBoard() {
        String[] nums = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
        String[] letters = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
        String[][] chessMatrix = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessMatrix[i][j] = String.valueOf(letters[i] + nums[j]);
            }
        }
        return chessMatrix;
    }

    public static int[] convertPosition(String position) {
        int[] arr = new int[2];
        switch (position.charAt(0)) {
            case 'A':
                arr[0] = 0;
                break;
            case 'B':
                arr[0] = 1;
                break;
            case 'C':
                arr[0] = 2;
                break;
            case 'D':
                arr[0] = 3;
                break;
            case 'E':
                arr[0] = 4;
                break;
            case 'F':
                arr[0] = 5;
                break;
            case 'G':
                arr[0] = 6;
                break;
            case 'H':
                arr[0] = 7;
                break;
        }
        arr[1] = Integer.parseInt(String.valueOf(position.charAt(1))) - 1;
        return arr;
    }

    public static ChessPiece[] fulfillBoard() {
        ChessPiece[] allPieces = new ChessPiece[32];
        allPieces[1] = new ChessPiece(ONBOARD, KING, true, "E1");// white king
        allPieces[0] = new ChessPiece(ONBOARD, KING, false, "E8");// black king

        allPieces[4] = new ChessPiece(ONBOARD, ROOK, true, "A1");
        allPieces[20] = new ChessPiece(ONBOARD, KNIGHT, true, "B1");
        allPieces[2] = new ChessPiece(ONBOARD, BISHOP, true, "C1");
        allPieces[3] = new ChessPiece(ONBOARD, QUEEN, true, "D1");
        allPieces[5] = new ChessPiece(ONBOARD, BISHOP, true, "F1");
        allPieces[6] = new ChessPiece(ONBOARD, KNIGHT, true, "G1");
        allPieces[7] = new ChessPiece(ONBOARD, ROOK, true, "H1");

        allPieces[8] = new ChessPiece(ONBOARD, PAWN, true, "A2");
        allPieces[9] = new ChessPiece(ONBOARD, PAWN, true, "B2");
        allPieces[10] = new ChessPiece(ONBOARD, PAWN, true, "C2");
        allPieces[11] = new ChessPiece(ONBOARD, PAWN, true, "D2");
        allPieces[12] = new ChessPiece(ONBOARD, PAWN, true, "E2");
        allPieces[13] = new ChessPiece(ONBOARD, PAWN, true, "F2");
        allPieces[14] = new ChessPiece(ONBOARD, PAWN, true, "G2");
        allPieces[15] = new ChessPiece(ONBOARD, PAWN, true, "H2");

        allPieces[16] = new ChessPiece(ONBOARD, ROOK, false, "A8");
        allPieces[17] = new ChessPiece(ONBOARD, KNIGHT, false, "B8");
        allPieces[18] = new ChessPiece(ONBOARD, BISHOP, false, "C8");
        allPieces[19] = new ChessPiece(ONBOARD, QUEEN, false, "D8");
        allPieces[21] = new ChessPiece(ONBOARD, BISHOP, false, "F8");
        allPieces[22] = new ChessPiece(ONBOARD, KNIGHT, false, "G8");
        allPieces[23] = new ChessPiece(ONBOARD, ROOK, false, "H8");

        allPieces[24] = new ChessPiece(ONBOARD, PAWN, false, "A7");
        allPieces[25] = new ChessPiece(ONBOARD, PAWN, false, "B7");
        allPieces[26] = new ChessPiece(ONBOARD, PAWN, false, "C7");
        allPieces[27] = new ChessPiece(ONBOARD, PAWN, false, "D7");
        allPieces[28] = new ChessPiece(ONBOARD, PAWN, false, "E7");
        allPieces[29] = new ChessPiece(ONBOARD, PAWN, false, "F7");
        allPieces[30] = new ChessPiece(ONBOARD, PAWN, false, "C7");
        allPieces[31] = new ChessPiece(ONBOARD, PAWN, false, "H7");

        return allPieces;
    }
}
