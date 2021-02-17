package Chess.Pieces;

import Chess.Board;

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

        this.setPositions();


    }

    public int getForward() {
        return this.forward;
    }

    public void setForward(int forward) {
        this.forward = forward;
    }


    @Override
    public void setMoveablePositions() {

//        Create an array of positions
        Board.Position[][] moveablePositions;

        // If it's the first move, possible to move two squares in front, so two possible moves
        if(this.nbMoves==0){

            moveablePositions = new Board.Position[2][1];

            int rankMove0 = this.getFile() + this.forward*2;
            moveablePositions[1][0] = new Board.Position(rankMove0, this.getFile());

//       If it's not the first move, can only move one square in front
        }else{
            moveablePositions = new Board.Position[1][1];
        }

        int rankMove1 = this.getFile() + this.forward*1;

        moveablePositions[0][0] = new Board.Position(rankMove1, this.getFile());

        this.moveablePositions = moveablePositions;
    }

    @Override
    public void setCapturablePositions() {

        Board.Position[][] capturablePositions = new Board.Position[2][1];

//        A pawn always capture one diagonal in its direction
        int rankCapture = this.getRank() + 1*this.forward;

        int fileCapture1 = this.getFile() - 1;
        int fileCapture2 = this.getFile() + 1;

        capturablePositions[0][0] = new Board.Position(rankCapture, fileCapture1);
        capturablePositions[1][0] = new Board.Position(rankCapture, fileCapture2);

        this.capturablePositions = capturablePositions;

    }



}