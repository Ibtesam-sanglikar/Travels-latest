package net.PHP.Travels;
import org.testng.annotations.Test;
import net.PHP.Travels.Browser;
import net.PHP.Travels.Login;
import verify.Compare;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class TestLogin extends Browser {
  
	
	Login l=new Login();
	boolean result;
  public TestLogin() throws IOException 
  {
	
	}
  
  
  
  @BeforeTest
  public void initialize() {
	  log.info("executing test case for login page.....");
	  l.launchBrowser();
	  l.Maximize(driver);
  }
  @Test
  public void runtest(){
	  l.My_account();
	  l.Login();
	  l.email();
	  l.password();
	  l.clickLoginBtn();
	 
	  
  }
  @AfterMethod
  public void screen_shot() throws IOException
  {
	  //validation
	  result=Compare.validateName(driver, prop.getProperty("fname"),prop.getProperty("lname"));
	  Assert.assertTrue(true,"both the expected name and actaul name doesn't match hence test case failed");
	  log.info("taking screenshot.....");
	  
	  // capturing screenshot
           log.info("taking screenshot of: "+l.getClass());
            Screenshot.CaptureScreenshot(driver,"Login");
 	  }
  @AfterTest
  public void close() {
	  l.Quit(driver);
  }

}
