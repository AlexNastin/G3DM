package com.global3Dmod.ÇDmodels.property;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class PropertyManagerG3DM {

	private static Logger LOGGER = Logger.getLogger(PropertyManagerG3DM.class);

	private final String PATH = "propertiesG3DM.properties";
	private final String PREFIX = this.getClass().getResource("/").getPath();

	private Properties properties = new Properties();
	private BufferedReader reader = null;
	private File file = new File(PREFIX + PATH);

	public PropertyManagerG3DM() {
		try {
			reader = new BufferedReader(new FileReader(file));
			properties.load(reader);
		} catch (FileNotFoundException e) {
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.error(e);
		}
	}

	public String getValue(String key) {
		return properties.getProperty(key);
	}

}