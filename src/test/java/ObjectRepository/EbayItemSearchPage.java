package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import DriverFile.BaseClass;
public class EbayItemSearchPage extends BaseClass{
	public static WebElement SearchBox() {
		WebElement SearchBox=driver.findElement(By.xpath("//input[@aria-label='Search for anything']"));
		return SearchBox;
	}
	public static WebElement CategoryType() {
		WebElement  CategoryType = driver.findElement(By.xpath("//select[@aria-label='Select a category for search']"));
		return  CategoryType;
	}

}
