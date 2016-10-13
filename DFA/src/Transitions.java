import java.util.HashMap;
import java.util.Map;

public class Transitions {
    private HashMap<String, Map<String, String>> transitions = new HashMap<String, Map<String, String>>();

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
        if(transitionParts.length != 3)
            return false;
        if(transitions.get(transitionParts[0]) != null)
            transitions.get(transitionParts[0]).put(transitionParts[1], transitionParts[2]);
        else{
            HashMap transition = new HashMap() {{
                put(transitionParts[1], transitionParts[2]);
            }};
            transitions.put(transitionParts[0], transition);
        }
        return true;
    };

    public String tranitionFor(String currentState, String alphabet) {
        return this.transitions.get(currentState).get(alphabet);
    }

}
