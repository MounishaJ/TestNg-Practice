package Introduction;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Intro {

	@AfterMethod
	public void afterm()
	{
		System.out.println("after every method iam executes");
	}
		@Test
		public void intro()
		{
		
			System.out.println("Welcome testng tutorial");
		}

		
		
		@Parameters({"name"})
		@Test
		public void login(String id)
		{
			System.out.println("bye");
			System.out.println(id);
		}
		
		@BeforeMethod
		public void befrorem()
		{
			System.out.println("before method iam executes");
		}
		@Test
		public void Z()
		{
			System.out.println("hello");
		}
	}



