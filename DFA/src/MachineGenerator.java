import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MachineGenerator {
    public HashMap[] generate(String fileName) throws IOException, ParseException {
        JSONArray parse = new JSONFileReader(fileName).parse();
        HashMap<String, Object>[] result = new HashMap[parse.size()];
        for(int i = 0 ; i < parse.size() ; i++){
            JSONObject jsonObject = (JSONObject) parse.get(i);
            Machine machine = generateMachine((JSONObject) jsonObject.get("tuple"), (String) jsonObject.get("type"));
            Object[] passCases = ((JSONArray) jsonObject.get("pass-cases")).toArray();
            Object[] failCases = ((JSONArray) jsonObject.get("fail-cases")).toArray();
            result[i] = new HashMap<>();
            result[i].put("passingCases", passCases);
            result[i].put("failingCases", failCases);
            result[i].put("machine", machine);
        }
        return result;
    }

    private Machine generateMachine(JSONObject tuple, String type) {
        String[] alphabetSets = createSet((JSONArray) tuple.get("alphabets"));
        String[] states = createSet((JSONArray) tuple.get("states"));
        String[] finalStates = createSet((JSONArray) tuple.get("final-states"));
        String initialState = (String) tuple.get("start-state");
        Object [] transitions = createTransitions((JSONObject) tuple.get("delta"));
        if(type.equals("dfa"))
            return new DFAGenerator(alphabetSets, states, transitions, finalStates, initialState).generate();
        return null;
    }

    private Object[] createTransitions(JSONObject delta) {
        ArrayList<String> transitions = new ArrayList<>();
        Object[] keys = delta.keySet().toArray();
        for(int j = 0 ; j < keys.length ; j++){
            JSONObject jsonObject = (JSONObject) delta.get(keys[j]);
            Object[] finalSetOfSets = jsonObject.keySet().toArray();
            for(int a = 0 ; a < finalSetOfSets.length ;a++){
                transitions.add(keys[j] + ", " + finalSetOfSets[a] + ", " + jsonObject.get(finalSetOfSets[a]));
            }
        }
        return transitions.toArray();
    }

    private String[] createSet(JSONArray alphabets) {
        String [] alphbetSet = new String[alphabets.size()];
        for(int i = 0 ; i < alphabets.size() ; i++){
            alphbetSet[i] = (String) alphabets.get(i);
        };
        return alphbetSet;
    }
}
