import org.junit.Assert;
import org.junit.Test;

public class DFATestsRunner {

    @Test
    public void run() throws Exception {
        MyJSONFileReader myJsonFileReader = new MyJSONFileReader("example.json");
        Result[] tests = myJsonFileReader.test();
        for (Result test : tests) {
            for (Object passingCase : test.passingCases) {
                Assert.assertTrue(test.machine.run((String)passingCase));
            }
            for (Object failingCase : test.failingCases) {
                Assert.assertFalse(test.machine.run((String) failingCase));
            }
        }


    }
}
