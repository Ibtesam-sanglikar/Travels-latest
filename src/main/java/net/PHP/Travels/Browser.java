package net.PHP.Travels;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser{
	Properties prop=new Properties();
	protected static WebDriver driver;
	public static Logger log=null;
	
	public Browser() throws IOException{
	
		FileInputStream fis=new FileInputStream("C:\\AG\\phptravels\\src\\main\\java\\net\\Phptravels\\phptravels\\Data.properties");
		prop.load(fis);
		PropertyConfigurator.configure("C:\\Users\\Online Test\\git\\PHP-TRAVELS\\phptravels\\resource\\log4j.properties");
	    	
	}
	
	
	
	public void launchBrowser()
	{	
		log.info("launching the browser...");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Online Test\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.get(prop.getProperty("URL"));
	}
	public void Maximize(WebDriver driver) {
		log.info("maximizing the window....");
		driver.manage().window().maximize();
	}
	
	public void Quit(WebDriver driver) {
	    driver.quit();
	    log.info("closing browser");
	}
	/*public static void main(String[] args) throws IOException {
		Browser b=new Browser();
		b.launchBrowser(driver);
		b.Maximize(driver);
		b.Quit(driver);
		
	}*/

}
