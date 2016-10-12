import src.InPutValue;

import java.util.HashMap;

public class Generator {
    private InPutValue inputValue;

    public Generator(InPutValue inputValue) {
        this.inputValue = inputValue;
    }

    public Boolean run(String input){
        String[] inputs = input.split("");
        String currentState = inputValue.initalstate[0];
        for (String alphabet : inputs) {
            System.out.println(alphabet+"  ====== "+currentState);
            currentState = inputValue.transitions.get(currentState).get(alphabet);
        }
        return currentState == inputValue.finalstate[0];
    }
}
