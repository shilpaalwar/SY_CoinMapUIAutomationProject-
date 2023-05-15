package stepdefs;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utility.WebDriverFactory;

public class Hooks {
	static WebDriver driver;
@Before
public static void setup()
{
	if(WebDriverFactory.getDriver()==null) {
		System.out.println("Test");
		driver = WebDriverFactory.setDriver();
	}

}

@After
public static void tearDown()
{
	//driver.quit();
}
}