package jsonFilesParser;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONManagement {
    private static JSONObject instance;

    public static String readProperty (String property) throws IOException {
        if (instance == null) {
            instance = getJsonFile();
        }

        return (String) instance.get(property);
    }

    private static JSONObject getJsonFile() throws IOException {

        String file = "JSON/LoginData";
        String json = readFileAsString(file);
        Object obj = JSONValue.parse(json);

        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject;
    }

    private static String readFileAsString(String file) throws IOException {

        return new String(Files.readAllBytes(Paths.get(file)));
    }
}

