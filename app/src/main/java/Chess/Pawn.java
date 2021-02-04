package Chess;

public class Pawn extends Piece {

    public Pawn(boolean isWhite, int rank, int file) {
        super("Chess.Pawn", isWhite, new Coordinates(rank, file));

    }

    @Override
    Coordinates[] moveSpace() {

        return new Coordinates[0];
    }

    @Override
    Coordinates[] captureSpace() {
        return new Coordinates[0];
    }

    @Override
    boolean moveOrCapture() {
        return false;
    }
}
