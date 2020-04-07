package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LogoinPage;
import resources.base;

public class HomePage extends base{
	
		
	@Test(dataProvider="getData")
	public void basePageNavigation(String Email, String password) throws IOException
	{
		driver=InitializeDriver();
		//driver.get("http://qaclickacademy.com");
		LandingPage LP = new LandingPage(driver);
		LP.Login().click();
		
		LogoinPage Login = new LogoinPage(driver);
		Login.Email().sendKeys(Email);
		Login.password().sendKeys(password);
		Login.submit().click();
		//Login.home().click();
		
	}
	
	/*@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}*/
	
		@DataProvider
		public Object[][] getData()
		{
			// Row stands for how many different data types test should run
			// column stands for how many values per each test
			// When you say that Array size is 2, index starts from 0,1. Not from 1.
			Object[][] data = new Object[2][2];
			//0th row
			data[0][0]="nonrestricteduser@gmail.com";
			data[0][1]= "123456";
			//data[0][2]="Restricted User";
			//1st row
			data[1][0]="restricteduser@gmail.com";
			data[1][1]="45678";
			//data[1][2]="Non-restricted User";
			
			return data;
		}
		
		
	

}
