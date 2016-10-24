public class Result {
    public final Machine machine;
    public final Object[] passingCases;
    public final Object[] failingCases;

    public Result(Machine machine, Object[] passingCases, Object[] failingCases) {
        this.machine = machine;
        this.passingCases = passingCases;
        this.failingCases = failingCases;
    }
}
