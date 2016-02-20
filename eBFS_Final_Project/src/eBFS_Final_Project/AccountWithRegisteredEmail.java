package eBFS_Final_Project;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



public class AccountWithRegisteredEmail {
	
	WebDriver driver;
	Properties  proff ;
	ScreenShotUtil capture ;
	
public AccountWithRegisteredEmail(WebDriver driver){
		
	PageFactory.initElements(driver, this);
	proff = new Properties();
	capture = new ScreenShotUtil();
	
	
	
	WebElement E_ClickSignIn = driver.findElement(By.className("login"));
     if (E_ClickSignIn.isDisplayed()) {
    	 Reporter.log("SignIn button is present.");
    	 E_ClickSignIn.click();
	}else {
		Reporter.log("SignIn button is not present.");
		
	}
    	
    WebElement email = driver.findElement(By.id("email_create"));
	if (email.isDisplayed()) {
		 Reporter.log("Email field is present.");
		email.sendKeys("rabbani@rabbani.com");
		
	}else {
		Reporter.log("Email field is not present.");
	}
	
	WebElement clickweblink = driver.findElement(By.id("SubmitCreate"));
	if (clickweblink.isDisplayed()) {
		Reporter.log("Create account link is present.");
		clickweblink.click();
		
	}else {
		Reporter.log("Create account link is not present.");
	}
	
}

}
