package com.pratik.framework.utilities;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {
	
	private static Properties properties;
	
	public static void loadProperties() {
		
		properties = new Properties();
		
		try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")){
			
			if(input == null) {throw new RuntimeException("config.properties file was not found in scr/main/resources");}
			
			properties.load(input);
			
		}catch(IOException e) {
			throw new RuntimeException("Failed to load config.properties",e);
		}
	}

	public static String getProperty(String key) {

	    String value = System.getProperty(key);

	    if (value != null && !value.isEmpty()) {
	        return value;
	    }

	    return properties.getProperty(key);
	}
}
