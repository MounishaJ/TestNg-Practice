package LearningMaven;


import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelExcercise1 {
	
	public void ReadExcel(String filePath,String fileName,String sheetName) throws IOException{

	    //Create an object of File class to open xlsx file

	    File file =    new File(filePath+"\\"+fileName);

	    //Create an object of FileInputStream class to read excel file

	    FileInputStream inputStream = new FileInputStream(file);

	    Workbook guru99Workbook = null;

	    //Find the file extension by splitting file name in substring  and getting only extension name

	    String fileExtensionName = fileName.substring(fileName.indexOf("."));

	    //Check condition if the file is xlsx file

	    if(fileExtensionName.equals(".xlsx")){

	    //If it is xlsx file then create object of XSSFWorkbook class

	    guru99Workbook = new XSSFWorkbook(inputStream);

	    }

	    //Check condition if the file is xls file

	    else if(fileExtensionName.equals(".xls")){

	        //If it is xls file then create object of XSSFWorkbook class

	        guru99Workbook = new HSSFWorkbook(inputStream);

	    }

	    //Read sheet inside the workbook by its name

	    Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);

	    //Find number of rows in excel file

	    int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();

	    //Create a loop over all the rows of excel file to read it

	    for (int i = 0; i < rowCount+1; i++) {

	        Row row = guru99Sheet.getRow(i);

	        //Create a loop to print cell values in a row

	        for (int j = 0; j < row.getLastCellNum(); j++) {

	            //Print Excel data in console

	            System.out.print(row.getCell(j).getStringCellValue()+"|| ");

	        }

	        System.out.println();
	    } 

	    }  
	
	
	
	
public static void main(String []arg)
{
	String FilePath = "D:\\sampledoc.xls";


	}





	   public static void readExcel(String filePath,String fileName,String sheetName) throws IOException
	   {
		   			//Create a object of File class to open xlsx file
	        File file = new File(filePath+"\\"+fileName);
	        		//Create an object of FileInputStream class to read excel file
	        FileInputStream inputStream = new FileInputStream(file);
	        Workbook myWorkbook = null;
			        //Find the file extension by spliting file name in substring and getting only extension name
			        //indexOf gives the index of . in the file name
			        //substring method splits the string starting from index of . to the end
			        String fileExtensionName = fileName.substring(fileName.indexOf("."));
	       
			        //Check condition if the file is xlsx file
	        if(fileExtensionName.equals(".xlsx")){
	        		//If it is xlsx file then create object of XSSFWorkbook class
	        	myWorkbook = new XSSFWorkbook(inputStream);
	        }
	        		//Check condition if the file is xls file
	        else if(fileExtensionName.equals(".xls")){
	        		//If it is xls file then create object of HSSFWorkbook class
	        	myWorkbook = new HSSFWorkbook(inputStream);
	        }
	        		//Read sheet inside the workbook by its name
	        Sheet mySheet = myWorkbook.getSheet(sheetName);
	        		//Find number of rows in excel file
	        int rowCount = mySheet.getLastRowNum()- mySheet.getFirstRowNum();
	        
	        		//Create a loop over all the rows of excel file to read it
	        for (int i = 0; i < rowCount+1; i++) {
	            Row row = mySheet.getRow(i);
	            	//Create a loop to print cell values in a row
	            for (int j = 0; j < row.getLastCellNum(); j++) {
	                //Print excel data in console
	                System.out.print(row.getCell(j).getStringCellValue()+"|| ");
	            }
	         
	            System.out.println();
	        }
	   }
	        
	
	   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



/*
  
  I hope below code is helpful for you and let me know

public class datadrivennew {

public ArrayList<String> getData(String testcaseName) throws IOException{


ArrayList<String> a = new ArrayList<String>();

FileInputStream fis = new FileInputStream("C:\\Users\\admin\\Desktop\\DemoTest.xlsx");

XSSFWorkbook workbook = new XSSFWorkbook(fis);

int sheets = workbook.getNumberOfSheets();


for (int i = 0; i < sheets; i++)

{

if (workbook.getSheetName(i).equalsIgnoreCase("TestData"))

{

XSSFSheet sheet = workbook.getSheetAt(i);

Iterator<Row> rows = sheet.iterator();

Row firstrow = rows.next();

Iterator<Cell> ce = firstrow.cellIterator();

int k = 0;

int column = 0;

while (ce.hasNext())

{

Cell value = ce.next();

if (value.getStringCellValue().equalsIgnoreCase(testcaseName))

{

    column = k;

}

k++;

}

System.out.println(column);

while (rows.hasNext())

{

Row r = rows.next();

a.add(r.getCell(column).getStringCellValue());

}

}

}

return a;

}

public static void main(String[] args) throws IOException {

datadrivennew d = new datadrivennew();

ArrayList data = d.getData("TestData");

System.out.println(data.get(0));

System.out.println(data.get(1));

System.out.println(data.get(2));

System.out.println(data.get(3));

System.out.println(data.get(4));


}

}
*/
/*


	public static XSSFWorkbook wb;

	public static XSSFSheet sheet;

	public static XSSFRow row;

	public static XSSFCell cell;

	public static FileInputStream fis;


		public static void main(String[] args) throws IOException {

		// 6/5/2019

		String value=getCelldata(2,2);

		System.out.println(value);

		String value1=getCelldata(1,2);

		System.out.println(value1);

		value=setCelldata("automation",2,2);

		System.out.println(value);

		}

		private static String setCellvalue(int i, int j) {

		

		return null;

		}

		public static String getCelldata( int rownum,int col) throws IOException

		{

		fis =new FileInputStream("D:\\data.xlsx");

		wb=new XSSFWorkbook(fis);

		sheet=wb.getSheet("script");

		row=sheet.getRow(2);

		cell=row.getCell(2);

		return cell.getStringCellValue();

		}

		public static String setCelldata(String text,int rownum,int col) throws IOException

		{

		fis =new FileInputStream("D:\\data.xlsx");

		wb=new XSSFWorkbook(fis);

		sheet=wb.getSheet("script");

		row=sheet.getRow(2);

		cell=row.getCell(2);

		cell.setCellValue(text);

		String celldata1= cell.getStringCellValue();

		return celldata1;

		}

*/