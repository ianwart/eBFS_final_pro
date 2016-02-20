package eBFS_Final_Project;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtil {
static TakesScreenshot ScrFile = null;
	
	public static String getScreenshot(WebDriver driver,String Screenshotname) throws Exception {
		 ScrFile = (TakesScreenshot)driver;
	File Source = ScrFile.getScreenshotAs(OutputType.FILE);
	 String savetoDestinationFile = ("C:\\NewScreenShot\\"+Screenshotname+".jpg");
	 File destination = new File(savetoDestinationFile);
	 FileUtils.copyFile(Source, destination);
	 
	return 	savetoDestinationFile;
	}
	
		
	

}
