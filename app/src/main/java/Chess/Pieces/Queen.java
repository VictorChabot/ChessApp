package Chess.Pieces;

import Chess.Board;
import Chess.Directions;
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

        directions[0] = Directions.getN();
        directions[1] = Directions.getNW();
        directions[2] = Directions.getW();
        directions[3] = Directions.getSW();
        directions[4] = Directions.getS();
        directions[5] = Directions.getSE();
        directions[6] = Directions.getE();
        directions[7] = Directions.getNE();

        this.directions = directions;

        this.setPositions();

    }

}
