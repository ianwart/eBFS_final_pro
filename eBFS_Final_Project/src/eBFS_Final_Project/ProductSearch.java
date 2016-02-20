package eBFS_Final_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



public class ProductSearch {

	ExcelRead excel;
	ScreenShotUtil capture;
	
	public ProductSearch(WebDriver driver) throws Exception{
		PageFactory.initElements(driver, this);
		 capture = new ScreenShotUtil();
		 excel = new ExcelRead("C:\\TestData\\bfs.xlsx");
		
	}
	
	@FindBy(id="search_query_top")
	WebElement searchquery;
	
	@FindBy(name="submit_search")
	WebElement clicksearchlink;
	
	@FindBy(xpath="//*[@id='center_column']/h1/span[1]")
	WebElement verifySearchKeyword;
	
	@FindBy(xpath="//*[@id='best-sellers_block_right']/h4/a")
	WebElement topsellers;
	
	 @FindBy(className="icon-home")
	 WebElement homebutton;
	 	
	public void entersearchkeyword(WebDriver driver) throws Exception{
		searchquery.sendKeys(excel.getdata(0, 1, 9));
		clicksearchlink.click();
		
		if (driver.getPageSource().contains("Shirt")) {
			Reporter.log("Shirt keyword is present in the search result page. ");
			
			System.out.println("Search keyword is present");
		}else{
			Reporter.log("Shirt keyword is not present in the search result page. ");
			System.out.println("search keyword is not present.");
		}
		
		if (driver.getPageSource().contains("Top sellers")) {
			Reporter.log("Top Seller item is present in the left side on the page. ");
			System.out.println("Top sellers keyword is present. ");
		}else{
			Reporter.log("Top Seller item is not present in the left side on the page. ");
			System.out.println("Top sellers key word is not present.");
		}
		
		homebutton.click();
		Reporter.log("Home Button is clicked.  ");
		
		
	}
	
	/*public void validatingcart(WebDriver driver) throws Exception{
		
		Actions	action = new Actions(driver);
		
		action.moveToElement(quickview).build().perform();
		action.doubleClick(morelink).build().perform();
		Thread.sleep(5000);
		action.doubleClick(changequantity).perform();
	    action.doubleClick(ClickDropdownlist).perform();
	    Select size = new Select(driver.findElement(By.xpath("//*[@id='group_1']")));
        size.selectByIndex(2);
        clickAdd.click();
        ProceedCheckout.click();
	    if (driver.getPageSource().contains("$20.50")) {
			System.out.println("Unit price is $20.50. ");
		}else {
			System.out.println("Unit price is not displayed. ");
		}
        if (driver.getPageSource().contains("$41.00")) {
			System.out.println("Total price is showing $41.00 .");
		}else {
			System.out.println("Total price is not showing .");
		}
	    	*/
		
		/*Assert.assertEquals(true, unitprice.isDisplayed());
		capture.getScreenshot(driver, "Displayed unitprice.");*/
		/*action.doubleClick(changequantity).sendKeys("2");
		action.click(changesize).sendKeys("M");
		action.click(clickAdd).click();
		action.click(ProceedCheckout);
		Assert.assertEquals(true, TotalPrice.isDisplayed());
		capture.getScreenshot(driver, "Displayed Totalprice.");*/
	
	

}
