package Chess;

public class Directions {

    static Move.Direction N = new Move.Direction(0, 1);
    static Move.Direction NE = new Move.Direction(1, 1);
    static Move.Direction E = new Move.Direction(1, 0);
    static Move.Direction SE = new Move.Direction(-1, 1);
    static Move.Direction S = new Move.Direction(0, -1);
    static Move.Direction SW = new Move.Direction(-1, -1);
    static Move.Direction W = new Move.Direction(0, -1);
    static Move.Direction NW = new Move.Direction(-1, 1);

    static Move.Direction wideLshapeNE = new Move.Direction(1,2);
    static Move.Direction tallLshapeNE = new Move.Direction(2,1);
    static Move.Direction wideLshapeSE = new Move.Direction(-1,2);
    static Move.Direction tallLshapeSE = new Move.Direction(-2,1);
    static Move.Direction wideLshapeSW = new Move.Direction(-1,-2);
    static Move.Direction tallLshapeSW = new Move.Direction(-2,-1);
    static Move.Direction wideLshapeNW = new Move.Direction(1,-2);
    static Move.Direction tallLshapeNW = new Move.Direction(2,-1);

    public static Move.Direction getN() {
        return N;
    }

    public static Move.Direction getNE() {
        return NE;
    }

    public static Move.Direction getE() {
        return E;
    }

    public static Move.Direction getSE() {
        return SE;
    }

    public static Move.Direction getS() {
        return S;
    }

    public static Move.Direction getSW() {
        return SW;
    }

    public static Move.Direction getW() {
        return W;
    }

    public static Move.Direction getNW() {
        return NW;
    }

    public static Move.Direction getWideLshapeNE() {
        return wideLshapeNE;
    }

    public static Move.Direction getTallLshapeNE() {
        return tallLshapeNE;
    }

    public static Move.Direction getWideLshapeSE() {
        return wideLshapeSE;
    }

    public static Move.Direction getTallLshapeSE() {
        return tallLshapeSE;
    }

    public static Move.Direction getWideLshapeSW() {
        return wideLshapeSW;
    }

    public static Move.Direction getTallLshapeSW() {
        return tallLshapeSW;
    }

    public static Move.Direction getWideLshapeNW() {
        return wideLshapeNW;
    }

    public static Move.Direction getTallLshapeNW() {
        return tallLshapeNW;
    }
}
