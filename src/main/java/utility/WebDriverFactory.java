package utility;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

	public static WebDriver setdriver=null;
	private static final String CHROME_DRIVER_WIN = BasePage.getProperty("CHROME_DRIVER_WIN");
	private WebDriverFactory() {
		
	}
	
	public static WebDriver setDriver()
	{
		String browser = BasePage.getProperty("BROWSER");
		
		switch(browser) {
		case "CHROME":
			setdriver = setChromeDriver();
			break;
		case "FIREFOX":
			setdriver = setFirefoxDriver();
			break;
		default:
			setdriver = setChromeDriver();
		}
		return setdriver;
	}
	
	
	private static WebDriver setChromeDriver()
	{
		//Log.info("Getting local chrome Driver");
		System.setProperty("webdriver.chrome.driver", (new File(CHROME_DRIVER_WIN)).getAbsolutePath());
		return new ChromeDriver();	
	}
	
	private static WebDriver setFirefoxDriver()
	{
		//Log.info("Getting local chrome Driver");
		System.setProperty("webdriver.chrome.driver", (new File(CHROME_DRIVER_WIN)).getAbsolutePath());
		return new ChromeDriver();	
	}
	
public static WebDriver getDriver() {
	return setdriver;
}

}

