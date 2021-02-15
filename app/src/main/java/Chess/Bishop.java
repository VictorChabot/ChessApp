package Chess;

public class Bishop extends Piece{
    protected int maxDistance;
    protected int nbPossiblePositions;
    protected Move.Direction[] possibleDirection;

    public Bishop(int team, Board.Position position) {
        super(team, position);

        this.name = "Pawn";

        this.canCaptureFoe=true;
        this.canCapturePeer=false;

        this.maxDistance = 8;
        this.nbPossiblePositions = this.maxDistance*4;

        Move.Direction directionN = new Move.Direction(0,1);
        Move.Direction directionNE = new Move.Direction(1,1);
        Move.Direction directionE = new Move.Direction(1,0);
        Move.Direction directionSE = new Move.Direction(-1,-1);
        Move.Direction directionS = new Move.Direction(0,-1);
        Move.Direction directionSW = new Move.Direction(-1,-1);
        Move.Direction directionW = new Move.Direction(0,-1);
        Move.Direction directionNW = new Move.Direction(-1,1);



    }

    @Override
    Board.Position[] captureFunction() {
        return new Board.Position[0];
    }

    @Override
    Board.Position[] moveFunction() {


        return null;
    }

    Board.Position[] moveDiagonalDirection(int rankDirection, int fileDirection){

        Board.Position[] arrayPosition = new Board.Position[this.maxDistance];

        for(int i=0; i<arrayPosition.length; i++){
            int newRank = rankDirection*(i+1);
            int newFile = fileDirection*(i+1);
            arrayPosition[i] = new Board.Position(newRank, newFile);
        }

        return arrayPosition;
    }
}
