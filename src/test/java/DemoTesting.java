

import java.util.Iterator;
import java.util.Set;

import org.apache.pdfbox.pdmodel.interactive.action.PDAdditionalActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoTesting {
	static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.ebay.com/");
		Actions action = new Actions(driver);
		WebElement Registration = driver.findElement(By.xpath("//a[text()='Registration']"));
		action.contextClick(Registration).perform();
		Thread.sleep(5000);
		action.sendKeys(Keys.CONTROL);
		Thread.sleep(5000);
		action.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		action.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		WindowHandle();
		WebElement CustomerService = driver.findElement(By.xpath("//a[text()='Customer Service']"));
		action.contextClick(CustomerService).perform();	
		Thread.sleep(5000);
		action.sendKeys(Keys.CONTROL);
		Thread.sleep(5000);
		action.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		action.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		WindowHandle();
		driver.findElement(By.xpath("//h2[text()='Buying as a guest ']")).click();
		
	}
	public static void WindowHandle() {
		String MainWindow = driver.getWindowHandle();
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it= handler.iterator();
		String ChildWindow = it.next();
		while(it.hasNext()) {
			if(!MainWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
			}
		}
		
	
	}
	}
