package Chess;

public abstract class Piece {
    private final String name;
    private final boolean isWhite;
    private final Coordinates initialPosition;
    private Coordinates position;

    public Piece(String name, boolean isWhite, Coordinates position) {
        this.name = name;
        this.isWhite = isWhite;
        this.initialPosition = position;
        this.position = position;
    }

    abstract Coordinates[] moveSpace();
    abstract Coordinates[] captureSpace();

    abstract boolean moveOrCapture();

}
