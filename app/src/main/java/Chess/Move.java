package Chess;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Move {

    static Board.Position[] moveDirection(Move.Direction direction, Board.Position position, int maxDistance){

        Board.Position[] arrayPosition = new Board.Position[maxDistance];

        for(int i=0; i<arrayPosition.length; i++){
            int newRank = position.getRank() + direction.getRankDirection()*(i+1);
            int newFile = direction.getFileDirection() + direction.getFileDirection()*(i+1);
            arrayPosition[i] = new Board.Position(newRank, newFile);
        }
        return arrayPosition;
    }

    public static Board.Position[][] moveDirections(Move.Direction[] arrayDirection, Board.Position position, int maxDistance){

        Board.Position[][] arrayPosition = new Board.Position[maxDistance][arrayDirection.length];

        for(int i=0;i<arrayDirection.length;i++){

            Board.Position[] arrayPosition1Direction = new Board.Position[arrayDirection.length];

            arrayPosition1Direction = Move.moveDirection(arrayDirection[i], position, maxDistance);

            for(int j=0; j<maxDistance; j++){
                arrayPosition[j][i] = arrayPosition1Direction[j];
            }
        }

        return arrayPosition;
    }

    static Board.Position[] moveLDirection(Move.Direction direction, Board.Position position){

        int maxDistance = 2;

        Board.Position[] arrayPosition = new Board.Position[2];

//        For each direction, a L move can be vertical or horizontal. A VL has its longest movement
//        in the vertical direction

        int newRankVL = position.getRank() + direction.getRankDirection()*(maxDistance);
        int newFileVL = position.getFile() + direction.getFileDirection()*(maxDistance-1);

        int newRankHL = position.getRank() + direction.getRankDirection()*(maxDistance-1);
        int newFileHL = position.getFile() + direction.getFileDirection()*(maxDistance);

        arrayPosition[0] = new Board.Position(newRankHL, newFileHL);
        arrayPosition[1] = new Board.Position(newRankVL, newFileVL);

        return arrayPosition;
    }

    public static Board.Position[][] moveLDirections(Move.Direction[] arrayDirection, Board.Position position){

        int nbMovePerDirection = 2;

        Board.Position[][] arrayPosition = new Board.Position[nbMovePerDirection][arrayDirection.length];

        for(int i=0;i<arrayDirection.length;i++){

            Board.Position[] arrayPosition1Direction = new Board.Position[arrayDirection.length];

            arrayPosition1Direction = Move.moveLDirection(arrayDirection[i], position);

            for(int j=0; j<nbMovePerDirection; j++){
                arrayPosition[j][i] = arrayPosition1Direction[j];
            }
        }

        return arrayPosition;
    }


    public static class Direction{

        int rankDirection;
        int fileDirection;

        public Direction(int rankDirection, int fileDirection) {

            this.rankDirection = rankDirection;
            this.fileDirection = fileDirection;

        }

        public int getRankDirection() {
            return rankDirection;
        }

        public void setRankDirection(int rankDirection) {
            this.rankDirection = rankDirection;
        }

        public int getFileDirection() {
            return fileDirection;
        }

        public void setFileDirection(int fileDirection) {
            this.fileDirection = fileDirection;
        }
    }

}
