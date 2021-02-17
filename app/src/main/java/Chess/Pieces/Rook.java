package Chess.Pieces;

import Chess.Board;
import Chess.Directions;
import Chess.Move;
import Chess.Move.Direction;

public class Rook extends Piece{
    protected int maxDistance;
    protected int nbPossiblePositions;
    protected Direction[] possibleDirection;

    public Rook(int team, Board.Position position) {
        super(team, position);

        this.name = "Rook";

        this.canCaptureFoe=true;
        this.canCapturePeer=false;

        this.maxDistance = 8;
        this.nbPossiblePositions = this.maxDistance*4;

        Direction[] directions = new Direction[4];

        directions[0] = Directions.getN();
        directions[1] = Directions.getW();
        directions[2] = Directions.getS();
        directions[3] = Directions.getE();

        this.directions = directions;

    }

}
