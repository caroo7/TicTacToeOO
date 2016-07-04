package arbiter;

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

    public boolean containsNumber(int number) {
        return numberSequence.contains(number);
    }
}
