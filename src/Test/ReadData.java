package Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class ReadData extends Base {

	static WebDriver driver;
	@Test
	public void Login() throws IOException
	{
	
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("F:\\Automation-Selenium\\TestNGTutorial\\src\\Test\\Data.properties");
		prop.load(fis);
		
		System.out.println("read my username from file"+" "+prop.getProperty("User1"));
		System.out.println("read my password from file"+" "+prop.getProperty("Pwd"));
		System.out.println("read my URL name from file"+" "+prop.getProperty("URL"));
		
		if(prop.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F://Web Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			driver.get(prop.getProperty("URL"));
		}
		else 
		{
			System.setProperty("webdriver.gecko.driver", "F://Web Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
			driver.get("https://www.google.com/?gws_rd=ssl");
		}
		
	
	}
	
}
