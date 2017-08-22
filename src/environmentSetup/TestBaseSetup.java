package environmentSetup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import utility.Constants;

public class TestBaseSetup extends Constants{

	private WebDriver driver;
	
	@BeforeClass
	public void initializeTestBaseSetup() {
		try {
			setDriver("chrome" , Constants.URL);

		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}
	
	
	
	private void setDriver(String browserType, String appURL) {
		switch (browserType) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH	+ "chromedriver.exe");
			driver = new ChromeDriver();
			launchURL(appURL);
			break;
		case "firefox":
			driver = new FirefoxDriver();
			launchURL(appURL);
			break;
		default:
			System.out.println("Browser : " + browserType
					+ " is invalid, Launching Firefox as browser of choice..");
			driver = new FirefoxDriver();
			launchURL(appURL);
		}
	}

	private void launchURL(String appURL) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
	}
	
	public WebDriver getDriver() {
		return driver;
	}

}