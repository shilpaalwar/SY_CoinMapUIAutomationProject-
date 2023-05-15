package stepdefs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageOperations.HomePageOperations;
import utility.WebDriverFactory;

public class CoinMap_StepDef {
	WebDriver driver;
	static List<Map<String, String>> gridNonFilterRowMapArray;
	static List<Map<String, String>> gridFilterRowMapArray;
	static HashMap<String, Integer> gridHeaderColumns = null;
	
	public CoinMap_StepDef()
	{
		driver=WebDriverFactory.getDriver();
		
	}
	
	@Given("User Open Coin Market Cap Application")
	public void User_Open_CoinMarket_Cap_Application()
	{
		PageFactory.initElements(driver, HomePageOperations.class);
		HomePageOperations.navigate_URL();
	}
	
	@And("User is on homepage")
	public void User_is_on_homepage() throws InterruptedException
	{
		PageFactory.initElements(driver, HomePageOperations.class);
		HomePageOperations.verifyHomePage();
	}
	
	@Given("User filter Rows by {int}")
	public void user_filter_rows(int row) throws InterruptedException
	{
		PageFactory.initElements(driver, HomePageOperations.class);
		HomePageOperations.filterRow();
		
	}
	
	@Then("Filter by Algoritham {string}")
	public void Filter_by_Algoritham(String algoritham) throws InterruptedException
	{
		PageFactory.initElements(driver, HomePageOperations.class);
		HomePageOperations.filterAlgoritham(algoritham);
	}
	
	@When("Click on Add Filter")
	public void Click_on_Add_Filter() throws InterruptedException
	{
		PageFactory.initElements(driver, HomePageOperations.class);
		HomePageOperations.clickAddFilter();
	}
	
	@Then("Select Cryptocurrency {string}")
	public void Select_Cryptocurrency(String crypto) throws InterruptedException
	{
		PageFactory.initElements(driver, HomePageOperations.class);
		HomePageOperations.selectCryptoCurrency(crypto);
	}
	
	@And("Toggle {string}")
	public void user_Toggle(String option) throws InterruptedException
	{
		PageFactory.initElements(driver, HomePageOperations.class);
		HomePageOperations.toggleOptions(option);
	}
	
	@And("select price and set minimum value to {string} and maximum to {string}")
	public void select_price_and_set_minimum_Maximum(String min, String max) throws InterruptedException
	{
		PageFactory.initElements(driver, HomePageOperations.class);
		HomePageOperations.selectPrice(min,max);
	}
	
	@And("Click on Apply Filter")
	public void Click_on_Apply_Filter() throws InterruptedException
	{
		PageFactory.initElements(driver, HomePageOperations.class);
		HomePageOperations.applyFilter();
	}
	
	@And("Click on Show results")
	public void click_on_Show_results() throws InterruptedException
	{
		PageFactory.initElements(driver, HomePageOperations.class);
		HomePageOperations.showResults();
	}
	
	@And("Verify results displayed")
	public void Verify_results_displayed() throws InterruptedException
	{
		PageFactory.initElements(driver, HomePageOperations.class);
		gridHeaderColumns = HomePageOperations.readTableHeaderRow();
		gridFilterRowMapArray = HomePageOperations.readTableFilteredRow();
	}
	
}
