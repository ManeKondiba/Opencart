package testClases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.Searchfunction;
import testBase.BaseClass;

public class TC004_SearchFunctionalityTest extends BaseClass {
	
	
	
	
	
	@Test(groups={"Regression","Sanity","Master"})
	public void SearchProduct() {
		logger.info("******Staring TC004_SearchFunctinalityTest*******");
		
		try{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLoginbtn();
		
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		logger.info("Login successful");
		Searchfunction sf=new Searchfunction(driver);
		sf.setSearchtxt(p.getProperty("searchProductName"));
		sf.ClickonSearch();
		
		logger.info("validate valide product");
		
		Assert.assertTrue(sf.isProductFound("iphone"), "Valid product found!");
		
		
	        sf.setSearchtxt("abc123xyz");
	        sf.ClickonSearch();
	        
	        logger.info("validate Invalide product");
	        Assert.assertFalse(sf.isProductFound("abc123xyz"), "Invalid product should not be found!");
	    

		
		
				
		}
		catch(Exception e) {
			logger.error("Test failed due to exception: " + e.getMessage());
	        Assert.fail("Exception occurred: " + e.getMessage());
		
		}
		
		logger.info("******Finish TC004_SearchFunctinalityTest*******");
		
		
	}
	 

}
