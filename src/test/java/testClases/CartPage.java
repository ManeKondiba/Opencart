package testClases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObject.BasePage;

public class CartPage extends BasePage{

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[@title='Shopping Cart']//i[@class='fa fa-shopping-cart']") WebElement CartIcon;
	@FindBy(xpath="//h1[contains(text(),'Shopping Cart')]") WebElement ShoppingCart;
	@FindBy(xpath="//input[@name='quantity[268010]']") WebElement UpdateQty;

	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement UpdateMsg;
	@FindBy(xpath="//button[@type='submit']") WebElement btn_Update;  
	@FindBy(xpath="//span[@id='cart-total']")WebElement CartQty;
	
	public void clickonCart() {

		
		CartIcon.click();
		}
	
	public String verify_shoppingcart() {
		
		return ShoppingCart.getText();
		
	}
		
		public void Verfiy_CartQty_Update() throws InterruptedException {
			UpdateQty.click();
			UpdateQty.clear();
			Thread.sleep(5000);
			UpdateQty.sendKeys("1");
			
			
		}
		public void verify_QtyUpdateMsg() {
			
			UpdateMsg.getText();
			
		}
		
		public boolean clickonRefresh() {
		
			btn_Update.click();
			return true;
		
		} public WebElement getCartQuatntity() {
			
			CartQty.getText();
			return CartQty;
			
		}
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


