package eBFS_Final_Project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class RegresstionTesting {

	ScreenShotUtil capture;
	WebDriver driver;
	//Logger logger;
	Properties pro = new Properties();
	FileInputStream input;	
	implicitwaitmethod waitdriver;
	
	ExtentReports reports;
	ExtentTest Logger;
	NewAccountWithvalidEmail User;
	MyaccountPage PersonalInfo;
	AccountWithInvalidEmail InvalidEmail;
	AccountWithRegisteredEmail RegisteredEmail;
    String	filepath = ("C:\\Users\\abull\\workspace\\eBFS_Final_Project\\src\\eBFS_Final_Project\\configuration.properties");
    
	public RegresstionTesting() throws Exception{
		
		
		input = new FileInputStream(filepath);
	    pro.load(input);
	    capture = new ScreenShotUtil();
	    waitdriver = new implicitwaitmethod(driver);
	   // localbrowser(pro.getProperty("ebrowser"));
	    /*logger = logger.getLogger(RegresstionTesting.class);
        PropertyConfigurator.configure("log4j.properties");*/
	}
	
	@BeforeTest
	public void vefore(){
		// new instance of reports
		reports= new ExtentReports("C:\\Users\\abull\\workspace\\eBFS_Final_Project\\Report\\data.html");	
		
	}
	
	@AfterTest
	public void After(){
		driver=new FirefoxDriver();
		driver.get("C:\\Users\\abull\\workspace\\eBFS_Final_Project\\Report\\data.html");
	}
	
	
	@Test(priority = 1, enabled = true)
	public void NewAccountWithInvalidEmail() throws Exception{
		Logger = reports.startTest("NewAccountWithInvalidEmail");
		InvalidEmail = new AccountWithInvalidEmail(driver);
		capture.getScreenshot(driver, "TC1: ");
		Logger.log(LogStatus.FAIL, "TC1: Create New account with invalid Email address.");
	}
	
	
	@Test(priority = 2, enabled = true)
	public void AlreadyRegisteredEmail() throws Exception{
		Logger = reports.startTest("AlreadyRegisteredEmail");
		RegisteredEmail =new AccountWithRegisteredEmail(driver);
		capture.getScreenshot(driver, "Error. This email already registered.");
		Logger.log(LogStatus.FAIL, "TC2: Create New account with already Registered Email address.");
	}
	
	
	@Test(priority = 3, enabled = true)
	public void Newuser() throws Exception{
		Logger = reports.startTest("Newuser");	
		User = new NewAccountWithvalidEmail(driver);
		Logger.log(LogStatus.PASS, "Test case 3: Create New account with valid Email address.");
		PersonalInfo = new MyaccountPage(driver);
		Logger.log(LogStatus.PASS, "Updated Last name & Provide current password.");
	}
	
		
	@Test(priority = 4, enabled = true)
	public void searkeyword() throws Exception{
		Logger = reports.startTest("searkeyword");
		ProductSearch searchitem =new ProductSearch(driver);
		Logger.log(LogStatus.PASS, "Shirt key word is present.");
		searchitem.entersearchkeyword(driver);
		Logger.log(LogStatus.PASS, "Search item is present.");
	}
	
	
	
	@Test (priority = 5, enabled = true)
	public void SearchFunctionality() throws Exception{
		Logger = reports.startTest("SearchFunctionality");
		ProductSearch search = new ProductSearch(driver);
		Logger.log(LogStatus.PASS, "Search ");
		
	}
	
	@Test(priority = 6, enabled = true )
	public void CartValidateFunctionality() throws Exception{
		Logger = reports.startTest("CartValidateFunctionality");
		CardValidation validcart = new CardValidation(driver);
		Logger.log(LogStatus.PASS, "Shopping card validated .");
		validcart.validatingcart(driver);
	}
	
	
	@Parameters("ebrowser")
	@BeforeMethod
	public void localbrowser(String ebrowser){
				
		if(ebrowser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Browserdriver\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if (ebrowser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		
		
		waitdriver.implicitwait(driver);
		driver.manage().window().maximize();
		driver.get(pro.getProperty("url"));
	
     	}	
	
	
    @AfterMethod
	public void CloseBrowser(ITestResult result) throws Exception 
       {
		if (result.getStatus() == ITestResult.FAILURE) {
		capture.getScreenshot(driver, result.getName());
					
	   }
		driver.quit();
		reports.endTest(Logger);
		
		//to write all logs to the report
		reports.flush();
		
	   }
	
	
		


}

