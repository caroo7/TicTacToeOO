package arbiter;

import java.util.HashSet;
import java.util.Set;

public class SequencesInitializer3x3 implements SequencesInitializer {

    @Override
    public Set<Sequence> createAllWinSequences() {
        Set<Sequence> sequences = new HashSet<>();

        //horizontal numberSequence
        sequences.add(new Sequence(0, 1, 2));
        sequences.add(new Sequence(3, 4, 5));
        sequences.add(new Sequence(6, 7, 8));

        //vertical numberSequence
        sequences.add(new Sequence(0, 3, 6));
        sequences.add(new Sequence(1, 4, 7));
        sequences.add(new Sequence(2, 5, 8));

        //firstDimensionSequence
        sequences.add(new Sequence(0, 4, 8));

        //secondDimensionSequence
        sequences.add(new Sequence(2, 4, 6));

        return sequences;
    }
}