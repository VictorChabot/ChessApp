package Chess;

import Chess.Move.Direction;

public class Knight extends Piece{
    protected int maxDistance;
    protected int nbPossiblePositions;
    protected Direction[] possibleDirection;

    public Knight(int team, Board.Position position) {
        super(team, position);

        this.name = "Knight";

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
        arrayPositions = Move.moveLDirections(this.directions, this.position);

        return arrayPositions;

    }

    @Override
    Board.Position[][] moveFunction() {

        Board.Position[][] arrayPositions;
        arrayPositions = Move.moveLDirections(this.directions, this.position);

        return arrayPositions;

    }


}
