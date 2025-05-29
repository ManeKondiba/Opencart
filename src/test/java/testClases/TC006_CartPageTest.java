package testClases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import testBase.BaseClass;

public class TC006_CartPageTest extends BaseClass {
	
	
	@Test
	public void verify_cartpage() {
		try {
		HomePage hp =new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLoginbtn();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		CartPage cp=new CartPage(driver);
		cp.clickonCart();
		String Prodtitle=cp.verify_shoppingcart();
		Assert.assertTrue(Prodtitle.contains("Shopping Cart"),"Not Found Shopping cart Page");
		System.out.println("PageTitle:"  +Prodtitle );
		
		
		
		//WebElement Quantity_cart=cp.getCartQuatntity();
		
		//Assert.assertTrue(Quantity_cart.isDisplayed(),  "");
		
		//System.out.println("Cart Quantity:" + Quantity_cart);
		
		
		
		/*Thread.sleep(3000);
		cp.Verfiy_CartQty_Update();
		boolean Update_msg=cp.clickonRefresh();
	
		Assert.assertEquals(Update_msg,"Success: You have modified your shopping cart!", "Cart Not Update Quantity");*/
				
		}catch(Exception e) {
			
			logger.error("Test failed due to exception: " + e.getMessage());
	        Assert.fail("Exception occurred: " + e.getMessage());
		}
		
		
	}
	
	
	
	
	

}
