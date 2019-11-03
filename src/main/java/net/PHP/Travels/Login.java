package net.PHP.Travels;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class Login extends HomePage{

	
	public Login() throws IOException {
		super();
		log=Logger.getLogger(Login.class);
	}
	
	By login=By.xpath("//button[@class='btn btn-primary btn-lg btn-block loginbtn']");
	By email=By.xpath("//input[@placeholder='Email']");
        By password=By.xpath("//input[@placeholder='Password']");
    
    
    public void email()
    {
    	log.info("entering mail id:"+prop.getProperty("email"));
    	driver.findElement(email).sendKeys(prop.getProperty("email"));
    }
    public void password()
    {
    	log.info("entering the password....");
    	driver.findElement(password).sendKeys(prop.getProperty("password"));
    }
    public void clickLoginBtn()
    {
    	driver.findElement(login).click();
    	log.info("clicked on login button");
    }
	public void My_account() {
		   driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		   driver.findElement(By.xpath("//div[@class='dropdown dropdown-login dropdown-tab']//a[@id='dropdownCurrency']")).click();
		}
		
		public void Login() {
			driver.findElement(By.xpath("//a[@class='dropdown-item active tr']")).click();
		}
   

}
