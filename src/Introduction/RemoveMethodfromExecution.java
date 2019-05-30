package Introduction;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RemoveMethodfromExecution {
	
	
	@Test
	public void webloginhomeloan()
	{
System.out.println("weblogin home loan page");		
	}
	
	@Test
	public void APIloginhomeloan()
	{
		System.out.println("APIlogin home loan page");		
	}
	
	@Test(timeOut=4000)
	public void APISigninhomeloan()
	{
		System.out.println("APIsign inhome loan page");		
	}
	
	@Test(dataProvider="getData")
	public void APISingouthomeloan(String id,String pwd)
	{
		System.out.println(id);
		System.out.println(pwd);
	}
	@DataProvider
	public Object[][] getData()
	{
		//1 set of combinations  username password
		//2 set  of username, password
		//3 set of usernam,password
		
		Object[][] data=new Object[3][2];
	//1 set	
		data[0][0]="mounisha";
		data[0][1]="mounisha2128";
	//2nd set
		data[1][0]="jeela";
		data[1][1]="jeela21";
	//3rd set
		data[2][0]="um";
		data[2][1]="um2128";
		return data;
		
	}
	

}
