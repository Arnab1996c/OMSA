package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DriverFile.BaseClass;

import Method.DiffMethod;

public class LogInPage extends BaseClass {
	 By DpStation=By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']");
	 
	@FindBy(xpath="//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")
	WebElement DepartureStation;
	@FindBy(xpath="//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")
	WebElement ArrivalStation;
	@FindBy(xpath="//a[@id='highlight-addons']")
	WebElement AddOns;
	@FindBy(xpath="//input[@id='ctl00_mainContent_btn_FindFlights']")
	WebElement SearchButton;
	@FindBy(xpath="//a[@id='ctl00_HyperLinkLogin']")
	WebElement LogInButton;
	@FindBy(xpath="//span[contains(text(),'Next')]//preceding::div[1][@class='ui-datepicker-title']")
	WebElement MonthYearValue;
	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement NextButton;
	By RoundTrip=By.xpath("//label[contains(text(),'Round Trip')]//preceding::input[1]");
	By DatePickerObject=By.xpath("//label[contains(text(),'Return date')]//following::button[1][@class='ui-datepicker-trigger']");
	//INITIALIZING THE PAGE OBJECTS:
	public LogInPage(){
		PageFactory.initElements(driver, this);
	}
	//Actions:
	public String verifyTitleOfPage(){
		return driver.getTitle();
	}
	public void clickOnDepartureCity(){
		DiffMethod.Click(DepartureStation);
		//DiffMethod.Click(driver.findElement(DpStation));
	}
	public void SelectOneDepartureCity(String DepartureCity){
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'"+DepartureCity+"')]"));
		element.click();
	}
	public void checkDepartureCity(){
		DiffMethod.Check(DepartureStation);
	}

	public void checkSearchButton(){
		DiffMethod.Check(SearchButton);
	}
	public void MouseHoverOnLogInButton(){
		DiffMethod.MouseHover(LogInButton);		
	}
	public void DepartureCalenderDate(String DAY_Month_Year) throws InterruptedException{
		DiffMethod.DatePicking(MonthYearValue, NextButton, DAY_Month_Year);
	}
	public void clickOnArrivalCity(){
		DiffMethod.Click(ArrivalStation);
		//DiffMethod.Click(driver.findElement(DpStation));
	}
	public void SelectOneArrivalCity(String ArrivalCity){
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'"+ArrivalCity+"')]"));
		element.click();
	}
	public void ArrivalCalenderDate(String DAY_Month_Year) throws InterruptedException{
		DiffMethod.DatePicking(MonthYearValue, NextButton, DAY_Month_Year);
	}
	public void clickOnRoundTrip(){
		DiffMethod.Click(driver.findElement(RoundTrip));
	}
}

