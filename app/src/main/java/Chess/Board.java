package Chess;

import org.jetbrains.annotations.NotNull;

public class Board {

    final int nbFiles;
    final int nbRanks;

    Square[][] board;

    public Board(Square[][] board){

        this.board = board;

        this.nbRanks = board.length;
        this.nbFiles = board[0].length;

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
    private class Square{
        final int file;
        final int rank;
        Piece piece;

        public Square(int file, int rank, Piece piece) {
            this.file = file;
            this.rank = rank;
            this.piece = piece;
        }

        public Square(int file, int rank) {
            this.file = file;
            this.rank = rank;
            this.piece = null;
        }

        public int getFile() {
            return file;
        }

        public int getRank() {
            return rank;
        }

        public Piece getPiece() {
            return piece;
        }

        public void setPiece(Piece piece) {
            this.piece = piece;
        }
    }


}
