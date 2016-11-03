import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MachineTest {
    @Test
    public void DFAMachineShouldPassForAll1sAndFailIfThereIsAny0(){
        String[] alphabets = {"1", "0"};
        String[] states = {"Q1", "Q2"};
        String[] finalState = {"Q1"};
        String initialState = "Q1";
        String[] transitionTable = {"Q1,0,Q2", "Q1,1,Q1", "Q2,0,Q2", "Q2,1,Q2"};
        DFA dfa = new DFAGenerator(alphabets, states, transitionTable, finalState, initialState).generate();
        assertTrue(dfa.run("1111111"));
        assertFalse(dfa.run("1101111"));
        assertFalse(dfa.run("110a111"));
    }
}