package arbiter;

import board.Sign;

import java.util.Set;
import java.util.stream.Collectors;

public class SequencesChecker {

    private TakenPositionsWrapper takenPositions;

    SequencesChecker(TakenPositionsWrapper takenPositions) {
        this.takenPositions = takenPositions;
    }

    Set<Sequence> removeImpossibleSequences(Set<Sequence> availableSequences, int number) {
        return availableSequences.stream()
                .filter(e -> !e.containsNumber(number))
                .collect(Collectors.toSet());
    }

    Set<Sequence> findMatchingSequences(Set<Sequence> availableSequences, int number) {
        return availableSequences.stream()
                .filter(e -> e.containsNumber(number))
                .collect(Collectors.toSet());
    }

    boolean checkMatchingSequences(Set<Sequence> matchingSequences, Sign sign) {
        for (Sequence sequence : matchingSequences) {
            if(sequence.checkSequence(takenPositions, sign)) {
                return true;
            }
        }
        return false;
    }

}