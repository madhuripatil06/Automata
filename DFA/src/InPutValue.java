import java.util.HashMap;
import java.util.Map;

public class InPutValue {
    public final String[] alphabets;
    public final String[] states;
    public final HashMap<String ,Map<String, String>> transitions;
    public final String[] finalstate;
    public final String[] initalstate;

    public InPutValue(String[] alphabets, String [] states, HashMap transitions, String [] finalstate, String [] initalstate) {
        this.alphabets = alphabets;
        this.states = states;
        this.transitions = transitions;
        this.finalstate = finalstate;
        this.initalstate = initalstate;
    }
}
