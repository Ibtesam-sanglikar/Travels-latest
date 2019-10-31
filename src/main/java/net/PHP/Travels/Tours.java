package net.PHP.Travels;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Tours extends HomePage{

	public Tours() throws IOException {
		super();
		log=Logger.getLogger(Tours.class);
	}
	
	
	By location=By.cssSelector("#s2id_autogen8");
	By tour_type=By.xpath("//div[@id='tourtype_chosen']//a[contains(@class,'chosen-single')]");
	By date=By.xpath("//input[@id='DateTours']");
	By guests=By.xpath("//div[contains(@class,'col-md-12')]//input[@placeholder='0']");	
	By search=By.xpath("//div[contains(@class,'ftab-inner menu-horizontal-content')]//button[contains(@class,'btn btn-primary btn-block')][contains(text(),'Search')]");
	
	
	
  	
	public void by_city_name() throws InterruptedException
	{
		log.info("entering city name"+prop.getProperty("tour_destination"));
		driver.findElement(location).click();
		driver.findElement(By.xpath("//div[@id='select2-drop']//input[contains(@class,'select2-input')]")).sendKeys(prop.getProperty("tour_destination"));
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//div[contains(text(),'Trip')]")).click();
				
	}
	
	
	public void pick_checkIn()
	{
		log.info("entering check in date");
		driver.findElement(date).click();
		String current_month=driver.findElement(By.xpath("//div[6]//nav[1]//div[2]")).getText();
		do{
			driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[6]/nav[1]/div[3]/*")).click();
			current_month=driver.findElement(By.xpath("//div[6]//nav[1]//div[2]")).getText();
		}while(current_month.equals(prop.getProperty("checkInM")));
		
		List<WebElement> dates=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[2]/div/div/div[2]//*"));
		int count=dates.size();
		
		for(int i=0;i<count;i++)
		{
			String date=driver.findElement(By.xpath("//*[@id='datepickers-container']/div[2]/div/div/div[2]//*")).getText();
		
			if(date.equals(prop.getProperty("checkInD")))
			{
				driver.findElement(By.xpath("//div[@id='datepickers-container']//div//div[2][contains(text(),"+prop.getProperty("checkInD")+")]")).click();
			}
		}
	    	
	}
	public void select_guest()
	{
		log.info("entering guest count");
		driver.findElement(guests).click();
		driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);
		String current_val=null;
		String current_val2=null;
		do
		{
		 current_val2=driver.findElement(guests).getText();
		 driver.findElement(By.xpath("//div[contains(@class,'col-md-12')]//button[contains(text(),'+')]")).click();
		}while(current_val2.equals(prop.getProperty("guest")));
		
	}
   public void select_tourtype()
   {
	  log.info("select tour type..");
	  driver.findElement(tour_type).click();
	  driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);
	  int count=driver.findElements(By.xpath("//li[@class='active-result']")).size();
	  for(int i =0; i<count; i++){
		  String sValue = driver.findElement(By.xpath("//li[@class='active-result']")).getText();
		  if(sValue.equals(prop.getProperty("tour_type")))
			  driver.findElement(By.xpath("//li[@class='active-result'][contains(text(),"+prop.getProperty("tour_type")+")]")).click();
	  }
   }
   public void click_search()
   {
	   driver.findElement(search).click();	 
	   log.info("clicked on search button");
   }
}
