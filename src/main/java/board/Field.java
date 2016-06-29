package board;

import config.Configuration;

public class Field {

    int position;

    Sign sign;

    public Field(int position, Sign sign) {
        this.position = position;
        this.sign = sign;
    }

    @Override
    public String toString() { // improve this method
        String result = !sign.equals(Sign.EMPTY) ? sign.toString() : (position+1) + "";
        if((position+1) % Configuration.BOARD_SIZE == 0) {
            result += "\n";
        }
        return result;
    }

}