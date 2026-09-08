package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static ConfigReader instance;
    private static Properties config;

    private ConfigReader() {
        try (InputStream input = getClass()
                .getClassLoader()
                .getResourceAsStream("config.properties")) {
            config = new Properties();
            config.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Помилка під час читання конфігурації: ", e);
        }
    }


   public static ConfigReader getInstance() {
        if (instance == null) {
            instance = new ConfigReader();
        }
        return instance;
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