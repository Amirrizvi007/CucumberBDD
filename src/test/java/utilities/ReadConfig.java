package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig 
{
	Properties properties;
	String path="Config.properties";
	
	public ReadConfig()
	{
		properties= new Properties();
		try {
			//to open config properties file input mode and load the file
			FileInputStream fis= new FileInputStream(path);
			properties.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String getBrowser()
	{
		String value=properties.getProperty("browser");
		if(value!=null)
		return value;
		else
			throw new RuntimeException("Url not specified in confg file.");
	}
}
