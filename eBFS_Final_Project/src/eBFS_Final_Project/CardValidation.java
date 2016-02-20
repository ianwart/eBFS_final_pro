package eBFS_Final_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CardValidation {

	
	WebDriver driver;

	public CardValidation(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//*[@id='homefeatured']/li[2]/div/div[1]/div/a[1]/img")
	WebElement quickview;
	
	@FindBy(xpath="//*[@id='homefeatured']/li[2]/div/div[2]/div[2]/a[2]/span")
	WebElement morelink;
	
	/*@FindBy(xpath="//*[@id='our_price_display']")
	WebElement unitprice;*/
	
	@FindBy(xpath="//*[@id='quantity_wanted_p']/a[2]/span")
	WebElement changequantity;
	
	@FindBy(xpath="//*[@id='group_1']")
	WebElement ClickDropdownlist;
	
	@FindBy(xpath="//*[@id='group_1']")
	WebElement changesize;
	
	@FindBy(xpath="//*[@id='add_to_cart']/button")
	WebElement clickAdd;
	
	@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")
	WebElement ProceedCheckout;
	
	@FindBy(xpath="//*[@id='total_price']")
	WebElement TotalPrice;
		
			
		public void validatingcart(WebDriver driver) throws Exception{
			
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
		    	
			
			/*Assert.assertEquals(true, unitprice.isDisplayed());
			capture.getScreenshot(driver, "Displayed unitprice.");*/
			/*action.doubleClick(changequantity).sendKeys("2");
			action.click(changesize).sendKeys("M");
			action.click(clickAdd).click();
			action.click(ProceedCheckout);
			Assert.assertEquals(true, TotalPrice.isDisplayed());
			capture.getScreenshot(driver, "Displayed Totalprice.");*/
		}
		
		
	
		

}
