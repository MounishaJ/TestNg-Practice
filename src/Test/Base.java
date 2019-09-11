package Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Base {
	
	
	Properties prop=new Properties();
	WebDriver driver=null;
	
		
	@BeforeTest
	public void launch() throws IOException 
	{

		FileInputStream fis=new FileInputStream("F:\\Automation-Selenium\\TestNGTutorial\\src\\Test\\Data.properties");
		prop.load(fis);
		
		if(prop.getProperty("Browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F://Web Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else 
		{
			System.setProperty("webdriver.gecko.driver", "F://Web Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.get(prop.getProperty("URL"));
	}
	
	
	@Test
	public void selectPlaces() throws InterruptedException 
	{
		
		driver.findElement(By.id("FromTag")).sendKeys("mum");
		Thread.sleep(2000);
		driver.findElement(By.id("FromTag")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("ToTag")).sendKeys("che");
		Thread.sleep(2000);
		driver.findElement(By.id("ToTag")).sendKeys(Keys.ENTER);
		
	}
	@Test
	public void z() throws InterruptedException
	{
		
		driver.findElement(By.id("DepartDate")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active ")).click();
		
		
		
		Select s=new Select(driver.findElement(By.id("Adults")));
		s.selectByValue("2");
	
		Select s1=new Select(driver.findElement(By.id("Childrens")));
		s1.selectByIndex(1);
		
		Select s2=new Select(driver.findElement(By.id("Infants")));
		s2.selectByValue("1");
	
	
	
	
	
//	driver.findElement(By.xpath("//i[@class='blue rArrow']")).click();
	driver.findElement(By.id("MoreOptionsLink")).click();
	Select s3=new Select(driver.findElement(By.id("Class")));
	s3.selectByVisibleText("Business");
	driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Indigo Airlines");
	
	
	driver.findElement(By.id("SearchBtn")).click();
	
	
	//grab the error and print in console
//	System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
	
	}
	
	@AfterTest
	public void Quit() 
	{
		
		//driver.close();
	}
	

}
