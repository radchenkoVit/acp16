package store.utils;

import store.exceptions.GetPropertyException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyReader {
    private static final String PROPERTIES_PATHS = Paths.get(
            "RadchenkoVitalii", "src", "resources", "application.properties").toString();
    private static Properties properties = new Properties();

    public static String readProperty(String propertyName) {
        try ( InputStream inputStream = new FileInputStream(PROPERTIES_PATHS) ){
            properties.load(inputStream);
            return properties.getProperty(propertyName);
        } catch (IOException e) {
            throw new GetPropertyException(e.getMessage());
        }
    }
}
