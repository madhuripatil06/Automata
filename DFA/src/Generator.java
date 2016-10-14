import java.util.Arrays;

public class Generator {
    private final String[] alphabets;
    private final String[] states;
    private final String[] finalstate;
    private final String initalstate;
    private final Transitions transitions;

    public Generator(String[] alphabets, String [] states, String[] transitions, String [] finalstate, String initalstate) {
        this.alphabets = alphabets;
        this.states = states;
        this.transitions = new Transitions(transitions);
        this.finalstate = finalstate;
        this.initalstate = initalstate;
    }

    public Boolean run(String input){
        String[] inputs = input.split("");
        String currentState = this.initalstate;
        for (String alphabet : inputs) {
            if(Arrays.asList(this.alphabets).indexOf(alphabet) == -1)
                return false;
            currentState = this.transitions.tranitionFor(currentState, alphabet);
        }
        return isStringPassed(currentState);
    }

    private Boolean isStringPassed(String currentState) {
        for (String finalState : this.finalstate) {
            if(finalState.equals(currentState))
                return true;
        }
        return false;
    }
}
