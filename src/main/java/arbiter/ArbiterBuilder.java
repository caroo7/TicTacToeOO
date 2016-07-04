package arbiter;

public class ArbiterBuilder {

    public Arbiter build3x3(TakenPositionsWrapper takenPositions) {
        SequencesInitializer initializer = new SequencesInitializer3x3();
        return new Arbiter(takenPositions, initializer.createAllWinSequences());
    }

}