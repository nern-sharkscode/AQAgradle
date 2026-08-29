package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    public static Properties config = new Properties();

    static {
        // Змінено назву файлу на config.properties, як у твоєму проєкті
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Не знайдено файл config.properties у папці resources!");
            }
            config.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Помилка під час читання конфігурації: ", e);
        }
    }

    public static String getPropertyFromConfig(String key) {
        return config.getProperty(key);
    }


    public static String getBaseUrl() {
        return config.getProperty("baseUrl");
    }

    public static String getEmailForUserSuccessLogin() {
        return config.getProperty("emailForUserSuccessLogin");
    }

    public static String getPasswordForUserSuccessLogin() {
        return config.getProperty("passwordForUserSuccessLogin");
    }

    public static String getEmailForUserUnsuccessLogin() {
        return config.getProperty("emailForUserUnsuccessLogin");
    }

    public static String getPasswordForUserUnsuccessLogin() {
        return config.getProperty("passwordForUserUnsuccessLogin");
    }
}