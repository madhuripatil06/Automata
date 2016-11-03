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
    private final Object[] passing_cases;
    private final Object[] failing_cases;
    private final Machine machine;

    public DFATestsRunner(HashMap result) {
        this.machine = (Machine) result.get("machine");
        this.passing_cases = (Object[]) result.get("passingCases");
        this.failing_cases = (Object[]) result.get("failingCases");
    }
    @Test
    public void test() {
        for (Object passing_case : this.passing_cases) {
            Assert.assertTrue(this.machine.run((String) passing_case));
        }
        for (Object failing_case : this.failing_cases) {
            Assert.assertFalse(this.machine.run((String) failing_case));
        }
    }
    @Parameterized.Parameters
    public static Iterable data() throws IOException, ParseException {
        return Arrays.asList(new MachineGenerator().generate("examples.json"));
    };
}

