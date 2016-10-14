import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GeneratorTest {
    @Test
    public void DFAMachineShouldPassForAll1sAndFailIfThereIsAny0(){
        String[] alphabets = {"1", "0"};
        String[] states = {"Q1", "Q2"};
        String[] finalState = {"Q1"};
        String initialState = "Q1";
        String[] transitiontable = {"Q1,0,Q2", "Q1,1,Q1", "Q2,0,Q2", "Q2,1,Q2"};
        Generator generator = new Generator(alphabets, states, transitiontable, finalState, initialState);
        assertTrue(generator.run("1111111"));
        assertFalse(generator.run("1101111"));
        assertFalse(generator.run("110a111"));
    }

}