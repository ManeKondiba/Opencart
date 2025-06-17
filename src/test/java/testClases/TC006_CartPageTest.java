package testClases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.CartPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.Searchfunction;
import testBase.BaseClass;

public class TC006_CartPageTest extends BaseClass {
	
	
	@Test(groups={"Master","Sanity","Regression"})
	public void verify_cartpage() {
		
		logger.info("******Staring TC005_cartPageTest*******");
		try {
		HomePage hp =new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLoginbtn();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();

	   CartPage cart = new CartPage(driver);
	   cart.Clickoncart();
	   cart.clickonview();
	   //check cartItem
	   System.out.println(cart.isItemDisplayed());
	   Thread.sleep(2000);
	   System.out.println(cart.getProductName());
	   Assert.assertEquals(cart.getProductName(),  "iPhone");
	   
	   //update cart quantity
	   cart.updateQuantity(p.getProperty("qty"));
	   String Upadate_msg=cart.verifyUpdatequatityMsg();
	   Assert.assertTrue(Upadate_msg.contains("Success: You have modified your shopping cart!"),
		        "Expected success message not found. Actual message: " + Upadate_msg);
	   
	   
	  //remove cart quantity
	        cart.removeItem();
	        System.out.println(cart.getEmptyCartMessage());
	        Thread.sleep(3000);
	       String  removeqty_msg=cart.getEmptyCartMessage();
	       Assert.assertTrue(removeqty_msg.contains("Your shopping cart is empty!"),"Expected alert message not found");
	   
	   
       
	   
		
		}
		catch(Exception e) {
			
			logger.error("Test failed due to exception: " + e.getMessage());
	        Assert.fail("Exception occurred: " + e.getMessage());
		}
		logger.info("******Finish TC005_cartPageTest*******");
		
	}

	
	
	
	

}
