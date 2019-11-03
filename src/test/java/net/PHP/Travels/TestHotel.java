package net.PHP.Travels;
import org.testng.annotations.Test;
import net.PHP.Travels.Browser;
import net.PHP.Travels.Hotels;
import verify.Compare;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class TestHotel extends Browser{
  
	
	
	public TestHotel() throws IOException {
		
	}
	Hotels h=new Hotels();
	boolean result;


@BeforeTest
public void initialize() {
	  log.info("executing hotels page....");
	  h.launchBrowser();
	  h.Maximize(driver);
}
@Test
public void runtest() throws InterruptedException{
	h.by_city_name();
	h.gotIt();
	h.pick_checkIn();
	h.pick_checkOut();
	h.pick_guests();
	 
}

@AfterMethod
public void screen_shot() throws IOException
{
	//validation
	  result=Compare.validateResultPage(driver);
	  Assert.assertTrue(true,"this page is not the results page");
	  
	  //capturing screenshot
	   log.info("taking screenshot"+h.getClass());
           Screenshot.CaptureScreenshot(driver,"Hotel");
 
}
@AfterTest
public void close() {
	  h.Quit(driver);
}


}
