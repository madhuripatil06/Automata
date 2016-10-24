import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MyJSONParser {
    private String JSONFilePath;

    public MyJSONParser(String JSONFilePath) {

        this.JSONFilePath = JSONFilePath;
    }

    public DFAGenerator generate() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Object data = jsonParser.parse(new FileReader("/Users/madhurip/STEP/Automata/DFA/src/examples.json"));
        String data1 = (String) data;
        JSONArray parse = (JSONArray) new JSONParser().parse(data1);
        System.out.println("data "+ parse.get(0)+ "\n\n\n");
//        JSONObject jsonObject = (JSONObject) parse.get(i);
//        JSONObject tuple = (JSONObject) jsonObject.get("tuple");
        generateDFAs(parse);

        return new DFAGenerator(null, null, null, null, null);
    }

    private void generateDFAs(JSONArray parsedData) {
        for ( int i = 0 ; i < parsedData.size() ; i++){
            JSONObject jsonObject = (JSONObject) parsedData.get(i);
            JSONObject tuple = (JSONObject) jsonObject.get("tuple");
            String[] alphabetSets = createSet((JSONArray) tuple.get("alphabets"));
            String[] states = createSet((JSONArray) tuple.get("states"));
            String[] finalStates = createSet((JSONArray) tuple.get("final-states"));
            String initialState = (String) tuple.get("start-state");
//            System.out.println("delta "+ (JSONObject)tuple.get("delta"));
            createTransitionTable((JSONObject) tuple.get("delta"), alphabetSets.length*states.length);
        }

    }

    public Machine generateDFA(JSONObject parsedData){
        return null;
    }

    private String[] createTransitionTable(JSONObject delta, int size) {
        ArrayList<String> transitionTable = new ArrayList<>();
        for (int i = 0 ; i < delta.size(); i++){
            JSONArray jsonArray = (JSONArray) delta.get(i);
            Set keys = delta.keySet();
            System.out.println(keys.toArray()[0].getClass()+ "  " +keys.size());
            for(int k = 0 ; k < keys.size() ; k++){
                String[] objects = (String [])keys.toArray();
//                for(int j = 0 ; j < ;j ++){
//                    transitionTable.add(keys[i]);
//                }
            }
//            System.out.println(" out " + "  "+ delta.get(set.toArray()[0]));
            for(int j  = 0 ; j < jsonArray.size(); j ++){
//                transitionTable[i+j] = new String()
                System.out.println(jsonArray.get(j));
            }
        }
        return null;
    }
//
//    private State[] createStates(JSONArray states) {
//        State[] stateSet = new State[states.size()];
//        for(int i = 0 ; i < states.size(); i ++){
//            stateSet[i] = new State((String) states.get(i));
//        }
//        return stateSet;
//    }

    private String[] createSet(JSONArray alphabets) {
        String [] alphbetSet = new String[alphabets.size()];
        for(int i = 0 ; i < alphabets.size() ; i++){
            alphbetSet[i] = (String) alphabets.get(i);
        };
        return alphbetSet;

    }
}
