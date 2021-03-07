package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    // In this class we will implement the repeated steps of reading
    // from configuration.properties file

    // create one utility method that is reading from the configuration.properties file

    //1) Create an object of Properties
    private static Properties properties = new Properties();

    static {
        //2) Get the path and open the file
        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            //3) Load the opened file
            properties.load(file);

            // closing the file
            file.close();// if we don't close it it still works, but garbageCollection

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //4) use the object to read from the  configuration.properties file
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }
}
