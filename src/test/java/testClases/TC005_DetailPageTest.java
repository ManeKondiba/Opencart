package testClases;




import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ProductPage;
import pageObject.Searchfunction;
import testBase.BaseClass;

public class TC005_DetailPageTest extends BaseClass{
	
	@Test
	public void verify_cart() {
		
		logger.info("******Staring TC005_cartPageTest*******");
		
		try
		{
			
		HomePage hp =new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLoginbtn();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		Searchfunction sf =new Searchfunction(driver);
		driver.navigate().refresh();
		sf.setSearchtxt(p.getProperty("searchProductName"));
		sf.ClickonSearch();
		
		ProductPage pp =new ProductPage(driver);
		
		 pp.clickonproduct();
		 
		 String titletxt = pp.confirmDetailPage();
	     Assert.assertTrue(titletxt.contains("iPhone"), "Product title not match");
		 System.out.println("Title:"+titletxt);
			
		String cprice=pp.getProductPrice();
		Assert.assertEquals(cprice.toLowerCase(),"$123.20", "Price not Match" );
		System.out.println("price:"+cprice);
		
		pp.setQuantity();
		pp.ClickAddtoCart();
		
		String conmsg =pp.getConfirmationMsg();
		Assert.assertTrue(conmsg.contains("Success: You have added iPhone to your shopping cart!"), "Add to Cart failed!");
		//Assert.assertTrue(conmsg.contains("Success: You have added iPhone to your shopping cart!"), "Add to Cart failed!");
		System.out.println("Msg:"+conmsg);
		
		
		
	
		}catch(Exception e) {
			
			logger.error("Test failed due to exception: " + e.getMessage());
	        Assert.fail("Exception occurred: " + e.getMessage());
			
		}
	
	logger.info("******Finish TC005_cartPageTest*******");
	}
	
	

	

}
