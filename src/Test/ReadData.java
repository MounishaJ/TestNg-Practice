package Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadData {

	@Test
	public void Login() throws IOException
	{
	
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("F:\\Automation-Selenium\\TestNGTutorial\\src\\Test\\Data.properties");
		prop.load(fis);
		
		System.out.println("read my username from file"+" "+prop.getProperty("username"));
		System.out.println("read my password from file"+" "+prop.getProperty("password"));
		System.out.println("read my URL name from file"+" "+prop.getProperty("url"));
	
	}
	
}
