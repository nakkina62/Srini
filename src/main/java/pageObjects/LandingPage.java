package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	public WebDriver driver;
	
		
	@FindBy(css="a[href*='sign_in']")
	WebElement Login;
	
	@FindBy(css="div[class='text-center']")
	WebElement Title;
	
	@FindBy(css="ul[class='nav navbar-nav navbar-right']")
	WebElement Navbar;
	
	public LandingPage(WebDriver driver) {
				
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement Login()
	{
		return Login;
	}
	
	public WebElement Title()
	{
		return Title;
	}

	public WebElement Navbar()
	{
		return Navbar;
	}
}
