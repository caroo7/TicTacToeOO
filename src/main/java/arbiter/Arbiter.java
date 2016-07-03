package arbiter;

import board.Sign;

import java.util.Set;
import java.util.stream.Collectors;

public class Arbiter {

    TakenPositionsWrapper takenPositionsWrapper;
    Set<Sequence> availableWinSequences;

    public Arbiter(TakenPositionsWrapper takenPositionsWrapper, Set<Sequence> availableWinSequences) {
        this.takenPositionsWrapper = takenPositionsWrapper;
        this.availableWinSequences = availableWinSequences;
    }

    public boolean checkWinCondition(Sign sign, int lastMove) {
        Set<Sequence> matchingSequences = findMatchingSequences(lastMove);
        return checkMatchingSequences(matchingSequences, sign);
    }

    private Set<Sequence> findMatchingSequences(int number) {
        return availableWinSequences.stream()
                .filter(e -> e.containsNumber(number))
                .collect(Collectors.toSet());
    }

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

    private boolean checkSequence(Sequence sequence, Sign sign) {
        boolean result = true;
        for (int number : sequence.numberSequence) {
            if (!takenPositionsWrapper.takenPositions.containsKey(number)) {
                result = false;
            } else if(!takenPositionsWrapper.takenPositions.get(number).equals(sign)) {
                result = false;
            }
        }
        return result;
    }

}