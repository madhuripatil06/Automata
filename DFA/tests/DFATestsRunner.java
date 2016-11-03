import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

@RunWith(Parameterized.class)
public class DFATestsRunner {
    private final DFA DFA;
    private final Object[] passing_cases;
    private final Object[] failing_cases;
    public DFATestsRunner(HashMap result) {
        this.DFA = (DFA) result.get("DFA");
        this.passing_cases = (Object[]) result.get("passingCases");
        this.failing_cases = (Object[]) result.get("failingCases");
    }
    @Test
    public void test() {
        for (Object passing_case : this.passing_cases) {
            Assert.assertTrue(this.DFA.run((String) passing_case));
        }
        for (Object failing_case : this.failing_cases) {
            Assert.assertFalse(this.DFA.run((String) failing_case));
        }
    }
    @Parameterized.Parameters
    public static Iterable data() throws IOException, ParseException {
        System.out.println(new MachineGenerator().generate("examples.json"));
        return Arrays.asList(new MachineGenerator().generate("examples.json"));
    };
}

