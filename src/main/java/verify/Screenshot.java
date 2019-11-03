package verify;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
    public static void CaptureScreenshot(WebDriver driver,String filename) throws IOException
    {
      String timestamp=new SimpleDateFormat("yyyy_mm_dd_hh_mm_ss").format(new Date());
      TakesScreenshot ts=(TakesScreenshot)driver;
	  File source=ts.getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(source, new File("./Screenshot/"+filename+""+timestamp+".png")); 
     }
    }
