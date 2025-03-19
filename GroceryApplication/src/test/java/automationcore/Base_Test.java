package automationcore;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import constants.Constant;
import utility.Screenshot_Utility;

public class Base_Test {
	Properties properties;
	FileInputStream file;
	
		 public WebDriver driver;
		  @BeforeMethod(alwaysRun = true)
		  @Parameters("browser")
		  public void initializeBrowser(String browser) throws Exception 
		  {
			  
			  properties=new Properties();
			  file=new FileInputStream(Constant.CONFIGFILE);
			  properties.load(file);
			  if(browser.equalsIgnoreCase("Chrome")) 
			  {
				  driver=new ChromeDriver();  
			  }
			  else if(browser.equalsIgnoreCase("Edge"))
			  {
				  driver=new EdgeDriver();
			  }
			  else if(browser.equalsIgnoreCase("FireFox"))
			  {
				  driver=new FirefoxDriver();
			  }
			  else 
			  {
				 throw new Exception("Invalid Browser!!!");
			  }
			  driver.get(properties.getProperty("baseurl"));
			  driver.manage().window().maximize();
			  //Wait_Utility.waitutility=new WaitUtility();
			  //wait_utility.implicitWait(WebDriver driver);
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//call it from utility
			  }

		  @AfterMethod
		  public void driverQuit(ITestResult iTestResult) throws IOException //ITestResult is an interface
		  {
			  //driver.quit();
			  if(iTestResult.getStatus()==iTestResult.FAILURE) 
			  {
				  Screenshot_Utility screenshot=new Screenshot_Utility();
				  screenshot.getScreenshot(driver, iTestResult.getName());//getname--->method name
			  }
		  }

}