package DriverFile;

	import java.io.File;
	import java.io.IOException;
	import java.sql.Timestamp;
	import java.time.Instant;
	import java.util.Date;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass {
		public static WebDriver driver;
		
		public void initialization(String browser){
			if (browser.equals("Chrome")){
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("window-size=1400,800");
				options.addArguments("headless");
				/*DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				options.merge(capabilities);*/
				driver = new ChromeDriver(options);
			}
			else if(browser.equals("Edge")) {
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			//driver.get("https://spicejet.com/");
			driver.get("https://www.spicejet.com/");
			
		}
		
		
		
	}



