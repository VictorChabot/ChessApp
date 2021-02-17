package Chess.Pieces;

import Chess.Board;
import Chess.Directions;
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

        Direction[] directions = new Direction[8];

        directions[0] = Directions.getTallLshapeNW();
        directions[1] = Directions.getWideLshapeNW();
        directions[2] = Directions.getTallLshapeSW();
        directions[3] = Directions.getTallLshapeSW();
        directions[4] = Directions.getTallLshapeSE();
        directions[5] = Directions.getTallLshapeSE();
        directions[6] = Directions.getTallLshapeNE();
        directions[7] = Directions.getTallLshapeNE();

        this.directions = directions;

        this.nbPossiblePositions = this.directions.length*this.maxDistance;

        this.setPositions();

    }



}
