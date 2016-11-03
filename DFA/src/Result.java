public class Result {
    public final DFA DFA;
    public final Object[] passingCases;
    public final Object[] failingCases;

    public Result(DFA DFA, Object[] passingCases, Object[] failingCases) {
        this.DFA = DFA;
        this.passingCases = passingCases;
        this.failingCases = failingCases;
    }
}
