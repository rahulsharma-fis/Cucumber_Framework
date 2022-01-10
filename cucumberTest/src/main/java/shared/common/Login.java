package shared.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumDriver;

public class Login {
	
	
	//Common Method For Login into the page , which takes driver ,username and password as parameter
	public void loginWithUser(WebDriver driver,String username,String password)
	{
		driver.findElement(By.xpath("//span[text()='Hello, Sign in']")).click();;
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		
	}
}
