package net.PHP.Travels;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class SignUp extends Browser{
	
	
	public SignUp() throws IOException {
		super();
		log=Logger.getLogger(SignUp.class);
	}

	
	By fname=By.xpath("//input[@placeholder='First Name']");
	By lname=By.xpath("//input[@placeholder='Last Name']");
	By mobile_number=By.xpath("//input[@placeholder='Mobile Number']");
	By email=By.xpath("//input[@placeholder='Email']");
	By password=By.xpath("//input[@placeholder='Password']");
	By confirm_pwd=By.xpath("//input[@placeholder='Confirm Password']");
	
	
	public void firstname() {
		log.info("entering first name:"+prop.getProperty("fname"));
		driver.findElement(fname).sendKeys(prop.getProperty("fname"));
		
	}
	public void lastname() {
		log.info("entering last name:"+prop.getProperty("lname"));
		driver.findElement(lname).sendKeys(prop.getProperty("lname"));
		
	}
	public void mobileNumber() {
		log.info("entering mobile number:"+prop.getProperty("mobile_number"));
		driver.findElement(mobile_number).sendKeys(prop.getProperty("mobile_number"));
		
	}
	public void email() {	
		log.info("entering email id:"+prop.getProperty("email"));
		driver.findElement(email).sendKeys(prop.getProperty("email"));
		
	}
	public void password() {
		log.info("entering password.....");
		driver.findElement(password).sendKeys(prop.getProperty("password"));
		
	}
	public void confirmPassword() {
		driver.findElement(confirm_pwd).sendKeys(prop.getProperty("confirm_password"));
		
	}
	public void submit()
	{
		driver.findElement(By.xpath("//button[@class='signupbtn btn_full btn btn-success btn-block btn-lg']")).click();
		log.info("clicked on sign up button");
	}
	public void gotIt() {

		By gotIt=By.xpath("//button[@class='cc-btn cc-dismiss']");
		driver.findElement(gotIt).click();
		//By acceptCookie=By.xpath("//div[@id='usertrack-consent__button']");
		//driver.findElement(acceptCookie).click();
	}
	
	public void My_account() {
		   driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		   driver.findElement(By.xpath("//div[@class='dropdown dropdown-login dropdown-tab']//a[@id='dropdownCurrency']")).click();
		}
		
		public void SignUp() {
			driver.findElement(By.xpath("//a[@class='dropdown-item tr']")).click();
		}
}
