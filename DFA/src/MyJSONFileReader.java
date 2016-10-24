import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class MyJSONFileReader {
    private String filePath;

    public MyJSONFileReader(String FilePath) {

        filePath = FilePath;
    }

    public Result[] test() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Object data = jsonParser.parse(new FileReader("/Users/madhurip/STEP/Automata/DFA/src/examples.json"));
        String data1 = (String) data;
        JSONArray parse = (JSONArray) new JSONParser().parse(data1);
        return parseJSON(parse);
    }

    private Result[] parseJSON(JSONArray parse) {
        Result[] results = new Result[parse.size()];
        for(int i = 0 ; i < parse.size() ; i++){
            JSONObject jsonObject = (JSONObject) parse.get(i);
            JSONObject tuple = (JSONObject) jsonObject.get("tuple");
            Machine machine = generateMachine(tuple);
            JSONArray passCases = (JSONArray) jsonObject.get("pass-cases");
            JSONArray failCases = (JSONArray) jsonObject.get("fail-cases");
            results[i] = new Result(machine, passCases.toArray(), failCases.toArray());
        }
        return results;
    }

    private Machine generateMachine(JSONObject tuple) {
        String[] alphabetSets = createSet((JSONArray) tuple.get("alphabets"));
        String[] states = createSet((JSONArray) tuple.get("states"));
        String[] finalStates = createSet((JSONArray) tuple.get("final-states"));
        String initialState = (String) tuple.get("start-state");
        Object [] transitions = createTransitions((JSONObject) tuple.get("delta"));
        return new DFAGenerator(alphabetSets, states, transitions, finalStates, initialState).generate();
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
