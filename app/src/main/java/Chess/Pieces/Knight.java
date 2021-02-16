package Chess.Pieces;

import Chess.Board;
import Chess.Move;
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

        this.maxDistance = 1;

        Direction[] directions = new Direction[4];

        directions[0] = new Direction(1,2);
        directions[1] = new Direction(2,1);
        directions[2] = new Direction(-1,2);
        directions[3] = new Direction(-2,1);
        directions[4] = new Direction(-1,-2);
        directions[5] = new Direction(-2,-1);
        directions[6] = new Direction(1,-2);
        directions[7] = new Direction(2,-1);

        this.directions = directions;

        this.nbPossiblePositions = this.directions.length*this.maxDistance;

    }



}
