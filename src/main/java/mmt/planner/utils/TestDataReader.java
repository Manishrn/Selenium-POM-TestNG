package mmt.planner.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataReader {

	
	public static Object[][] readTestData(String sheetName) {	
		
		Object[][] data=null;
		XSSFWorkbook wb;
		XSSFSheet sheet;
		
		try {
			FileInputStream fs= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\mmt\\planner\\testdata\\testdata.xlsx");
			wb= new XSSFWorkbook(fs);
			sheet=wb.getSheet(sheetName);			
			 data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int i=0;i<sheet.getLastRowNum();i++) {
				for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				}
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
}
