package com.testng;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import DriverFile.BaseClass;
import ObjectRepository.LogInPage;
@Listeners(CustomListner.class)
public class Testng extends BaseClass {
    LogInPage LogInPage;
    
    
@BeforeMethod
public void SetUp(){
	
	initialization("Chrome");
	LogInPage=new LogInPage();
	

}
@Test(priority=1)
public void Test1() throws InterruptedException{
	System.out.println("mousehover");
	//LogInPage.checkSearchButton();
	
	Thread.sleep(5000);
	LogInPage.clickOnRoundTrip();
	Thread.sleep(5000);
	LogInPage.clickOnDepartureCity();
	Thread.sleep(3000);
	LogInPage.SelectOneDepartureCity("Ajmer (KQH");
	//LogInPage.SelectOneDepartureCity("Ajmer (KQ)");
	LogInPage.clickOnArrivalCity();
	
	/*LogInPage.SelectOneArrivalCity("Durgapur (RDP)");
	LogInPage.DepartureCalenderDate("16_December_2021");
	Thread.sleep(5000);
	LogInPage.ArrivalCalenderDate("22_December_2021");
	LogInPage.MouseHoverOnLogInButton();
	Thread.sleep(5000);*/
	
	
}
/*@Test(priority=1,enabled=false)
public void test2() throws InterruptedException{
	Thread.sleep(60000);

	WebElement element=driver.findElement(By.xpath("//label[contains(text(),'Last name')]//following::i[1]"));
	//DiffMethod.MouseHover(element);
	String text=element.getText();
	System.out.println(text);*/
	
	
	
}
/*@AfterMethod
public void close(){
	driver.quit();
}*/
 



