package net.PHP.Travels;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;

public class HomePage extends Browser{
	public HomePage() throws IOException {
		super();
	
	}
	public void My_account() {
	   By my_acct=By.xpath(prop.getProperty("my_acct"));
	   driver.findElement(my_acct).click();
	}
	
	public void SignUp() {
		   By signup=By.xpath(prop.getProperty("signup"));
		   driver.findElement(signup).click();
	}
		
	public void Login() {
		   By login=By.xpath(prop.getProperty("login"));
		   driver.findElement(login).click();
	}
	
	public void Hotels() {
		   driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		   By hotels=By.xpath(prop.getProperty("hotels"));
		   driver.findElement(hotels).click();
	}
	

	public void flights() {
		   driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		   By flights=By.xpath(prop.getProperty("flights"));
		   driver.findElement(flights).click();
	}
	
	public void tours() {
		   By tours=By.xpath("//a[contains(text(),'Tours')]");
		   driver.findElement(tours).click();
	}
	public void  transfer()
	{
		   By transfer=By.xpath(prop.getProperty("transfer"));
		   driver.findElement(transfer).click();
		
	}

}
