package verify;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.PHP.Travels.Browser;
public class Compare extends Browser{
	public Compare() throws IOException {
		super();	
	}

	public static boolean validateName(WebDriver driver,String name,String lname){
		boolean result=false;
		String space=" ";
		String message="Hi,".concat(space).concat(name).concat(space).concat(lname);
		System.out.println(message);
		String my_name=driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div/div/div[1]/div/div[2]/h3")).getText();
		System.out.println(my_name);
		if(my_name.equals(message))
		{
			System.out.println("both expected and actual name are matching hence testcase is passed");
			result=true;
		}
		return result;	
	}
	
	public static boolean validateResultPage(WebDriver driver)
	{
		boolean result=false;
		return result=driver.findElement(By.xpath("//button[@data-target='#change-search']")).isDisplayed();	
		
	}
	public static boolean validateBookingOption(WebDriver driver)
	{
		boolean result=false;
		return result=driver.findElement(By.xpath("//div[@class='booking-selection-box']")).isDisplayed();	
	}
	
	public static void validateForErrors(WebDriver driver)
	{	
		
		boolean result=false;
		result=driver.findElement(By.xpath("//div[@class='alert alert-danger']")).isDisplayed();
		if(result==true)
		  {
		  String reason=driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		  System.out.println("unable to register");
		  System.out.println("the reason might be...");
		  System.out.println(reason);
		  }
		  else
		  {
			  System.out.println("successfully logged in");
		  }
		  
	}
	
}
