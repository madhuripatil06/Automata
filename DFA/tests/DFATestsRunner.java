import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.io.IOException;
import java.util.Arrays;

@RunWith(Parameterized.class)
public class DFATestsRunner {
    private final Machine machine;
    private final Object[] passing_cases;
    private final Object[] failing_cases;
    public DFATestsRunner(Result result) {
        this.machine = result.machine;
        this.passing_cases = result.passingCases;
        this.failing_cases = result.failingCases;
    }
    @Test
    public void dfaTestsRunner() {
        for (Object passing_case : this.passing_cases) {
            Assert.assertTrue(this.machine.run((String) passing_case));
        }
        for (Object failing_case : this.failing_cases) {
            Assert.assertFalse(this.machine.run((String) failing_case));
        }
    }
    @Parameterized.Parameters
    public static Iterable data() throws IOException, ParseException {
        return Arrays.asList(new MyJSONFileReader("").test());
    };
}

