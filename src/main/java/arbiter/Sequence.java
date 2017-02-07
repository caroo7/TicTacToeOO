package arbiter;

import board.Sign;

import java.util.HashSet;
import java.util.Set;

public class Sequence {

    Set<Integer> numberSequence;

    Sequence(int... numbers) {
        numberSequence = new HashSet<>();
        for(int number: numbers) {
            numberSequence.add(number);
        }
    }

    boolean containsNumber(int number) {
        return numberSequence.contains(number);
    }

    boolean checkSequence(TakenPositionsWrapper takenPositions, Sign sign) {
        boolean result = true;
        for (int number : this.numberSequence) {
            if (!takenPositions.takenPositions.containsKey(number)) {
                result = false;
            } else if(!takenPositions.takenPositions.get(number).equals(sign)) {
                result = false;
            }
        }
        return result;
    }

}