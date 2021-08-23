package Method ;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.TakesScreenshot;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.JOptionPane;

//import com.testng.CustomListner;


import org.apache.commons.io.FileUtils;


import DriverFile.BaseClass;

public class DiffMethod extends BaseClass{
	public static  void DatePicking(WebElement element1,WebElement element2,String Day_Month_Year ) throws InterruptedException{
		
		/*if (DateType.equals("ReturnDate")){
			System.out.println("ReturnDateSelected");	
			WebElement element=driver.findElement(By.xpath("//label[contains(text(),'Return date')]//following::button[1][@class='ui-datepicker-trigger']"));
			element.click();
		}
			else if(DateType.equals("DepartDate")) {
				System.out.println("DepartDateSelected");
				Thread.sleep(2000);
		}*/
		String Value[]=Day_Month_Year.split("_");
		String Day = Value[0].trim();
		String Month = Value[1].trim();
		String Year = Value[2].trim();
		String MonthYear = element1.getText();//get the value of the current Month Year
		String Month1= MonthYear.split(" ")[0].trim();
		//System.out.println(Month1);
		String Year1= MonthYear.split(" ")[1].trim();
		//System.out.println(Year1);
		while(!((Month1.equals(Month))&&(Year1.equals(Year)))){
			element2.click();//click on Next BUTTON
			MonthYear = element1.getText();
			//System.out.println(MonthYear);
			Month1= MonthYear.split(" ")[0].trim();
			//System.out.println(Month1);
			Year1= MonthYear.split(" ")[1].trim();
			System.out.println(Year1);
		}
		driver.findElement(By.xpath("//a[text()='"+Day+"']")).click();
		try {
			SrcScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void Set(WebElement element, String Data1) {
		element.sendKeys(Keys.HOME);
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.DELETE);
		element.sendKeys(Data1);
		try {
			SrcScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void Select(WebElement element, String Data1){
		Select SELECT = new Select(element);
		SELECT.selectByVisibleText(Data1);
		try {
			SrcScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void Click(WebElement element){
	
		element.click();
		try {
			SrcScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void Check(WebElement element){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		try {
			SrcScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void MouseHover( WebElement element){
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();	
		try {
			SrcScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String SrcScreenshot() throws IOException{
		//Timestamp instant= Timestamp.from(Instant.now()); 
		TakesScreenshot src = ((TakesScreenshot)driver);
		//String filePath="D:/Users/XY58270/Downloads/Screenshot/"+DiffMethod.calendar()+".jpg";
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String filePath="C://ScreenShot"+timeStamp+".png";
		File Srcfile=src.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(filePath);
		FileUtils.copyFile(Srcfile, DestFile);
		return filePath;
	}
	

	/*public static void dialogBox(){
		
	JOptionPane.showOptionDialog(null, message, "An Err Occured", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null);
	
	}*/

	
	
}

