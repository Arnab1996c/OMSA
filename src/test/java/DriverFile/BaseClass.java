package DriverFile;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
    import org.openqa.selenium.edge.EdgeDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;

//import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass {
		public static WebDriver driver;
		
		public void initialization(String browser){
			if (browser.equals(EnvVariable.Browser_Type1)){
				WebDriverManager.chromedriver().setup();

				//System.setProperty("webdriver.chrome.driver","D://Selenium//ChromeDriver//chromedriver.exe");
				//ChromeOptions options = new ChromeOptions();
				//options.addArguments("window-size=1400,800");
				//options.addArguments("headless");
				/*DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				options.merge(capabilities);*/
				driver = new ChromeDriver();
			}
			else if(browser.equals(EnvVariable.Browser_Type2)) {
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			//driver.get("https://spicejet.com/");
			driver.get(EnvVariable.URL);
			
		}
		
		
		
	}



