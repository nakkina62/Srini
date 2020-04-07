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

public class validateTitle extends base{
	public static Logger Log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void intialize() throws IOException
	{
		driver=InitializeDriver();
		Log.info("Driver Initialized");
	}
	
	@Test
	public void basePageNavigation() throws IOException
	{
		
		
		LandingPage LP = new LandingPage(driver);
		
		Assert.assertEquals(LP.Title().getText(),"FEATURED COURSES123");
		Log.info("Successfullt Test Message is Validated");;
		
		
	}
		
			
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
			
			
}
		
		
	
		
		
		
		
		
	
	

