package testCases;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.FlightFinder;
import pageObjects.HomePage;
import pageObjects.SelectFlight;
import userActions.ElementActions;
import utility.Constants;
import utility.ExcelUtils;
import environmentSetup.TestBaseSetup;

public class BookTicket extends TestBaseSetup {
	
	private WebDriver driver;
	ElementActions action = new ElementActions(driver);
		
	  @BeforeClass
	  public void setUp() throws Exception {
		  ExcelUtils.setExcelFile(Constants.TESTDATA_PATH+Constants.TESTDATA_FILENAME, Constants.TESTDATA_SHEETNAME);
		  driver = getDriver();
	  }

	  @Test (priority = 0)
  public void signInHomePage () throws Exception {
	  
	  HomePage homePage = new HomePage(driver);
	  
	  action.clickElement(homePage.linkFlights);
	  homePage.txtUserName.sendKeys(ExcelUtils.getCellData(0,0));
	  homePage.txtPassword.sendKeys(ExcelUtils.getCellData(0,0));
	  action.clickElement(homePage.btnSignIn);
  }

	  @Test (priority = 1)

  public void fillFlightFinderPage () throws Exception {
	  
	  FlightFinder flightFinder = new FlightFinder(driver);
	  
	  action.clickElement(flightFinder.radioOneWay);
	  action.selectDropDown(flightFinder.selectPassengers, "2");
	  action.selectDropDown(flightFinder.selectDepartFrom, "London");
	  action.selectDropDown(flightFinder.selectDepartMonth, "November");
	  action.selectDropDown(flightFinder.selectDepartDay, "15");
	  action.selectDropDown(flightFinder.selectArriveTo, "Paris");
	  action.selectDropDown(flightFinder.selectArriveMonth, "November");
	  action.selectDropDown(flightFinder.selectArriveDay, "20"); 
	  action.clickElement(flightFinder.radioServiceClass);
	  action.clickElement(flightFinder.btnFindFlights);
  }
	  
	  @Test (priority = 2)
  public void selectFlight () throws Exception {
	  
	  SelectFlight selectFlight = new SelectFlight(driver);
	  int departFlightPosition = 2;
	  int returnFlightPosition = 3;
	  action.clickListElement(driver, selectFlight.radioOutFlight, departFlightPosition);
	  selectFlight.getFlightDetails(departFlightPosition);
	  selectFlight.printFlightDetails();
	  action.clickListElement(driver, selectFlight.radioInFlight, returnFlightPosition);
	  selectFlight.getFlightDetails(returnFlightPosition+4);
	  selectFlight.printFlightDetails(); 
	  action.clickElement(selectFlight.btnReserveFlights);
	  }
	  
	  @Test (priority = 3)
  public void takeScreenshot () throws IOException {
          File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
          FileUtils.copyFile(scrFile, new File("D:\\screenshots\\NewTours.jpeg"));
  }
	  @AfterClass
		public void quitDriver() {
			driver.quit();
		}
}
