package pageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage{

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	

@FindBy(xpath="//li[normalize-space()='Availability:Out Of Stock']") WebElement availability;
@FindBy(xpath="//h2[normalize-space()='$123.20']") WebElement price;
@FindBy(xpath="//input[@id='input-quantity']") WebElement qty;
@FindBy(xpath="//button[@id='button-cart']") WebElement btn_addToCart;
@FindBy(xpath="//div[contains(@class,'alert-success')]") WebElement successmsg;
@FindBy(xpath="//div[@class='caption']//a[contains(text(),'iPhone')]")WebElement productdetails;
	
@FindBy(xpath="//h1[normalize-space()='iPhone']") WebElement vfydetailspage;

@FindBy(xpath="//input[@id='input-quantity']") WebElement Qty;


	public void ClickAddtoCart()
	{
		
		btn_addToCart.click();
		
	}	
	
	public String getConfirmationMsg()
	{
		
		return successmsg.getText();
	}
	
	public String getProductPrice() {
		
		return price.getText();
	}
	
	public void clickonproduct() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", productdetails);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(productdetails)).click();
	    
}
	public String confirmDetailPage() {
		return vfydetailspage.getText();
		
	}
	 public void setQuantity() {
		 Qty.clear();
		 Qty.sendKeys("2");
	 }
}
	


	
	


