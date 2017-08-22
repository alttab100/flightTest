
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
		
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy (xpath = "//*[contains(text(), 'Flights')]")
	public WebElement linkFlights;

	@FindBy (xpath = "//*[@name = 'userName']")
	public WebElement txtUserName;

	@FindBy (xpath = "//*[@name = 'password']")
	public WebElement txtPassword;

	@FindBy (xpath = "//*[@name = 'login']")
	public WebElement btnSignIn;
}
