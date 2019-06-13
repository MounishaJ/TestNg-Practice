package LearningMaven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	
	ArrayList<String> a=new ArrayList<String>();
	
	public static void main(String []arg) throws IOException
	{
		DataDriven d=new DataDriven();
		ArrayList<String>data=d.getData("Purchase");
		for(int i=0;i<data.size();i++)
		{
			System.out.println(data.get(i));
		}
	
	}
	
	
	
	
	public ArrayList<String> getData(String testcaseName) throws IOException
	{
		//6/05/2019
		//ArrayList<String> a=new ArrayList<String>();
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
			if(workbook.getSheetName(i).equalsIgnoreCase("TestSample"))
			{
				
				XSSFSheet sheet=workbook.getSheetAt(i);
				System.out.println("sheet index" + sheet.getPhysicalNumberOfRows());
				//Identfy the Driver column by scanning the entire 1st Row
				
			 Iterator<Row> rows=sheet.iterator(); //sheet is collection of Rows
			 
			 //System.out.println("rows are: " + rows);
			Row firstrow=rows.next();
			Iterator<Cell> ce=firstrow.cellIterator(); //row is a collection of cells
			int k=0;
			int column=0;
			while(ce.hasNext())
			{
				Cell value=ce.next();
				System.out.println("Cell values"+value.getStringCellValue());
				 if(value.getStringCellValue().equalsIgnoreCase("TestCase"))
				 {
					 System.out.println(k);
					 column=k;
				 }
				 k++;
			}
			//System.out.println("Actual column present in "+" "+column);
		//once column is identified then scan entire testcase colun to identify Purchase testcase  row
			
			while(rows.hasNext())
			{
				Row r=rows.next();
				//System.out.println("r value: " + r);
				//System.out.println("get cell column: " + r.getCell(column));
				
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
				{
					//after grab the purchase testcase row=pull the data of that row and feed into test
					Iterator< Cell> cv=r.cellIterator();
					while(cv.hasNext())
					{
					Cell c= cv.next();
					if(c.getCellTypeEnum()==CellType.STRING)
					{

					a.add(c.getStringCellValue());
					}
					else{

					a.add(NumberToTextConverter.toText(c.getNumericCellValue()));

					}
					}
				}
			}
		}
		
		
	}
		return a;

}
}