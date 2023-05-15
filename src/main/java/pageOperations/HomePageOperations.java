package pageOperations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageLocators.HomePage;
import utility.BasePage;
import utility.ObjectActions;
import utility.WaitForElements;

public class HomePageOperations extends HomePage{
	private static WebDriver driver;
	static HomePage homepage;
	static ObjectActions objectactions;
	static WaitForElements waitforelements;
	static HashMap<String, Integer> gridHeaderColumns = null;
	static List<Map<String, String>> gridColumnsMapArray;
	static Logger log = Logger.getLogger(HomePageOperations.class);
	
	
	public HomePageOperations(WebDriver driver) {
		super(driver);
		homepage = new HomePage(driver);
		HomePageOperations.driver = driver;
		objectactions = new ObjectActions(driver);
		waitforelements = new WaitForElements(driver,10);
		gridColumnsMapArray = new ArrayList<Map<String, String>>();
	}
		
	public static void navigate_URL()
	{
		try {
			String url=BasePage.getProperty("applicationurl");
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			log.info("Driver URL : " + driver.getCurrentUrl());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void verifyHomePage()
	{
		try {
			homepage.getCookiesAccept().click();
			waitforelements.waitforElementToBeVisible(homepage.getTitle());
			if(homepage.getTitle().isDisplayed())
				log.info("Home Page Displayed");
			}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void filterRow() throws InterruptedException
	{
	try {
		objectactions.clickwithJavaScript(homepage.getRow());
		List<WebElement> elements = homepage.getRowButton();
		objectactions.clickWebElement(elements, "20");
		log.info("Number Of Rows Filtered");
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	public static void filterAlgoritham(String algo) throws InterruptedException
	{
	try {
		objectactions.clickwithJavaScript(homepage.getFilter());
		Thread.sleep(500);
		List<WebElement> elements = homepage.getAlgoritham();
		objectactions.clickWebElement(elements, "Algorithm");
		log.info("Algoritham Clicked");
		objectactions.clickwithJavaScript(homepage.getPoW());
		log.info("PoW Clicked");
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	public static void clickAddFilter()
	{
	try {
		objectactions.clickwithJavaScript(homepage.getAddFilterButton());
		log.info("ADD Filter Clicked");
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	public static void selectCryptoCurrency(String crypto)
	{
	try {
		List<WebElement> elements = homepage.getMoreFilter();
		objectactions.clickWebElement(elements, "All Cryptocurrencies");
		log.info("All Cryptocurrencies Clicked");
		
		elements = homepage.getCryptoOption();
		objectactions.clickWebElement(elements, crypto);
		Thread.sleep(500);
		log.info("Coin Cryptocurrencies Selected");
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	public static void toggleOptions(String option)
	{
	try {
		objectactions.clickwithSendKey(homepage.getMineable());
		log.info("Mineable Toggle ON");	
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	public static void selectPrice(String minPrice, String maxPrice)
	{
	try {
		List<WebElement> elements = homepage.getMoreFilter();
		objectactions.clickWebElement(elements, "Price");
		log.info("Price Button Clicked");	
		
		homepage.getMinPriceRange().sendKeys(minPrice);
		homepage.getMaxPriceRange().sendKeys(maxPrice);
		log.info("Price Filtered");
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	public static void applyFilter()
	{
	try {
		objectactions.clickwithSendKey(homepage.getApplyFilter());
		log.info("Apply Filter clicked");
		}
	catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	public static void showResults()
	{
	try {
		objectactions.clickwithSendKey(homepage.getShowResults());
		log.info("Show Results clicked");
		}
	catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	@SuppressWarnings("null")
	public static HashMap<String, Integer> readTableHeaderRow()
	{
		gridHeaderColumns = new HashMap<String, Integer>();
	try {
		List<WebElement> objHeaderColumns = homepage.gettableHeaderRow().findElements(By.xpath(".//th//p"));
		for(int i=0;i<objHeaderColumns.size();i++)
		{
			if(objHeaderColumns.get(i).getText().contains("#"))
			{
				gridHeaderColumns.put("Postion", i);
			}
			else if(objHeaderColumns.get(i).getText().contains("Name"))
			{
				gridHeaderColumns.put("Name", i);
			}
			else if(objHeaderColumns.get(i).getText().contains("Price"))
			{
				gridHeaderColumns.put("Price", i);
			}	
		}
		for (String key : gridHeaderColumns.keySet()) {
			  System.out.println(" Map Key : " + key);
			}
		for (Integer val : gridHeaderColumns.values()) {
			  System.out.println(val);
			}
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return gridHeaderColumns;
	}
	
	public static List<Map<String, String>> readTableFilteredRow()
	{
		int count =0;
		HashMap<String, String> gridColumnsMap = new HashMap<String, String>();
	try {
		List<WebElement> elements = homepage.getTableFilteredRow();
		log.info("Total Filetered Rows : " + elements.size());

		for(WebElement ele:elements)
		{
			List<WebElement> positionColumns = ele.findElements(By.xpath(".//td/p"));
			List<WebElement> nameColumns = ele.findElements(By.xpath("./td[@style='text-align: start;']//div/p"));
			List<WebElement> priceColumns = ele.findElements(By.xpath(".//td//a[@class='cmc-link']/span"));
			
			gridColumnsMap.put("Position", positionColumns.get(0).getText()); 
			
			String name = nameColumns.get(0).getText();
			for(int i=1;i<nameColumns.size();i++)		
			{
				name = name + " " + nameColumns.get(i).getText();
			}
			gridColumnsMap.put("Name", name);
			gridColumnsMap.put("Price", priceColumns.get(0).getText()); 
			log.info("Position : " + gridColumnsMap.get("Position"));
			log.info("Name : " + gridColumnsMap.get("Name"));
			log.info("Price : " + gridColumnsMap.get("Price"));
			gridColumnsMapArray.add(gridColumnsMap);
			count++;
		}
		
		for(int index=0;index<gridColumnsMapArray.size();index++)
		{
				log.info(gridColumnsMapArray.get(index).get("Position"));
				log.info(gridColumnsMapArray.get(index).get("Name"));
				log.info(gridColumnsMapArray.get(index).get("Price"));
		}
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return gridColumnsMapArray;
	}
	
}
