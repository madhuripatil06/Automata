public class Generator {
    private InPutValue inputValue;

    public Generator(InPutValue inputValue) {
        this.inputValue = inputValue;
    }

    public Boolean run(String input){
        String[] inputs = input.split("");
        String currentState = inputValue.initalstate[0];
        for (String alphabet : inputs) {
            currentState = inputValue.transitions.get(currentState).get(alphabet);
        }
        for (String finalState : inputValue.finalstate) {
            if(finalState == currentState)
                return true;
        }
        return false;
    }
}
