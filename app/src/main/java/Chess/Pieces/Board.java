package Chess.Pieces;

import org.jetbrains.annotations.NotNull;

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

        this.board = new  Square[this.nbRanks][this.nbFiles];

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

    public void setSquare(int rank, int file, Square square){
        this.board[rank][file] = square;
    }

    public void addPiece(@NotNull Square square, Piece piece){
        this.board[square.getRank()][square.getFile()].setPiece(piece);
    }

    public void addPiece(int rank, int file, Piece piece){
        this.board[rank][file].setPiece(piece);
    }

////////////////////////////////////////    Getters and setters



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
