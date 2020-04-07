package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoinPage {
	
	public WebDriver driver;
	
		
	@FindBy(xpath="//input[@id='user_email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='user_password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;
	
	@FindBy(xpath="//a[@class='navbar-brand header-logo']")
	WebElement home;
	
	
	public LogoinPage(WebDriver driver) {
				
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement Email()
	{
		return Email;
	}
	
	public WebElement password()
	{
		return password;
	}
	
	public WebElement submit()
	{
		return submit;
	}
	
	public WebElement home()
	{
		return home;
	}

}
