package testClases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	

    @Test(groups={"Regression","Master"})
	public void verify_account_registration() throws InterruptedException {
    	try {
    	logger.info("****** Starting TC001_AccountRegistrationTest ******");
    	
		HomePage homepage =new HomePage(driver);
		
		homepage.clickMyAccount();
		logger.info(" Clicked on MyAccount.. ");
		
		homepage.clickRegister();
		logger.info(" Clicked on Registerlink.. ");
		
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info(" Providing Customers Details.. ");
		regpage.setFirstName(randomstring().toUpperCase());
		regpage.setLastName(randomstring().toUpperCase());
		regpage.setEmail(randomstring()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
	    String password	=randomAlphaNumberic();
	
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPolicy();
		regpage.clickContinue();
		
       logger.info("Validating expected message..");
		
		String confmsg = regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Confirmation message mismatch");

		logger.info("Test passed");
		} 
		catch (Exception e)
		{
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} 
		finally 
		{
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}
	
    }
	}








