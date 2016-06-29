package board;

public class Field {

    int position;

    Sign sign;

    public Field(int position, Sign sign) {
        this.position = position;
        this.sign = sign;
    }

    @Override
    public String toString() {
        return !sign.equals(Sign.EMPTY) ? sign + " " : (position+1) + " ";
    }

}