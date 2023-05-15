package utility;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ObjectActions {
	static WebDriver driver;
	WebDriverWait wait;
	static WaitForElements waitforelements;
	
	public ObjectActions(WebDriver driver)
	{
		this.driver = driver;
		waitforelements = new WaitForElements(driver,10);
	}
	public void clickwithJavaScript(WebElement element)
	{
		try {
			waitforelements.waitforElementToBeVisible(element);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickwithSendKey(WebElement element)
	{
		waitforelements.waitforElementToBeVisible(element);
		element.click();
	}
	
	public void clickWebElement(List<WebElement> elements, String pattern)
	{
		try {
			Thread.sleep(2000);
			for(int i=0;i<elements.size();i++)
			{
				waitforelements.waitforElementToBeVisible(elements.get(i));
				if(elements.get(i).getText().contains(pattern))
				{
					elements.get(i).click();
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		};
		
	}
	

}
