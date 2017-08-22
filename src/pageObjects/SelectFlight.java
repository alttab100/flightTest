package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import userActions.ElementActions;

public class SelectFlight extends ElementActions{
	
	WebDriver driver;
	String flightDetails[] = new String[3];

	public SelectFlight(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (xpath = "(//*[@name='outFlight'])")
	public List<WebElement> radioOutFlight;
			
	@FindBy (xpath = "(//*[@name='inFlight'])")
	public List<WebElement> radioInFlight;

	@FindBy (xpath = "(//*[@class='data_left'])")
	public List<WebElement> txtFlightName;
	
	@FindBy (xpath = "(//*[@class='data_center_mono'])")
	public List<WebElement> txtFlightDepartTime;
	
	@FindBy (xpath = "(//*[@class='data_center'])")
	public List<WebElement> txtFlightStops;
	
	@FindBy (xpath = "(//*[@name='reserveFlights'])")
	public WebElement btnReserveFlights;
	
	public void getFlightDetails(int position) {
		flightDetails[0] = getTextFromListElements(driver, txtFlightName, position);
		flightDetails[1] = getTextFromListElements(driver, txtFlightDepartTime, position);
		flightDetails[2] = getTextFromListElements(driver, txtFlightStops, position);
	}

	public void printFlightDetails () {
		for (int i = 0; i < flightDetails.length; i++)
			System.out.println(flightDetails[i]);
	}
}
