package pageObject;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CartPage extends BasePage{

	public CartPage(WebDriver driver) {
		super(driver);
	}


	
	@FindBy(xpath= "//table[contains(@class, 'table')]/tbody/tr/td[4]//input[contains(@name, 'quantity')]") WebElement quantityField;
	@FindBy(xpath="//button[@type='submit']")  WebElement updateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement UpdateAlert;
	@FindBy(xpath = "//div[@id='content']//table//tbody/tr/td[2]/a") WebElement productName;
	@FindBy(xpath="//button[@type='button']//i[@class='fa fa-shopping-cart']") WebElement CartPage;
	@FindBy(xpath="//strong[normalize-space()='View Cart']") WebElement Cartview;
	@FindBy(xpath= "//i[@class='fa fa-times-circle']") WebElement removeButton;
	@FindBy(linkText = "Checkout")WebElement checkoutButton;
	@FindBy(css = "#content p") WebElement emptyCartMessage;
	 @FindBy(css = ".table-responsive tbody tr")  WebElement cartItems;
	   
	
	public void Clickoncart() {
		CartPage.click();
	}
	
	public void clickonview() {
		Cartview.click();
	}
	
	
	
	
	 public boolean isItemDisplayed() {
	        return cartItems.isDisplayed();
	 }
	 
	   public String getProductName() {
	        return productName.getText();
	    }

	    public void updateQuantity(String qty) {
	        quantityField.clear();
	        quantityField.sendKeys(qty);
	        updateButton.click();
	    }
	        public String verifyUpdatequatityMsg() {
	        	return UpdateAlert.getText();
	    }
	    
	    public void removeItem() {
	        removeButton.click();
	    }

	    public void proceedToCheckout() {
	        checkoutButton.click();
	    }

	    public String getEmptyCartMessage() {
	        return emptyCartMessage.getText();
	    }

	    public boolean isCartEmpty() {
	        return driver.getPageSource().contains("Your shopping cart is empty!");
	    }
	}
		
		
		
		
		
		
		
		
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


