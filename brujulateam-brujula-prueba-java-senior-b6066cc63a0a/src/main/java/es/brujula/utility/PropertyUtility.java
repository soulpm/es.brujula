package es.brujula.utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtility {

	private Properties prop = null;
	private String _PROPERTY_NAME = "ValuesProperties.properties";
	
	public PropertyUtility(){
		if(prop == null)
		{
			prop = new Properties();
			try {
				InputStream inputStream =  getClass().getClassLoader().getResourceAsStream(_PROPERTY_NAME);
				if(inputStream!=null) {
					prop.load(inputStream);
				}
			}
			catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	
	public String getValueProperty(String key) {
		return prop.getProperty(key);
	}
	
}
