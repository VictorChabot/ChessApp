package Chess.Pieces;

import Chess.Board;
import Chess.Directions;
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

        directions[0] = Directions.getNW();
        directions[1] = Directions.getSW();
        directions[2] = Directions.getSE();
        directions[3] = Directions.getNE();

        this.directions = directions;

    }


}
