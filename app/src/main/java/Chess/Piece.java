package Chess;

public abstract class Piece {
    protected String name;
    protected int team;
    protected boolean canCaptureFoe;
    protected boolean canCapturePeer;
    protected int nbMoves;
    protected Board.Position position;
    protected Move.Direction[] directions;

    public Piece(String name, int team, boolean canCaptureFoe, boolean canCapturePeer, Board.Position position) {
        this.name = name;
        this.team = team;
        this.canCaptureFoe = canCaptureFoe;
        this.canCapturePeer = canCapturePeer;
        this.nbMoves = 0;
        this.position = position;
    }

    public Piece(int team, boolean canCaptureFoe, boolean canCapturePeer, Board.Position position) {
        this.team = team;
        this.canCaptureFoe = canCaptureFoe;
        this.canCapturePeer = canCapturePeer;
        this.nbMoves = 0;
        this.position = position;
    }

    public Piece(int team, Board.Position position) {
        this.team = team;
        this.nbMoves = 0;
        this.position = position;
    }

    public Move.Direction[] getDirections() {
        return directions;
    }

    public void setDirections(Move.Direction[] directions) {
        this.directions = directions;
    }

    public String getName() {
        return name;
    }

    public int getTeam() {
        return team;
    }

    public boolean isCanCaptureFoe() {
        return canCaptureFoe;
    }

    public boolean isCanCapturePeer() {
        return canCapturePeer;
    }

    public int getNbMoves() {
        return nbMoves;
    }

    public void setNbMoves(int nbMoves) {
        this.nbMoves = nbMoves;
    }

    public Board.Position getPosition() {
        return position;
    }

    public int getFile(){
        return this.position.getFile();
    }

    public int getRank(){
        return this.position.getRank();
    }

    public void setPosition(Board.Position position) {
        this.position = position;
    }

    abstract Board.Position[][] moveFunction();

    abstract Board.Position[][] captureFunction();

}
