package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationProperties {

    private final Properties properties;

    ApplicationProperties() {

        properties = new Properties();
        try {
            FileReader fileReader = new FileReader("src/main/java/res/config.properties");
            properties.load(fileReader);
        } catch (IOException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public Properties getAppProperties(){
        return  properties;
    }
}