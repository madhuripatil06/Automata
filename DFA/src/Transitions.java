import java.util.HashMap;
import java.util.Map;

public class Transitions {
    private HashMap<State, Map<String, State>> transitions = new HashMap<State, Map<String, State>>();
    public Transitions(Object[] rawTransitions) {
        this.createTransitions(rawTransitions);
    }

    private void createTransitions(Object[] rawTransitions) {
        for (Object transition : rawTransitions) {
            addTransition((String)transition);
        }
    }

    public Boolean addTransition(String transitionExp){
        String[] transitionParts = transitionExp.split(",");
        State from = new State(transitionParts[0]);
        String alphabet = transitionParts[1].trim();
        State to = new State(transitionParts[2]);
        if(transitionParts.length != 3)
            return false;
        if(transitions.get(from) != null)
            transitions.get(from).put(alphabet, to);
        else{
            transitions.put(from, transition(to, alphabet));
        }
        return true;
    }

    private HashMap transition(final State to, final String alphabet) {
        return new HashMap(){{put(alphabet, to);}};
    }

    public State tranitionFor(State currentState, String alphabet) {
        return this.transitions.get(currentState).get(alphabet);
    }

}
