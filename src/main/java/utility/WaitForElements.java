package utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElements {
	
	WebDriverWait wait;
	public WaitForElements(WebDriver driver, int i)
	{
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	
	public void waitforElementToBeVisible(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
