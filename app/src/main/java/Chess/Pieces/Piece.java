package Chess.Pieces;

import Chess.Board;
import Chess.Move;

public abstract class Piece {
    protected String name;
    protected int team;
    protected boolean canCaptureFoe;
    protected boolean canCapturePeer;
    protected int nbMoves;
    protected Board.Position position;
    protected Move.Direction[] directions;
    protected Board.Position[][] moveablePositions;
    protected Board.Position[][] capturablePositions;
    protected int maxDistance;

    public Piece(String name, int team, boolean canCaptureFoe, boolean canCapturePeer, Board.Position position, int maxDistance) {
        this.name = name;
        this.team = team;
        this.maxDistance = maxDistance;
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

    public void setTeam(int team) {
        this.team = team;
    }

    public void setCanCaptureFoe(boolean canCaptureFoe) {
        this.canCaptureFoe = canCaptureFoe;
    }

    public void setCanCapturePeer(boolean canCapturePeer) {
        this.canCapturePeer = canCapturePeer;
    }

    public Board.Position[][] getMoveablePositions() {
        return moveablePositions;
    }

    public void setMoveablePositions(Board.Position[][] moveablePositions) {
        this.moveablePositions = moveablePositions;
    }

    public Board.Position[][] getCapturablePositions() {
        return capturablePositions;
    }

    public void setCapturablePositions(Board.Position[][] capturablePositions) {
        this.capturablePositions = capturablePositions;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setMoveablePositions(){
        this.moveablePositions = Move.moveDirections(this.directions, this.position, this.maxDistance);
    }

    public void setCapturablePositions(){
        this.capturablePositions = Move.moveDirections(this.directions, this.position, this.maxDistance);
    }

    public void setPositions(){
        this.setMoveablePositions();
        this.setCapturablePositions();
    }

}
