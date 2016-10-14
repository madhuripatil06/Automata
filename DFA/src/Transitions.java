import java.util.HashMap;
import java.util.Map;

public class Transitions {
    private HashMap<State, Map<String, State>> transitions = new HashMap<State, Map<String, State>>();

    public Transitions(String[] rawTransitions) {
        this.createTransitions(rawTransitions);
    }

    private void createTransitions(String[] rawTransitions) {
        for (String transition : rawTransitions) {
            addTransition(transition);
        }
    }

    private Boolean addTransition(String transitionExp){
        String[] transitionParts = transitionExp.split(",");
        State from = new State(transitionParts[0]);
        State to = new State(transitionParts[2]);
        if(transitionParts.length != 3)
            return false;
        if(transitions.get(from) != null)
            transitions.get(from).put(transitionParts[1], to);
        else{
            HashMap transition = new HashMap() {{
                put(transitionParts[1], to);
            }};
            transitions.put(from, transition);
        }
        return true;
    };

    public State tranitionFor(State currentState, String alphabet) {
        return this.transitions.get(currentState).get(alphabet);
    }

}
