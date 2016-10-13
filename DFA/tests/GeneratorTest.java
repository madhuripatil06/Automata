import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GeneratorTest {
    @Test
    public void DFAMachineShouldPassForAll1sAndFailIfThereIsAny0(){
        String[] alphabets = new String[2];
        alphabets[0] = "1";
        alphabets[1] = "0";

        String[] states = new String[2];
        states[0] = "Q1";
        states[1] = "Q2";

        String[] finalState = new String[1];
        finalState[0] = "Q1";

        String initialState = "Q1";

        String[] transitiontable = new String[4];
        transitiontable[0] = "Q1,0,Q2";
        transitiontable[1] = "Q1,1,Q1";
        transitiontable[2] = "Q2,0,Q2";
        transitiontable[3] = "Q2,1,Q2";

        Generator generator = new Generator(alphabets, states, transitiontable, finalState, initialState);
        assertTrue(generator.run("1111111"));
        assertFalse(generator.run("1101111"));
    }

}