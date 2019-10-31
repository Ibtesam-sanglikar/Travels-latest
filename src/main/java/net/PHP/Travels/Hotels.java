package net.PHP.Travels;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Hotels extends HomePage {

	public Hotels() throws IOException {
		super();
		log=Logger.getLogger(Hotels.class);
	}

	By location=By.xpath("//div[@id='s2id_autogen1']");
	By checkIn=By.xpath("//input[@id='checkin']");
	By checkOut=By.xpath("//input[@id='checkout']");
	By adults=By.xpath("//div[contains(@class,'col o2')]//input[@placeholder='0']");
	By childs=By.xpath("//div[contains(@class,'col 01')]//input[contains(@placeholder,'0')]");
	By search=By.xpath("//div[contains(@class,'col-md-2 col-xs-12 o1')]//button[contains(@class,'btn btn-primary btn-block')][contains(text(),'Search')]");
	
	
    public void gotIt()
	{
	    By got=By.xpath("//*[@id='cookyGotItBtnBox']/div/button");
		driver.findElement(got).click();
	
	}

	public void by_city_name() throws InterruptedException
	{
		//gotIt();
		log.info("entering city name :"+prop.getProperty("city_name"));
		driver.findElement(location).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='select2-drop']//input[contains(@class,'select2-input')]")).sendKeys(prop.getProperty("city_name"));
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(text(),'India')]")).click();
				
	}
	
	
	public void pick_checkIn()
	{
		log.info("entering checkIn date");
		driver.findElement(checkIn).click();
		String current_month=driver.findElement(By.xpath("//div[1]//nav[1]//div[2]")).getText();
		do
		{
			
			driver.findElement(By.xpath("//body[contains(@class,'with-waypoint-sticky')]/div[@id='datepickers-container']/div[1]/nav[1]/div[3]/*[1]")).click();
			current_month=driver.findElement(By.xpath("//div[1]//nav[1]//div[2]")).getText();
		}while(current_month.equalsIgnoreCase(prop.getProperty("checkInMonth")));

		List<WebElement> dates=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div"));
		int count=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div")).size();
		
		for(int i=0;i<count;i++)
		{
			String date=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div")).get(i).getText();
			if(date.equals(prop.getProperty("checkInDate")))
			{
				driver.findElement(By.xpath("//*[@id='datepickers-container']/div[1]/div/div[1]/div[2]/div[contains(text(),"+prop.getProperty("checkInDate")+")]")).click();
			}
		}
		
	}
	
	
    public void pick_checkOut()
    {
    	log.info("entering check Out date");
    	driver.findElement(checkOut).click();
		String current_month=driver.findElement(By.xpath("//div[2]//nav[1]//div[2]")).getText();
		do
		{
			driver.findElement(By.xpath("//body[contains(@class,'with-waypoint-sticky')]/div[@id='datepickers-container']/div[2]/nav[1]/div[3]/*[1]")).click();
			current_month=driver.findElement(By.xpath("//div[2]//nav[1]//div[2]")).getText();
		}while(current_month.equals(prop.getProperty("checkOutMonth")));

		List<WebElement> dates=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[2]/div/div/div[2]/div"));
		int count=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[2]/div/div/div[2]/div")).size();
		
		for(int i=0;i<count;i++)
		{
			String date=driver.findElements(By.xpath("//*[@id='datepickers-container']/div[2]/div/div/div[2]/div")).get(i).getText();
			if(date.equals(prop.getProperty("checkInDate")))
			{
				driver.findElement(By.xpath("//*[@id='datepickers-container']/div[2]/div/div/div[2]/div[contains(text(),"+prop.getProperty("checkInDate")+")]")).click();
			}
		}
    }
    
    
    public void pick_guests()
    {
    	log.info("entering adults count");
    	driver.findElement(adults).click();
    	String val_adult=null;
    	//adults
    	do {
    		driver.findElement(By.xpath("//div[contains(@class,'col o2')]//button[contains(@class,'btn btn-white bootstrap-touchspin-up')][contains(text(),'+')]")).click();
    		val_adult=driver.findElement(adults).getText();
    		
    		}while(val_adult.equals(prop.getProperty("adults_count")));
    	
    	
    	//child
    	log.info("entering childs count ");
    	driver.findElement(childs).click();
    	String val_child=null;
    	do {
    		driver.findElement(By.xpath("//div[contains(@class,'col 01')]//button[contains(@class,'btn btn-white bootstrap-touchspin-up')][contains(text(),'+')]")).click();
    		driver.findElement(search).click();
    		val_child=driver.findElement(childs).getText();
    	   }while(val_child.equals(prop.getProperty("childs_count")));
    	
    	
    }
}
