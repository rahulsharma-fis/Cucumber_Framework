package steps;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import shared.common.Login;
import utils.SeleniumDriver;
import utils.SeleniumHelper;

public class StepDefinitions {
	SeleniumHelper helper=new SeleniumHelper();

	
	@Given("^I navigate to the  Home Page \"([^\"]*)\" of Amazon Website$")
	public void i_navigate_to_the_Home_Page_of_Amazon_Website(String url)  {
	   SeleniumDriver.openPage(url);
	}
	
	@When("^I move to Amazon Basics$")
	public void i_move_to_Amazon_Basics() throws Exception {
		WebDriver driver=SeleniumDriver.getDriver();
		Login login=new Login();
		Properties prop=helper.loadProperties();
		login.loginWithUser(driver,prop.getProperty("test.username"), prop.getProperty("test.password"));
		WebElement ele=driver.findElement((By.xpath("//a[text()=\"Amazon Basics\"]")));
		if(helper.isElementPresent(ele))
		{
			ele.click();
		}
		else
		{
			System.out.print("element is not found");
			
		}
			
	}

	@When("^I Search for product \"([^\"]*)\" in search page$")
	public void i_moved_to_todays_deals(String item) {
		WebDriver driver=SeleniumDriver.getDriver();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(item);
	}
	
	@Then("^I should see list of items$")
	public void i_should_see_list_of_items() {
		System.out.print("item are displayed");
	}	

}

