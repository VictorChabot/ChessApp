package Chess;

import android.view.MotionEvent;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import Chess.Pieces.Piece;

public class Board {

    final int nbFiles;
    final int nbRanks;

    Square[][] board;

    public Board(Square[][] board){

        this.board = board;

        this.nbRanks = board.length;
        this.nbFiles = board[0].length;

        for(int i = 0; i<this.nbRanks; i++){
            for(int j = 0; j<this.nbFiles; j++){
                Square square = new Square(i,j);
                this.setSquare(i,j, square);
            }
        }

    }

    public Board(int nbRanks, int nbFiles){

        this.nbRanks = nbRanks;
        this.nbFiles = nbFiles;


        this.board = new Square[this.nbRanks][this.nbFiles];

        for(int i = 0; i<this.nbRanks; i++){
            for(int j = 0; j<this.nbFiles; j++){
                Square square = new Square(i,j);
                this.setSquare(i,j, square);
            }
        }

    }

////////////////////////////////////////    Getters and setters

    public int getNbFiles() {
        return nbFiles;
    }

    public int getNbRanks() {
        return nbRanks;
    }

    public Square[][] getBoard() {
        return board;
    }

    public void setBoard(Square[][] board) {
        this.board = board;
    }
    ////////////////////////////////////////    Getters and setters for square
    public Square getSquare(int rank, int file){
        return this.board[rank][file];
    }

    public Square getSquare(Board.Position position){
        return this.board[position.getRank()][position.getFile()];
    }

    public void setSquare(int rank, int file, Square square){
        this.board[rank][file] = square;
    }

    public void addPiece(@NotNull Square square, Piece piece){
        this.board[square.getRank()][square.getFile()].setPiece(piece);
    }

    public void addPiece(int rank, int file, Piece piece){
        this.board[rank][file].setPiece(piece);
    }

    public Piece getPiece(Board.Position position){
        return this.getSquare(position).getPiece();
    }



////////////////////////////////////////    Getters and setters

    public boolean isObstructed(Board.Position position, Piece piece){

        Piece destinationPiece = this.getSquare(position).getPiece();


        if(destinationPiece==null){
            return true;
        }
        if(destinationPiece.getTeam()!=piece.getTeam()){
            if(piece.isCanCaptureFoe()){
                return true;
            }
        }
        if(destinationPiece.getTeam()==piece.getTeam()){
            if(piece.isCanCapturePeer()){
                return true;
            }
        }

        return false;

    }

    public boolean[] isObstructed(Board.Position[] position, Piece piece){

        boolean[] isObstructed = new boolean[position.length];

        if(piece.isCanJump()){

            for(int i=0; i<position.length;i++){

                isObstructed[i] = this.isObstructed(position[i], piece);

            }
        }

        else {

            for(int i=0; i<position.length;i++){

                boolean isObstructedi = this.isObstructed(position[i], piece);

                if(isObstructedi){
                    isObstructed[i]=true;
                }
                else{
                    for(int j=i; j<position.length;j++){
                        isObstructed[j]=false;
                    }
//                    NOT SURE IF THIS BREAK IS IN THE PROPER SCOPE
                    break;
                }

            }

        }

        return isObstructed;
    }

    public boolean[][] isObstructed(Board.Position[][] position2D, Piece piece){

        boolean isObstructed2D[][] = new boolean[position2D.length][position2D[0].length];

        int nbCols = position2D[0].length;

        for(int i=0; i<position2D.length; i++){
            Board.Position[] position1D = new Board.Position[nbCols];
            position1D = position2D[i];

            isObstructed2D[i] = isObstructed(position1D, piece);
        }

        return isObstructed2D;
    }

    public boolean isCapturable(Board.Position position, Piece piece){
        Piece attackedPiece = this.getSquare(position).getPiece();

        if(attackedPiece!=null){

            int attackingTeam = piece.getTeam();
            int attackedTeam = attackedPiece.getTeam();

            if(piece.isCanCaptureFoe()){
                if(attackingTeam!=attackedTeam){
                    return true;
                }
            }

            if(piece.isCanCapturePeer()){
                if(attackingTeam==attackedTeam){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean[] isCapturable(Board.Position[] position, Piece piece){

        boolean[] isCapturable1D = new boolean[position.length];

        for(int i=0; i<position.length; i++){
            isCapturable1D[i] = isCapturable(position[i], piece);
        }

        return isCapturable1D;

    }

    public boolean[][] isCapturable(Board.Position[][] position2D, Piece piece){

        boolean[][] isCapturable2D = new boolean[position2D.length][position2D[0].length];

        for(int i=0; i<position2D.length; i++){

            Board.Position[] position1D = position2D[i];

            isCapturable2D[i] = isCapturable(position1D, piece);
        }

        return isCapturable2D;

    }

    @Nullable
    public Board.Position[][] getMoveablePosition(Board.Position position){

        Piece piece = this.getPiece(position);

        return piece.getMoveablePositions();

    }

    @Nullable
    public Board.Position[][] getCapturablePosition(Board.Position position){

        Piece piece = this.getPiece(position);

        return piece.getCapturablePositions();

    }

//    public Board.Position[][] canMove(Board.Position position){
//
//        Board.Position[][] position2D = this.getMoveablePosition(position);
//
//        boolean[][] isNotObstructed = isObstructed(position2D);
//
//        return isNotObstructed;
//
//    }







    ////////////////////////////////////////    Square inner class
    protected class Square{
        final Position position;
        Piece piece;

        public Square(int file, int rank, Piece piece) {
            this.position = new Position(rank, file);
            this.piece = piece;
        }

        public Square(int file, int rank) {
            this.position = new Position(rank, file);
            this.piece = null;
        }

        public int getFile() {
            return position.getFile();
        }

        public int getRank() {
            return position.getRank();
        }

        public Piece getPiece() {
            return piece;
        }

        public void setPiece(Piece piece) {
            this.piece = piece;
        }
    }

    public static class Position{
        int file;
        int rank;

        public Position(int rank, int file) {
            this.rank = rank;
            this.file = file;

        }

        public int getFile() {
            return file;
        }

        public void setFile(int file) {
            this.file = file;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }
    }


}
