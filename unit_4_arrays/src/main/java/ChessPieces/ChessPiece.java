package ChessPieces;

import static board.ChessBoard.convertPosition;

public class ChessPiece {

    private Statuses status;
    private Types type;
    private boolean color; // true - white, false - black
    private String location;

    public ChessPiece(Statuses status, Types type, boolean color, String location) {
        this.status = status;
        this.color = color;
        this.type = type;
        this.location = location;
    }

    public boolean checkMove(String location, String toMove) {

        int[] arr = new int[2];
        arr = convertPosition(location);
        int x1 = arr[0];
        int y1 = arr[1];
        arr = convertPosition(toMove);
        int x2 = arr[0];
        int y2 = arr[1];
        switch (this.type) {
            case PAWN: {
                if ((y1 == 1 && this.color) || (y1 == 6 && !this.color)) {
                    // may be 1 or 2 steps ahead
                    return ((x2 == x1) && (y2 - y1 <= 2));
                } else {
                    // may be 1 step ahead
                    return (y2 - y1 == 1 && x2 == x1);
                    // or diagonally if there is some piece in there
                }
            }
            case KING: {
                // can move 1 step in different directions
                return (Math.abs(x2 - x1) == 1 && Math.abs(y2 - y1) == 1);
            }
            case ROOK: {
                // can move if Math.abs(m2 - m1) != Math.abs(n2 - n1)
                return (Math.abs(x2 - x1) != Math.abs(y2 - y1));
            }
            case QUEEN: {
                return (Math.abs(x2 - x1) != Math.abs(y2 - y1) || Math.abs(x2 - x1) == Math.abs(y2 - y1));
            }
            case BISHOP: {
                // can move if Math.abs(m2 - m1) == Math.abs(n2 - n1)
                return (Math.abs(x2 - x1) == Math.abs(y2 - y1));
            }
            case KNIGHT: {
                return (Math.abs(x1 - x2) == 1 && Math.abs(y1 - y2) == 2 || Math.abs(x1 - x2) == 2 && Math.abs(y1 - y2) == 1);
            }
            default:
                return false;
        }
    }

    public void setStatus(Statuses status1) {
        status = status1;
    }

    public void setLocation(String location1) {
        location = location1;
    }

    public Statuses getStatus() {
        return status;
    }

    public Types getType() {
        return type;
    }

    public boolean getColor() {
        return color;
    }

    public String getLocation() {
        return location;
    }
}
