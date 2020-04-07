package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;


public class base {

public static WebDriver driver;

public WebDriver InitializeDriver() throws IOException

{

Properties prop= new Properties();

FileInputStream fis = new FileInputStream("C:\\Users\\Srini Laptop\\E2EProject\\src\\main\\java\\resources\\data.properties");

prop.load(fis);

//String browser = System.getProperty("browser");// this is being used to invoke browser dynamically from mvn and Jenkins.

// if you don't want to use above line, comment it and put browser in double quotes in the below

// if clause.

String browser = prop.getProperty("browser");

        if(prop.getProperty(browser).contains("chrome"))

{

System.setProperty("webdriver.chrome.driver", "C:\\Users\\Srini Laptop\\chromedriver.exe");

ChromeOptions options= new ChromeOptions();//to run chorme headless we need to use this object

// you need to use "--headless" in perenthisis

if(prop.getProperty(browser).contains("headless"))

{

options.addArguments("--headless");

}

driver = new ChromeDriver(options);

}

else if(prop.getProperty("browser").equals("firefox"))

{

//need to provide setproperties for firefox

driver = new FirefoxDriver();

}

else if(prop.getProperty("browser").equals("IE"))

{

//need to provide setproperties for IE

driver = new InternetExplorerDriver();

}

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

driver.get(prop.getProperty("URL"));

return driver;

}

//Get a screen shot of failured test

public void getScreeshot(String result) throws IOException

{

File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

FileHandler.copy(src, new File("C://test//"+result+"screenshot.png"));

}

}

