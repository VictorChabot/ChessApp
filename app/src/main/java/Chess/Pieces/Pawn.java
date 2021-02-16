package Chess.Pieces;

public class Pawn extends Piece {

    protected int forward;


    public Pawn(int team, Board.Position position) {
        super(team, position);

        this.name = "Pawn";

        this.canCaptureFoe=true;
        this.canCapturePeer=false;

//        If the team number is even, then direction is forward, ie 1, else it's backward -1
        if((this.team%2)==0){
            this.forward = 1;
        }else{
            this.forward = -1;
        }

    }

    public int getForward() {
        return this.forward;
    }

    public void setForward(int forward) {
        this.forward = forward;
    }


    @Override
    Board.Position[][] moveFunction() {

//        Create an array of positions
        Board.Position[] arrayPosition;

        // If it's the first move, possible to move two squares in front, so two possible moves
        if(this.nbMoves==0){
            arrayPosition = new Board.Position[2];

            int rankMove0 = this.getFile() + this.forward*2;
            arrayPosition[0] = new Board.Position(rankMove0, this.getFile());

//       If it's not the first move, can only move one square in front
        }else{
           arrayPosition = new Board.Position[1];
        }

        int rankMove1 = this.getFile() + this.forward*1;

        arrayPosition[1] = new Board.Position(rankMove1, this.getFile());

        return arrayPosition;
    }

    @Override
    Board.Position[][] captureFunction() {

        Board.Position[] arrayPosition = new Board.Position[2];

//        A pawn always capture one diagonal in its direction
        int rankCapture = this.getRank() + 1*this.forward;

        int fileCapture1 = this.getFile() - 1;
        int fileCapture2 = this.getFile() + 1;

        arrayPosition[0] = new Board.Position(rankCapture, fileCapture1);
        arrayPosition[1] = new Board.Position(rankCapture, fileCapture2);

        return arrayPosition;

    }
}