package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='button-group']//i[@class='fa fa-shopping-cart']") WebElement btn_AddtoCart;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement txt_cartSuccessMsg;
	
	
	
	
	public void ClickAddtoCart()
	{
		
		btn_AddtoCart.click();
		
	}	
	
	public String getConfirmationMsg()
	{
		
		return txt_cartSuccessMsg.getText();
	}
}
