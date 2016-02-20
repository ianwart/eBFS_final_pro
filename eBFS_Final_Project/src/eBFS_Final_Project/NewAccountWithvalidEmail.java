package eBFS_Final_Project;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.log4testng.Logger;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class NewAccountWithvalidEmail {
	
	
	Properties proff ;
	FileInputStream input=null;
	ExcelRead excel; 
	static Logger logger;
	ScreenShotUtil capture;
	WebDriver driver;
	ExtentReports Report;
	ExtentTest Logger; 
	implicitwaitmethod waitamoment;
	
	
		public NewAccountWithvalidEmail(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, this);
		proff = new Properties();
		excel = new ExcelRead("C:\\TestData\\bfs.xlsx");
		input = new FileInputStream("C:\\Users\\abull\\workspace\\TestSuit\\src\\locator.properties");
		proff.load(input);
		logger = logger.getLogger(RegresstionTesting.class);
        PropertyConfigurator.configure("log4j.properties");	
        capture = new ScreenShotUtil();
        waitamoment = new implicitwaitmethod(driver);
        
       
	


		WebElement E_ClickSignIn = driver.findElement(By.className(proff.getProperty("HSignIn")));
	     if (E_ClickSignIn.isDisplayed()) {
	    	 Reporter.log("SignIn button is present.");
	    	 E_ClickSignIn.click();
		}else {
			Reporter.log("SignIn button is not present.");
			
		}
	    	
	    WebElement email = driver.findElement(By.id(proff.getProperty("EnterEmail")));
		if (email.isDisplayed()) {
			 Reporter.log("Email field is present.");
			email.sendKeys(excel.getdata(0, 1, 0));
		}else {
			Reporter.log("Email field is not present.");
		}
		
		WebElement clickweblink = driver.findElement(By.id(proff.getProperty("CAccount")));
		if (clickweblink.isDisplayed()) {
			Reporter.log("Create account link is present.");
			clickweblink.click();
		}else {
			Reporter.log("Create account link is not present.");
		}
		
		WebElement Radiobutton = driver.findElement(By.id(proff.getProperty("Titlename")));
		if (Radiobutton.isDisplayed()) {
			Reporter.log("Radio button is present.");
			Radiobutton.click();
		}else {
			Reporter.log("Radio button is not present.");
		}
		
		WebElement E_FirstName = driver.findElement(By.name(proff.getProperty("FirstName")));
		if (E_FirstName.isDisplayed()) {
			Reporter.log("First Name field is present.");
			E_FirstName.sendKeys(excel.getdata(0, 0, 1));
		}else {
			Reporter.log("First Name fiels is not present.");
		}
		
		WebElement E_LastName = driver.findElement(By.id(proff.getProperty("LastName")));
		if (E_LastName.isDisplayed()) {
			Reporter.log("Last Name field is present.");;
			E_LastName.sendKeys(excel.getdata(0, 0, 2));
		}else {
			Reporter.log("Last name fiels is not present.");
		}
		
		WebElement E_password = driver.findElement(By.id(proff.getProperty("password")));
		if (E_password.isDisplayed()) {
			Reporter.log("Password field is present.");
			E_password.sendKeys(excel.getdata(0, 1, 8));
		}else {
			Reporter.log("Password field is not present. ");
		}
		
		WebElement E_day = driver.findElement(By.xpath("//*[@id='days']"));
		if (E_day.isDisplayed()) {
			Reporter.log("Day is able to select .");
			E_day.sendKeys("1");
		}else {
			Reporter.log("Day is not able to select.");
		}
		
		WebElement E_month = driver.findElement(By.xpath("//*[@id='months']"));
		if (E_month.isDisplayed()) {
			Reporter.log("Month is able to select .");
			E_month.sendKeys("January");
		}else {
			Reporter.log("Month is not able to select .");
		}
		
		WebElement E_year = driver.findElement(By.id("years"));
		if (E_year.isDisplayed()) {
			Reporter.log("Year is able to select.");
			E_year.sendKeys("2016");
		}else {
			Reporter.log("Year is not able to select .");
		}
		
		WebElement E_newsletter = driver.findElement(By.name("newsletter"));
		if (E_newsletter.isDisplayed()) {
			Reporter.log("News letter check box is selected .");
			E_newsletter.click();
		}else {
			Reporter.log("News letter check box is not selected");
		}
		
		WebElement E_SpecialOffer = driver.findElement(By.name("optin"));
        if (E_SpecialOffer.isDisplayed()) {
        	Reporter.log("Special offer check box is selected");
        	E_SpecialOffer.click();
        }else {
			Reporter.log("Special offer check box is not able to select");
		}
        
        WebElement E_ClickRegister = driver.findElement(By.id("submitAccount"));
        if (E_ClickRegister.isDisplayed()) {
        	Reporter.log("Register link button is clicked. ");
        	E_ClickRegister.click();
		}else {
			Reporter.log("Register link button is not clicked.");
		}
                
        if (driver.getPageSource().contains("Your account has been created.")) {
        	System.out.println("Account has been created");
			
		}else {
			System.out.println("Account is not been created. ");
			
		}
        
        	if (driver.getPageSource().contains("Firstuser Firstuserlastlane")) {
				System.out.println("First & Last Name is displayed top right corner of the page. ");
			}else {
				System.out.println("First & Last Name is not displayed.");
			}
  
	}
	

}
