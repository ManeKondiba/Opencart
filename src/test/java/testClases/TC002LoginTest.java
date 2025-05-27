package testClases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC002LoginTest extends BaseClass {
	
	@Test(groups={"Sanity","Master"})
	
public void verify_login() {
		
		logger.info("******Staring TC002_Logintest*******");
		
		try{
			HomePage hp=new HomePage(driver);
		
				hp.clickMyAccount();
		        hp.clickLoginbtn();
		        
		        
		   LoginPage lp=new LoginPage(driver) ;
		   lp.setEmail(p.getProperty("email"));
		   lp.setPassword(p.getProperty("password"));
		   lp.clickLogin();
		   
	      MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage  = macc.isMyAccountPageExist();
	
		Assert.assertTrue(targetPage);
		
	}
		catch(Exception e) {
			
		Assert.fail();
		
}
		logger.info("*** Finished TC002 LoginTest**");
	}
}
