package board;

import java.util.Objects;
import java.util.Scanner;
import static ChessPieces.STATUSES.*;
import static ChessPieces.TYPES.*;
import static board.ChessBoard.fillBoard;
import static board.ChessBoard.fulfillBoard;
import ChessPieces.ChessPiece;

public class ChessGame {

    public static void play(){

        Scanner in = new Scanner(System.in);
        boolean gameStatus= true;
        boolean colorMove = true; // true - white, false- black
        int moves=0;
        fillBoard();
        ChessPiece[] pieces = fulfillBoard();
        while(gameStatus && pieces[0].getStatus() == ONBOARD && pieces[1].getStatus() == ONBOARD){
            String typesOfPieces = "pawn,king,queen,rook,bishop,knight";
            String piece= "none";
            if(colorMove)System.out.println("Move of white:");
            else System.out.println("Move of black:");
            boolean correctMove= false;
            while(!correctMove){
                while(!typesOfPieces.contains(piece)){
                    System.out.println("Pick up piece (or giveUp - break): "+ typesOfPieces);
                    piece = in.nextLine().toLowerCase();
                    if(piece.contains("break") ) {
                        gameStatus=false;
                        correctMove=true;
                        break;
                    }
                }
                if(piece.contains("break") ) break;
                System.out.println("Chose moveTo coordinate (like C4 or H3): ");
                String moveTo = in.nextLine().toUpperCase();
                switch(piece){
                    case "pawn":{
                        for(int i=0; i< pieces.length; i++){
                            if(pieces[i].getStatus()==ONBOARD && pieces[i].getType() == PAWN  && pieces[i].getColor()== colorMove){
                                boolean isMove = pieces[i].checkMove(pieces[i].getLocation(), moveTo);
                                if(isMove){
                                    correctMove = true;
                                    // check: is some piece on that position
                                    for(int j=0; j< pieces.length; j++){
                                        if(Objects.equals(pieces[j].getLocation(), moveTo) && pieces[j].getColor()!=colorMove){
                                            pieces[j].setStatus(TAKES);
                                        }
                                        if(Objects.equals(pieces[j].getLocation(), moveTo) && pieces[j].getColor()==colorMove){
                                            correctMove =false;
                                        }
                                    }
                                    // move
                                    pieces[i].setLocation(moveTo);
                                }
                            }
                        }
                    }break;
                    case "king":{
                        for(int i=0; i< pieces.length; i++){
                            if(pieces[i].getType() == KING  && pieces[i].getColor()== colorMove){
                                boolean isMove = pieces[i].checkMove(pieces[i].getLocation(), moveTo);
                                if(isMove){
                                    correctMove = true;
                                    // check: is some piece on that position
                                    for(int j=0; j< pieces.length; j++){
                                        if(Objects.equals(pieces[j].getLocation(), moveTo) && pieces[j].getColor()!=colorMove){
                                            pieces[j].setStatus(TAKES);
                                        }
                                        if(Objects.equals(pieces[j].getLocation(), moveTo) && pieces[j].getColor()==colorMove){
                                            correctMove =false;
                                        }
                                    }
                                    // move
                                    pieces[i].setLocation(moveTo);
                                }
                            }
                        }
                    }break;
                    case "queen":{
                        for(int i=0; i< pieces.length; i++){
                            if(pieces[i].getStatus()==ONBOARD && pieces[i].getType() == QUEEN  && pieces[i].getColor()== colorMove){
                                boolean isMove = pieces[i].checkMove(pieces[i].getLocation(), moveTo);
                                if(isMove){
                                    correctMove = true;
                                    // check: is some piece on that position
                                    for(int j=0; j< pieces.length; j++){
                                        if(Objects.equals(pieces[j].getLocation(), moveTo) && pieces[j].getColor()!=colorMove){
                                            pieces[j].setStatus(TAKES);
                                        }
                                        if(Objects.equals(pieces[j].getLocation(), moveTo) && pieces[j].getColor()==colorMove){
                                            correctMove =false;
                                        }
                                    }
                                    // move
                                    pieces[i].setLocation(moveTo);
                                }
                            }
                        }
                    }break;
                    case "rook":{
                        for(int i=0; i< pieces.length; i++){
                            if(pieces[i].getStatus()==ONBOARD && pieces[i].getType() == ROOK  && pieces[i].getColor()== colorMove){
                                boolean isMove = pieces[i].checkMove(pieces[i].getLocation(), moveTo);
                                if(isMove){
                                    correctMove = true;
                                    // check: is some piece on that position
                                    for(int j=0; j< pieces.length; j++){
                                        if(Objects.equals(pieces[j].getLocation(), moveTo) && pieces[j].getColor()!=colorMove){
                                            pieces[j].setStatus(TAKES);
                                        }
                                        if(Objects.equals(pieces[j].getLocation(), moveTo) && pieces[j].getColor()==colorMove){
                                            correctMove =false;
                                        }
                                    }
                                    // move
                                    pieces[i].setLocation(moveTo);
                                }
                            }
                        }

                    }break;
                    case "bishop":{
                        for(int i=0; i< pieces.length; i++){
                            if(pieces[i].getStatus()==ONBOARD && pieces[i].getType() == BISHOP  && pieces[i].getColor()== colorMove){
                                boolean isMove = pieces[i].checkMove(pieces[i].getLocation(), moveTo);
                                if(isMove){
                                    correctMove = true;
                                    // check: is some piece on that position
                                    for(int j=0; j< pieces.length; j++){
                                        if(Objects.equals(pieces[j].getLocation(), moveTo) && pieces[j].getColor()!=colorMove){
                                            pieces[j].setStatus(TAKES);
                                        }
                                        if(Objects.equals(pieces[j].getLocation(), moveTo) && pieces[j].getColor()==colorMove){
                                            correctMove =false;
                                        }
                                    }
                                    // move
                                    pieces[i].setLocation(moveTo);
                                }
                            }
                        }
                    }break;
                    case "knight":{
                        for(int i=0; i< pieces.length; i++){
                            if(pieces[i].getStatus()==ONBOARD && pieces[i].getType() == KNIGHT  && pieces[i].getColor()== colorMove){
                                boolean isMove = pieces[i].checkMove(pieces[i].getLocation(), moveTo);
                                if(isMove){
                                    correctMove = true;
                                    // check: is some piece on that position
                                    for(int j=0; j< pieces.length; j++){
                                        if(Objects.equals(pieces[j].getLocation(), moveTo) && pieces[j].getColor()!=colorMove){
                                            pieces[j].setStatus(TAKES);
                                        }
                                        if(Objects.equals(pieces[j].getLocation(), moveTo) && pieces[j].getColor()==colorMove){
                                            correctMove =false;
                                        }
                                    }
                                    // move
                                    pieces[i].setLocation(moveTo);
                                }
                            }
                        }
                    }break;
                    default: break;
                }
                if(!correctMove) {
                    System.out.println("Incorrect move of piece, chose different piece or position:");
                    piece = "none";
                }
            }
            colorMove = !colorMove;
        }
        if(pieces[0].getStatus() == TAKES) System.out.println("WHITE KING IS WINNER");
        if(pieces[1].getStatus() == TAKES) System.out.println("BLACK KING IS WINNER");
        else System.out.println("GAME ABORTED");
    }
}
