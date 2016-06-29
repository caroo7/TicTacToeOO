package arbiter;

import board.Sign;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Arbiter {

    TakenPositions takenPositions;

    Set<Sequence> availableWinSequences;

    Sign winningSign;

    Arbiter(Set<Sequence> availableWinSequences, Sign winningSign) {
        this.availableWinSequences = availableWinSequences;
        this.winningSign = winningSign;
    }

    boolean checkWinCondition(Sign sign, int lastMove) {
        // find matching sequences for sign
        Set<Sequence> matchingSequences = findMatchingSequences(availableWinSequences, lastMove);

        //check if all signs in sequence are appropriate
        return checkMatchingSequences(matchingSequences, sign);
    }

    private Set<Sequence> findMatchingSequences(Set<Sequence> sequences, int number) {
        return sequences.stream()
                .filter(e -> e.containsNumber(number))
                .collect(Collectors.toSet());
    }

    //think about this implementation (KISS) - maybe use streams?
    private boolean checkMatchingSequences(Set<Sequence> matchingSequences, Sign sign) {
        for (Sequence sequence : matchingSequences) {
            if(checkSequence(sequence, sign)) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }

    //think about this implementation (KISS) - maybe use streams?
    private boolean checkSequence(Sequence sequence, Sign sign) {
        boolean result = true;
        for (int number : sequence.numberSequence) {
            if (!takenPositions.takenPositions.containsKey(number)) {
                result = false;
            } else if(!takenPositions.takenPositions.get(number).equals(sign)) {
                result = false;
            }
        }
        return result;
    }

}