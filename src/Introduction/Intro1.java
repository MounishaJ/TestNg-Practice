package Introduction;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Intro1 {


	@Parameters({"username"})
	@Test
	public void disp(String UserID)
	{
	
		System.out.println("Testng tutorial");
	System.out.println(UserID);
	}
}
