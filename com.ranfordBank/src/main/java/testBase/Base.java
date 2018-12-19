package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Base {
	
	//public static Properties propConfig, propOR;
	public static Properties propConfig;
	public static WebDriver driver;
	public static void loadORProperty()
	{
		File f = new File(".\\src\\main\\java\\Configuration\\OR.properties");
		try {
			//propOR = new Properties();
			FileReader fr = new FileReader(f);
			//propOR.load(fr);
			propConfig.load(fr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static By getElement(String key)
	{
		By loc = null;
		loadORProperty();
		//String value = propOR.getProperty(key);
		String value = propConfig.getProperty(key);
		String locType = value.split(":")[0];
		String locValue = value.split(":")[1];
		
		switch(locType)
		{
			case "id":
				loc = By.id(locValue);
				break;
			case "name":
				loc = By.name(locValue);
				break;
			case "className":
				loc = By.className(locValue);
				break;
			case "cssSelector":
				loc = By.cssSelector(locValue);
				break;
			case "partialLink":
				loc = By.partialLinkText(locValue);
				break;
			case "tagName":
				loc = By.tagName(locValue);
				break;
			case "xpath":
				loc = By.xpath(locValue);			
		}
		return loc;
	}
	
	public static void loadConfigProperty()
	{
		File f = new File(".\\src\\main\\java\\Configuration\\Config.properties");
		try {
			FileReader fr = new FileReader(f);
			propConfig = new Properties();
			propConfig.load(fr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static String getConfPropValue(String configKey)
	{
		loadConfigProperty();
		String configvalue = propConfig.getProperty(configKey);
		return configvalue; 	
	}
	
}
