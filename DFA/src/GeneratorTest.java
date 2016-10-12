import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GeneratorTest {
    @Test
    public void DFAMachineShouldPassForAll1sAndFailIfThereIsAny0(){
        HashMap<String, Map<String, String>>transitiontable = new HashMap<>();
        transitiontable.put("Q1", new HashMap(){{put("0","Q2"); put("1","Q1");}});
        transitiontable.put("Q2", new HashMap(){{put("0","Q2"); put("1","Q2");}});
        String[] alphabets = new String[2];
        alphabets[0] = "1";
        alphabets[1] = "0";

        String[] states = new String[2];
        states[0] = "Q1";
        states[1] = "Q2";

        String[] finalState = new String[1];
        finalState[0] = "Q1";

        String[] initialState = new String[1];
        initialState[0] = "Q1";

        InPutValue inputValue = new InPutValue(alphabets, states, transitiontable, finalState, initialState);
        Generator generator = new Generator(inputValue);
        assertTrue(generator.run("1111111"));
        System.out.println(generator.run("1101111"));
//        assertFalse(generator.run("1101111"));

    }

}