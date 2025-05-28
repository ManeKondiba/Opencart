package testClases;




import org.testng.Assert;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ProductPage;
import pageObject.Searchfunction;
import testBase.BaseClass;

public class TC005_CartPageTest extends BaseClass{
	
	
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
		sf.setSearchtxt(p.getProperty("searchProductName"));
		sf.ClickonSearch();
		
		ProductPage pp =new ProductPage(driver);
		pp.ClickAddtoCart();
		
		String conmsg =pp.getConfirmationMsg();
	Assert.assertTrue(conmsg.contains("Success: You have added iPhone to your shopping cart!"),"Add to Cart failed!");
	
		}catch(Exception e) {
			Assert.fail();
			
		}
	
	logger.info("******Finish TC005_cartPageTest*******");
	}
	
	

	

}
