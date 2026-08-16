package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    public static Properties config = new Properties();

    public static String getPropertyFromConfig(String key) {
        try (
                InputStream input = new FileInputStream("src/test/resources/config.properties")) {
            config.load(input);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return config.getProperty(key);
    }

}
