package arbiter;

import board.Sign;
import java.util.Set;

public class Arbiter {

    TakenPositionsWrapper takenPositionsWrapper;
    Set<Sequence> playerOWinSequences;
    Set<Sequence> playerXWinSequences;
    private SequencesChecker checker;

    public Arbiter(TakenPositionsWrapper takenPositionsWrapper, Set<Sequence> availableWinSequences) {
        this.takenPositionsWrapper = takenPositionsWrapper;
        this.playerOWinSequences = availableWinSequences;
        this.playerXWinSequences = availableWinSequences;
        this.checker = new SequencesChecker(takenPositionsWrapper);
    }

    public boolean checkWinCondition(Sign sign, int lastMove) {
        Set<Sequence> matchingSequences;
        if(sign.equals(Sign.O)) {
            playerXWinSequences = checker.removeImpossibleSequences(playerXWinSequences, lastMove);
            matchingSequences = checker.findMatchingSequences(playerOWinSequences, lastMove);
        } else {
            playerOWinSequences = checker.removeImpossibleSequences(playerOWinSequences, lastMove);
            matchingSequences = checker.findMatchingSequences(playerXWinSequences, lastMove);
        }
        return checker.checkMatchingSequences(matchingSequences, sign);
    }

}