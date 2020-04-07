package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LogoinPage;
import resources.base;

public class validateNavigationBar extends base{
	public static Logger Log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void intialize() throws IOException
	{
		driver=InitializeDriver();
		//driver.get("http://qaclickacademy.com");
	}
	
	@Test
	public void basePageNavigation() throws IOException
	{
		// Creating object to that class and invokes methods of it
		LandingPage LP = new LandingPage(driver);
		//verify that navigation bar is present on the page or not
		Assert.assertTrue(LP.Navbar().isDisplayed());
		Log.info("Navigation Bar is displayed");
		
		
		
	}
		
			
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
			
			
			
}
		
		
	
		
		
		
		
		
	
	

