package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightFinder {
	
	WebDriver driver;
	
	public FlightFinder(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
		
	}
	
	@FindBy (xpath = "//*[@value='oneway']")
	public WebElement radioOneWay;
	
	@FindBy (xpath = "//*[@name = 'passCount']")
	public WebElement selectPassengers;
	
	@FindBy (xpath = "//*[@name='fromPort']")
	public WebElement selectDepartFrom;

	@FindBy (xpath = "//*[@name='fromMonth']")
	public WebElement selectDepartMonth;
	
	@FindBy (xpath = "//*[@name='fromDay']")
	public WebElement selectDepartDay;

	@FindBy (xpath = "//*[@name='toPort']")
	public WebElement selectArriveTo;
	
	@FindBy (xpath = "//*[@name='toMonth']")
	public WebElement selectArriveMonth;
	
	@FindBy (xpath = "//*[@name='toDay']")
	public WebElement selectArriveDay;

	@FindBy (xpath = "//*[@value='Coach']")
	public WebElement radioServiceClass;
	
	@FindBy (xpath = "//*[@name='findFlights']")
	public WebElement btnFindFlights;
	
}
