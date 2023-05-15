package pageLocators;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(how=How.XPATH, xpath=".//button[@id='onetrust-accept-btn-handler']")
	private WebElement cookiesAccept;
	
	@FindBy(how=How.XPATH, xpath="//*[@id=\"__next\"]//a[@title='Go to homepage' and @data-role='logo']")
	private WebElement title;
	
	@FindBy(xpath="//div[@class='scroll-child']//p/following-sibling::div")
	private WebElement row;
	
	@FindBy(xpath="//div[@class='tippy-content']//div/button")
	private List<WebElement> rowButton;
	
	@FindBy(xpath="//div[contains(@class,\"table-control-area\")]//button[contains(@class, \"table-control-filter\")]")
	private WebElement filter;
	
	@FindBy(xpath="//li[@class=\"filter\"]//button")
	private List<WebElement> algoritham;
	
	@FindBy(xpath="//ul/li[@class='optionGroupItem' and starts-with(text(),'PoW')]")
	private WebElement poW;
	
	@FindBy(xpath="//li[@class='filter']/following-sibling::li[4]/button")
	WebElement addFilterButton;
	
	@FindBy(xpath="//label[@id='mineable']")
	private WebElement mineable;
	
	@FindBy(xpath="//button[@data-qa-id='filter-dd-toggle']")
	private List<WebElement> moreFilter;
	
	@FindBy(xpath="//div[@data-qa-id='range-filter-crypto']//button")
	private List<WebElement> cryptoOption;
	
	@FindBy(xpath="//input[@data-qa-id='range-filter-input-min']")
	private WebElement minPriceRange;
	
	@FindBy(xpath="//input[@data-qa-id='range-filter-input-max']")
	private WebElement maxPriceRange;
	
	@FindBy(xpath="//button[@data-qa-id='filter-dd-button-apply']")
	private WebElement applyFilter;
	
	@FindBy(xpath=".//button[contains(text(),'Show results')]")
	private WebElement showResults;
	
	@FindBy(xpath=".//table[contains(@class,'cmc-table')]/thead/tr")
	private WebElement tableHeaderRow;
	
	@FindBy(xpath=".//table[contains(@class,'cmc-table')]/tbody/tr")
	private List<WebElement> tableFilteredRow;

	public WebElement getCookiesAccept() {
		return cookiesAccept;
	}

	public void setCookiesAccept(WebElement cookiesAccept) {
		this.cookiesAccept = cookiesAccept;
	}
	
	public WebElement getShowResults() {
		return showResults;
	}

	public void setShowResults(WebElement showResults) {
		this.showResults = showResults;
	}

	public WebElement getTitle() {
		return title;
	}

	public void setTitle(WebElement title) {
		this.title = title;
	}

	public WebElement getRow() {
		return row;
	}

	public void setRow(WebElement row) {
		this.row = row;
	}

	public List<WebElement> getRowButton() {
		return rowButton;
	}

	public void setRowButton(List<WebElement> rowButton) {
		this.rowButton = rowButton;
	}

	public WebElement getFilter() {
		return filter;
	}

	public void setFilter(WebElement filter) {
		this.filter = filter;
	}

	public List<WebElement> getAlgoritham() {
		return algoritham;
	}

	public void setAlgoritham(List<WebElement> algoritham) {
		this.algoritham = algoritham;
	}

	public WebElement getPoW() {
		return poW;
	}

	public void setPoW(WebElement poW) {
		this.poW = poW;
	}

	public WebElement getAddFilterButton() {
		return addFilterButton;
	}

	public void setAddFilterButton(WebElement addFilterButton) {
		this.addFilterButton = addFilterButton;
	}
	public WebElement getMineable() {
		return mineable;
	}

	public void setMineable(WebElement mineable) {
		this.mineable = mineable;
	}

	public List<WebElement> getMoreFilter() {
		return moreFilter;
	}

	public void setMoreFilter(List<WebElement> moreFilter) {
		this.moreFilter = moreFilter;
	}

	public List<WebElement> getCryptoOption() {
		return cryptoOption;
	}

	public void setCryptoOption(List<WebElement> cryptoOption) {
		this.cryptoOption = cryptoOption;
	}

	public WebElement getMinPriceRange() {
		return minPriceRange;
	}

	public void setMinPriceRange(WebElement minPriceRange) {
		this.minPriceRange = minPriceRange;
	}

	public WebElement getMaxPriceRange() {
		return maxPriceRange;
	}

	public void setMaxPriceRange(WebElement maxPriceRange) {
		this.maxPriceRange = maxPriceRange;
	}

	public WebElement getApplyFilter() {
		return applyFilter;
	}

	public void setApplyFilter(WebElement applyFilter) {
		this.applyFilter = applyFilter;
	}
	
	public List<WebElement> getTableFilteredRow() {
		return tableFilteredRow;
	}

	public WebElement gettableHeaderRow() {
		return tableHeaderRow;
	}
	
}


