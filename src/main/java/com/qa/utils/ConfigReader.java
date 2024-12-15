package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    Properties prop;
    public Properties init_prop()
    {
        prop= new Properties();
        try {
            FileInputStream fis = new FileInputStream("./src/test/resources/Config/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return  prop;
    }
}
