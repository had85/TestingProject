package swag.labs.test.fileparsers;

import java.io.IOException;
import java.util.Properties;

public class PropertyFileParser {

	public static String readPropety(String filePath, String propertyName) {
		Properties propertiesFile = new Properties();
		try {
			propertiesFile.load(PropertyFileParser.class.getResourceAsStream(filePath));
		} catch (IOException e) {
			throw new RuntimeException("Greska prilikom ucitavanja properties fajla: " + filePath);
		}
		
		return propertiesFile.getProperty(propertyName);
	}
}
