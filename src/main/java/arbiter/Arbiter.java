package arbiter;

import board.Sign;
import java.util.Set;
import java.util.stream.Collectors;

public class Arbiter {

    TakenPositionsWrapper takenPositionsWrapper;
    Set<Sequence> playerOWinSequences;
    Set<Sequence> playerXWinSequences;

    public Arbiter(TakenPositionsWrapper takenPositionsWrapper, Set<Sequence> availableWinSequences) {
        this.takenPositionsWrapper = takenPositionsWrapper;
        this.playerOWinSequences = availableWinSequences;
        this.playerXWinSequences = availableWinSequences;
    }

    public boolean checkWinCondition(Sign sign, int lastMove) {
        Set<Sequence> matchingSequences;
        if(sign.equals(Sign.O)) {
            playerXWinSequences = removeImpossibleSequences(playerXWinSequences, lastMove);
            matchingSequences = findMatchingSequences(playerOWinSequences, lastMove);
        } else {
            playerOWinSequences = removeImpossibleSequences(playerOWinSequences, lastMove);
            matchingSequences = findMatchingSequences(playerXWinSequences, lastMove);
        }
        return checkMatchingSequences(matchingSequences, sign);
    }

    private Set<Sequence> removeImpossibleSequences(Set<Sequence> availableSequences, int number) {
        return availableSequences.stream()
                .filter(e -> !e.containsNumber(number))
                .collect(Collectors.toSet());
    }

    private Set<Sequence> findMatchingSequences(Set<Sequence> availableSequences, int number) {
        return availableSequences.stream()
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