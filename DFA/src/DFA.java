import java.util.Arrays;

public class DFA implements Machine {
    private final String[] alphabets;
    private final State[] states;
    private final Transitions transitions;
    private final State[] finalstate;
    private final State initalstate;

    public DFA(String[] alphabets, State[] states, Transitions transitions, State[] finalstate, State initalstate) {
        this.alphabets = alphabets;
        this.states = states;
        this.transitions = transitions;
        this.finalstate = finalstate;
        this.initalstate = initalstate;
    }

    public Boolean run(String input){
        String[] inputs = input.split("");
        State currentState = this.initalstate;
        for (String alphabet : inputs) {
            if(isAlphabetValid(alphabet))
                return false;
            currentState = this.transitions.tranitionFor(currentState, alphabet);
        }
        return isStringPassed(currentState);
    }

    private boolean isAlphabetValid(String alphabet) {
        return Arrays.asList(this.alphabets).indexOf(alphabet) == -1;
    }

    private Boolean isStringPassed(State currentState) {
        for (State finalState : this.finalstate) {
            if(finalState.equals(currentState))
                return true;
        }
        return false;
    }
}
