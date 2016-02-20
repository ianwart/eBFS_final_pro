package eBFS_Final_Project;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	
	/*public ExcelRead(WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}*/
		
		FileInputStream file;
		XSSFWorkbook wb;
		XSSFSheet sheet;
		
		public ExcelRead(String FilePath) throws Exception{
			
			
				file = new FileInputStream(FilePath);
				//create workbook instance that refers to .xls file
				wb = new XSSFWorkbook(file);
				//create a sheet object to retrive the sheet
				sheet = wb.getSheetAt(0);
				int RowNum = sheet.getLastRowNum();
				int cellNum = sheet.getRow(0).getLastCellNum();
				/*String [][] data = new String[RowNum][cellNum];
				System.out.println(RowNum);
				for(int i =0;i<=RowNum;i++){
				XSSFRow	ROWS = sheet.getRow(i);
				for(int j=0;j<=cellNum;j++) {
					XSSFCell cell =ROWS.getCell(j);
					String value = cellToString(cell);
					data [i][j] = value;
				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
				}
				}*/
			
				
		}
			




		

		
		public String getdata(int Sheet,int Row,int Cell){
	  String data1 = wb.getSheetAt(Sheet).getRow(Row).getCell(Cell).getStringCellValue();
	    	
	    		
		return data1;
		
			
		}

		

}
