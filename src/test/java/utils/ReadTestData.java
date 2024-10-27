package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadTestData {
    Properties pro;
    private final String filePath= "testData.properties";

    // Constructor
    public ReadTestData()
    {
        // Creating File object
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            pro = new Properties();
            try {
                pro.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + filePath);
        }
    }
    // Methods to read data from config.properties


    public String setApplicationURL() { // ok - add new url in config.properties
        String url=pro.getProperty("baseUrl");
        return url;
    }

    public String setBrowser() { // ok - add new url in config.properties
        String browser =pro.getProperty("browser");
        return browser;
    }

    public String setValidEmail() {
        String validEmail =pro.getProperty("validEmail");
        return validEmail;
    }

    public String setInvalidEmail() {
        String invalidEmail =pro.getProperty("invalidEmail");
        return invalidEmail;
    }

    public String setValidPassword() { // ok - add new url in config.properties
        String validPassword =pro.getProperty("validPassword");
        return validPassword;
    }

    public String setInvalidPassword() { // ok - add new url in config.properties
        String invalidPassword =pro.getProperty("invalidPassword");
        return invalidPassword;
    }

}
