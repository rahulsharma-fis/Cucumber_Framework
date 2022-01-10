package utils;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SeleniumDriver {

    private static SeleniumDriver seleniumDriver;
 
    //initialize webdriver
    private static WebDriver driver;
    
    //initialize timeouts
    private static WebDriverWait waitDriver;
    public final static int TIMEOUT = 30;
    public final static int PAGE_LOAD_TIMEOUT = 50;

    //Constructor to Setup the driver parameters
    private  SeleniumDriver() {
       
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
        driver.manage().window().maximize();

        waitDriver = new WebDriverWait(driver, TIMEOUT);
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        String window=driver.getWindowHandle();
        System.out.println("Window ->"+window);
       
    }

    //wrapper function to open the given url
    public static void openPage(String url) {
    	System.out.println(url);
    	System.out.println(driver);
        driver.get(url);
    }

    //returns the initialized driver
    public static WebDriver getDriver() {
        return driver;
    }
    
    //Initializes the driver if not already initialized
    public static void setUpDriver() {
       if (seleniumDriver == null)
            seleniumDriver = new SeleniumDriver();
      
    }

    //Method to Close and quit the driver at the end of execution
    public static void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
        seleniumDriver = null;
    }
    
    public static void waitForPageToLoad()
    {
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
