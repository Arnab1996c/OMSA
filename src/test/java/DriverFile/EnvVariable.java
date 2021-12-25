package DriverFile;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EnvVariable extends BaseClass{

	public static final String URL = "https://www.ebay.com/";
	public static final String Path_TestData = "C:\\Users\\Arnab\\eclipse-workspace\\OMSA\\src\\test\\java\\Method\\Data.xlsx";
	public static final String Browser_Type1 = "Chrome";
	public static final String Browser_Type2 = "MSEdge";
	public static final String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	public static final String ScreenShot_Path = "C://ScreenShot"+timeStamp+".png";
	
}
