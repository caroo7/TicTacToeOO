package arbiter;

import board.Sign;

public class ArbiterBuilder {

    Arbiter build3x3() {
        SequencesInitializer initializer = new SequenceInitializer3x3();
        return new Arbiter(initializer.createAllWinSequences(), Sign.X);
    }

}
