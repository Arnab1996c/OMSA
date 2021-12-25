package com.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import DriverFile.BaseClass;
import DriverFile.EnvVariable;
import Method.DiffMethod;
import ObjectRepository.EbayItemSearchPage;
@Listeners(CustomListner.class)
public class TestngBase extends BaseClass {
    
@BeforeMethod
public void SetUp(){
	
	initialization(EnvVariable.Browser_Type1);
}

@Test()
public void Test1() throws InterruptedException{
	System.out.println("mousehover");
	Thread.sleep(2000);
	DiffMethod.Set(EbayItemSearchPage.SearchBox(),"SearchBox", 2);
	Thread.sleep(5000);
	DiffMethod.Click(EbayItemSearchPage.CategoryType());
	Thread.sleep(5000);
	DiffMethod.Select(EbayItemSearchPage.CategoryType(),"CategoryType", 2);
	Thread.sleep(3000);
	
}
@Test()
public void Test2() throws InterruptedException{
	System.out.println("mousehove");
	Thread.sleep(2000);
	DiffMethod.Set(EbayItemSearchPage.SearchBox(),"SearchBox", 2);
	Thread.sleep(5000);
	DiffMethod.Click(EbayItemSearchPage.CategoryType());
	Thread.sleep(5000);
	DiffMethod.Select(EbayItemSearchPage.CategoryType(),"CategoryType", 5);
	Thread.sleep(3000);
	
}


@AfterMethod
public void close(){
	
	driver.quit();
}
 
}


