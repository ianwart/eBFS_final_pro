package eBFS_Final_Project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class implicitwaitmethod {
	

	
	public implicitwaitmethod(WebDriver driver){
	 PageFactory.initElements(driver, this);	
		
	}
	
	public void implicitwait(WebDriver driver){
		
		driver.manage().timeouts().implicitlyWait(7000, TimeUnit.SECONDS);
	}

}
