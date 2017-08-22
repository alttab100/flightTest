package userActions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActions {
	
	int listSize;
	WebDriver driver;
	
	public ElementActions(WebDriver driver){
		this.driver = driver;
	}
	
	public void clickElement(WebElement element) {
		element.click();
	}

	public void clickListElement(WebDriver driver, List<WebElement> listElements, int position) {
		waitForListElements(driver, listElements);
		listElements.get(position-1).click();
	}
	
	public void enterText(WebElement element, String testData) {
		element.sendKeys(testData);
	}

	public void selectDropDown(WebElement element, String testData) {
		Select select = new Select(element);
		select.selectByVisibleText(testData);
	}
	
	public String getTextFromListElements(WebDriver driver, List<WebElement> listElements, int position) {
		waitForListElements(driver, listElements);
		return listElements.get(position-1).getText();		
	}
	
	public List<WebElement> waitForListElements(WebDriver driver, List<WebElement> listElements){
		try{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		listElements = wait.until(ExpectedConditions.visibilityOfAllElements(listElements));
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
}

