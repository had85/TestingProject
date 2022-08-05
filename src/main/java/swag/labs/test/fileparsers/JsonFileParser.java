package swag.labs.test.fileparsers;

import java.util.Collection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

public class JsonFileParser {
	
	private final static ObjectMapper objMapper = new ObjectMapper();

	public static <T> T readFromJsonFileAsSingleObject(String filePath, Class<T> elementClass){
		
		try {
			return objMapper.readValue(JsonFileParser.class.getResourceAsStream(filePath), elementClass);
		} catch (Exception e) {
			throw new RuntimeException("Greska prilikom parsiranja fajla: " + filePath);
		}
	}
	
	public static <T> T readFromJsonFileAsCollection(String filePath,  Class<?> elementClass){
		
		CollectionType javaType = objMapper.getTypeFactory()
			      .constructCollectionType(Collection.class, elementClass);
		try {
			return objMapper.readValue(JsonFileParser.class.getResourceAsStream(filePath), javaType);
		} catch (Exception e) {
			throw new RuntimeException("Greska prilikom parsiranja fajla: " + filePath);
		}
	}
}