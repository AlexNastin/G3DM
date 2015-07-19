package com.global3Dmod.ÇDmodels.property;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;



import org.springframework.stereotype.Component;


@Component
public class PropertyManagerG3DM{

	private final String PATH = "propertiesG3DM.properties";
	private final String PREFIX = this.getClass().getResource("/").getPath();

	private Properties properties = new Properties();
	private BufferedReader reader = null;
	private File file = new File(PREFIX + PATH);

	public PropertyManagerG3DM() {
		try {
			System.out.println(PREFIX + PATH);
			reader = new BufferedReader(new FileReader(file));
			properties.load(reader);
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException AAAAAA");
		} catch (IOException e) {
			System.out.println("IOException AAAAAA");
		}
	}

	public String getValue(String key) {
		return properties.getProperty(key);
	}

}