package LearningMaven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven2 {

	public static void main(String[] args) throws IOException {
		// 6/10/2019
		
		FileInputStream fis=new FileInputStream("F:\\ExcelSample.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
	
//Count Number of sheets present in that excel book
		int sheetcount=workbook.getNumberOfSheets();
		System.out.println("sheet count"+" "+sheetcount);
		
		
		for(int i=0;i<sheetcount;i++)
		{
//print sheet name			
			System.out.println("Sheet names"+" "+workbook.getSheetName(i));
//if sheet name matches			
			if(workbook.getSheetName(i).equalsIgnoreCase("TestData"))
			{
				
				XSSFSheet sheet=workbook.getSheetAt(i);
				System.out.println("sheet index" + sheet.getPhysicalNumberOfRows());
		
				
			 Iterator<Row> rows=sheet.iterator(); //sheet is collection of Rows
			 
		
			Row firstrow=rows.next();
			Iterator<Cell> ce=firstrow.cellIterator(); //row is a collection of cells
			int k=0;
			int column=0;
			while(ce.hasNext())
			{
				Cell value=ce.next();
				System.out.println("Cell values"+value.getStringCellValue());
				
				 if(value.getStringCellValue().equalsIgnoreCase("date"))
				 {
					 System.out.println(k);
					 column=k;
				 }
				 k++;
			}
			while(rows.hasNext())
			{
				Row r=rows.next();
				System.out.println("r value: " + r);
				System.out.println("get cell column: " + r.getCell(column));
				
				
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase("02-Feb-2019"))
				{
				
					Iterator< Cell> c=r.cellIterator();
					while(c.hasNext())
					{
						System.out.println(" column values"+" "+c.next().getStringCellValue());
					}
					
				}
			}
		}
		
		
	}

	}

}
