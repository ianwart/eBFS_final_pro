package eBFS_Final_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class MyaccountPage {

	ExcelRead excel; 
    WebDriver driver;

	public MyaccountPage(WebDriver driver) throws Exception {
	PageFactory.initElements(driver, this);
	
	excel = new ExcelRead("C:\\TestData\\bfs.xlsx");
			
		
	 
	
	WebElement ClickMyInfo = driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[5]/a/span"));
	if (ClickMyInfo.isDisplayed()) {
		ClickMyInfo.click();
	}		
		WebElement LastName = driver.findElement(By.id("lastname"));
		if (LastName.isDisplayed()) {
		 LastName.sendKeys(excel.getdata(0, 1, 7));
		}
		
		WebElement ChangePassward = driver.findElement(By.id("old_passwd"));
		if (ChangePassward.isDisplayed()) {
			ChangePassward.sendKeys(excel.getdata(0, 1, 8));
		}
		
	  WebElement clickingSaveButton = driver.findElement(By.name("submitIdentity"));
		if (clickingSaveButton.isDisplayed()) {
			clickingSaveButton.click();
		}
		
		if (driver.getPageSource().contains("NewLastname")) {
			System.out.println("Last Name is Updated. ");
		}else {
			System.out.println("Last Name is not updated");
		}
		
	}

}
