public class DFAGenerator {
    private final String[] alphabets;
    private final String[] states;
    private final Object[] transitions;
    private final String[] finalstate;
    private final String initalstate;

    public DFAGenerator(String[] alphabets, String [] states, Object[] transitions, String [] finalstate, String initalstate) {
        this.alphabets = alphabets;
        this.states = states;
        this.transitions = transitions;
        this.finalstate = finalstate;
        this.initalstate = initalstate;
    }

    public Machine generate(){
        return new Machine(this.alphabets, createStates(this.states), new Transitions(this.transitions), createStates(finalstate),new State(this.initalstate));
    }

    private State[] createStates(String[] input) {
        State[] states = new State[input.length];
        for(int i = 0 ; i < states.length ; i++){
            states[i] = new State(input[i]);
        }
        return states;
    }
}
