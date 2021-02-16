package Chess.Pieces;

import Chess.Board;
import Chess.Move;
import Chess.Move.Direction;

public class Queen extends Piece{
    protected int maxDistance;
    protected int nbPossiblePositions;
    protected Direction[] possibleDirection;

    public Queen(int team, Board.Position position) {
        super(team, position);

        this.name = "Queen";

        this.canCaptureFoe=true;
        this.canCapturePeer=false;

        this.maxDistance = 8;
        this.nbPossiblePositions = this.maxDistance*8;

        Direction[] directions = new Direction[8];

        directions[0] = new Direction(1,0);
        directions[1] = new Direction(1,1);
        directions[2] = new Direction(0,1);
        directions[3] = new Direction(-1,1);
        directions[4] = new Direction(-1,0);
        directions[5] = new Direction(-1,-1);
        directions[6] = new Direction(0,-1);
        directions[7] = new Direction(1,-1);

        this.directions = directions;

    }

}
