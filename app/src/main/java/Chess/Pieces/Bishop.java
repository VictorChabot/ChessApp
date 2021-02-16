package Chess.Pieces;

import Chess.Move;
import Chess.Move.Direction;

public class Bishop extends Piece{
    protected int maxDistance;
    protected int nbPossiblePositions;
    protected Direction[] possibleDirection;

    public Bishop(int team, Board.Position position) {
        super(team, position);

        this.name = "Bishop";

        this.canCaptureFoe=true;
        this.canCapturePeer=false;

        this.maxDistance = 8;
        this.nbPossiblePositions = this.maxDistance*4;

        Direction[] directions = new Direction[4];

        directions[0] = new Direction(1,1);
        directions[1] = new Direction(-1,1);
        directions[2] = new Direction(-1,-1);
        directions[3] = new Direction(-1,1);

        this.directions = directions;

    }

    @Override
    Board.Position[][] captureFunction() {

        Board.Position[][] arrayPositions;
        arrayPositions = Move.moveDirections(this.directions, this.position, this.maxDistance);

        return arrayPositions;

    }

    @Override
    Board.Position[][] moveFunction() {

        Board.Position[][] arrayPositions;
        arrayPositions = Move.moveDirections(this.directions, this.position, this.maxDistance);

        return arrayPositions;

    }


}
