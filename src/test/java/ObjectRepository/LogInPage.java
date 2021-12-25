package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import DriverFile.BaseClass;

public class LogInPage extends BaseClass {
	
	public WebElement RoundTrip() {
		WebElement RoundTrip=driver.findElement(By.xpath("//label[contains(text(),'Round Trip')]//preceding::input[1]"));
		return RoundTrip;
	}
	public WebElement DepartureStation() {
		WebElement DepartureStation = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"));
		return DepartureStation;
	}
	public WebElement ArrivalStation() {
		WebElement ArrivalStation = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']"));
		return ArrivalStation;
	}
	public WebElement AddOns() {
		WebElement AddOns = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']"));
		return AddOns;
	}
	public WebElement SearchButton() {
		WebElement SearchButton = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']"));
		return SearchButton;
	}
	public WebElement MonthYearValue() {
		WebElement MonthYearValue = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		return MonthYearValue;
	}
	public WebElement LogInButton() {
		WebElement LogInButton = driver.findElement(By.xpath("//a[@id='ctl00_HyperLinkLogin']"));
		return LogInButton;
	}
	public WebElement DatePickerObject() {
		WebElement DatePickerObject = driver.findElement(By.xpath("//label[contains(text(),'Return date')]//following::button[1][@class='ui-datepicker-trigger']"));
		return DatePickerObject;
	}
	
	
}

