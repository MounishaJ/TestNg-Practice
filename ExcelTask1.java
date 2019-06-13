package LearningMaven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTask1 {

	public static void main(String[] args) throws IOException {
		// 6/11/2019
		//print all rows data in console (no blank elements)
		
		readExcel("Table");
		}
	
	
	   public static void readExcel(String sheetName) throws IOException
	{
		 
	String FilePath = "F:\\ExcelSample.xlsx";
	FileInputStream fis = new FileInputStream(FilePath);
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	

//Read sheet inside the workbook by its name
			XSSFSheet mySheet = wb.getSheet(sheetName);
 //Find number of rows in excel file
    		int rowCount = mySheet.getLastRowNum()- mySheet.getFirstRowNum();
    		System.out.println(rowCount);
//Create a loop over all the rows of excel file to read it
    		for (int i = 0; i < rowCount+1; i++) {
    			Row row = mySheet.getRow(i);
    			
//Create a loop to print cell values in a row
    			for (int j = 0; j < row.getLastCellNum(); j++) {
        	    //Print excel data in console
            
    				Cell k=row.getCell(j);
    				if(k.getCellTypeEnum()==CellType.STRING)
    				{
    					System.out.println((k.getStringCellValue()));
    				}
    				else
    				{
    					System.out.println((NumberToTextConverter.toText(k.getNumericCellValue())));

    				}
    				
    				
        }
        System.out.println();
    }		    
}
}