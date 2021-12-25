package Method ;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import DriverFile.BaseClass;
import DriverFile.EnvVariable;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class DiffMethod extends BaseClass{
	private static HSSFWorkbook workbook;
    private static HSSFSheet sheet;
    private static HSSFRow row;
    private static HSSFCell cell;
    public static Xls_Reader reader=new Xls_Reader(EnvVariable.Path_TestData);
  
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
		
	}
	public static void Select_DepartureCity(String ColumnName,int RowNo) throws InterruptedException{
		String DepartureCity=reader.getCellData("DataWebEdit", ColumnName, RowNo);
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'"+DepartureCity+"')]"));
		element.click();
		
	}
	public static void Set(WebElement element, String ColumnName,int RowNo) throws InterruptedException {
		try{
		String WebEditData=reader.getCellData("DataWebEdit", ColumnName, RowNo);
		element.sendKeys(Keys.HOME);
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.DELETE);
		element.sendKeys(WebEditData);
		 	}
			catch(Exception exception){
		   		System.out.println(exception);
				exception.printStackTrace();
				String ErrMsg = exception.toString();
				System.out.println(exception.toString());
				System.out.println(exception.getMessage());
				triggerAlert(ErrMsg);
			}
		  
	}
	public static void Select(WebElement element, String ColumnName,int RowNo){
		try {
		Select SELECT = new Select(element);
		String WebListData=reader.getCellData("DataWebList", ColumnName, RowNo);
		SELECT.selectByVisibleText(WebListData);
		}
		catch(Exception exception){
	   		System.out.println(exception);
			exception.printStackTrace();
			String ErrMsg = exception.getMessage();
			//System.out.println(exception.toString());
			System.out.println(ErrMsg);
			try {
				triggerAlert(ErrMsg);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void Click(WebElement element){	
		Check(element);
		element.click();
	}	
	public static void Check(WebElement element){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);		
	}
	public static void MouseHover( WebElement element){
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();			
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
	public static void AlertAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public static void AlertDismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
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
	public static void triggerAlert(String alertMessage) throws InterruptedException{
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("confirm('"+alertMessage+"')");
        Thread.sleep(10000);
         AlertAccept();
    }
	public static void FileUpload(WebElement element, String FilePath) {
	element.sendKeys(FilePath);	
	}
	
	
	/*public static void dialogBox(){
		
	JOptionPane.showOptionDialog(null, message, "An Err Occured", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null);
	
	}*/

	
	
}

