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

        this.maxDistance = 8;
        this.nbPossiblePositions = 8;

        Direction[] directions = new Direction[4];

        directions[0] = new Direction(1,1);
        directions[1] = new Direction(-1,1);
        directions[2] = new Direction(-1,-1);
        directions[3] = new Direction(-1,1);

        this.directions = directions;

    }



}
