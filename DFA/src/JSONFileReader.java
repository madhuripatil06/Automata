import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;

public class JSONFileReader {
    private String fileName;

    public JSONFileReader(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath(){
        File file = new File(this.fileName);
        return new File(this.fileName).getAbsolutePath();
    }

    public JSONArray parse() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Object data = jsonParser.parse(new java.io.FileReader(getFilePath()));
        return (JSONArray) new JSONParser().parse((String) data);
    }
}
