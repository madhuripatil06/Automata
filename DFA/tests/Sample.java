import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Sample {
    @Test
    public void DFAMachineShouldPassForAll1sAndFailIfThereIsAny0() throws IOException, ParseException {
//        MyJSONParser jsonParser = new MyJSONParser("./examples.json");
//        jsonParser.generate();
        MyJSONFileReader xyz = new MyJSONFileReader("xyz");
        xyz.test();
    }
}