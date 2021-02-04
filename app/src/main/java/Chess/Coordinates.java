package Chess;


public class Coordinates {
    private int rank;
    private int file;

    Coordinates(int rank, int file){
        this.rank = rank;
        this.file = file;
    }


    public boolean isOnBoard(int rank, int file){
        if((0 <= rank) && (rank <= 7)){
            if((0 <= file) && (file <= 7)) {
                return true;
            }
        }

        return false;
}
}
