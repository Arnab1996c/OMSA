package Method;

import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import DriverFile.BaseClass;


public class DataSource extends BaseClass{
	private static HSSFWorkbook workbook;
    private static HSSFSheet sheet;
    private static HSSFRow row;
    private static HSSFCell cell;
	

	public void OperationSelector(String ItemType, String ItemAction, String ItemName){
		Xls_Reader reader = new Xls_Reader("D:\\Selenium");
		int colNum,rowNum;
	for( colNum=1;colNum<=reader.getColumnCount("Keyword");colNum++) {	
		for( rowNum=1;rowNum<=reader.getRowCount("Keyword");rowNum++) {
			
			String Keyword = reader.getCellData("Keyword", colNum, rowNum);
			String KeywordSplit[]=Keyword.split("_");
			ItemType = KeywordSplit[0].trim();
			ItemAction= KeywordSplit[1].trim();
			ItemName = KeywordSplit[2].trim();
			System.out.println(ItemName);
			
			
		}
	}
	}
}
