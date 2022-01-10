package utils;


import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class SeleniumHelper {
	

	//wrapper function to check whether an element is present on DOM 
    public static boolean isElementPresent(WebElement webElement) {
        try {
            boolean isPresent = webElement.isDisplayed();
            return isPresent;
        } catch (NoSuchElementException e) {
            return false;
        }      
    }
    
    //Loading Configuration Values from properties file
	public Properties loadProperties() throws Exception
	{
		String userDir=System.getProperty("user.dir");
		FileInputStream input=new FileInputStream(userDir+"/src/test/resources/config.properties");
		Properties prop=new Properties();
		prop.load(input);
		return prop;
	}
}
