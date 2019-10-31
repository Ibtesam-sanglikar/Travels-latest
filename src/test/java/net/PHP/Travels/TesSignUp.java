package net.PHP.Travels;

import org.testng.annotations.Test;

import net.PHP.Travels.Browser;
import net.PHP.Travels.SignUp;
import verify.Compare;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TesSignUp extends Browser{
   
	public TesSignUp() throws IOException {

	}
	
	//object creation
	
	SignUp s=new SignUp();
	@BeforeTest
	public void initialize() throws IOException
	{
		log.info("executing test case for signup page.....");
		s.launchBrowser();
		s.Maximize(driver);
	}
	
	@Test
	public void runtest() throws IOException
	{
		
		s.My_account();
		s.SignUp();
		s.firstname();
		s.lastname();
		s.mobileNumber();
		s.email();
		s.password();
		s.confirmPassword();
		s.gotIt();
		s.submit();
	}
	@AfterMethod
	  public void screen_shot() throws IOException
	  {
		  //validation
		  Compare.validateForErrors(driver);
		  
		  //capturing screenshot
		  TakesScreenshot ts=(TakesScreenshot)driver;
		  File source=ts.getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(source, new File("./Screenshot/signup.png"));
		  log.info("taking screensht");
	  }
	
	@AfterTest
	public void close() {
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		s.Quit(driver);
	}
	
    
}
