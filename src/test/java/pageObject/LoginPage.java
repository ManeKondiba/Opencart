package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@name=\"email\"]") WebElement txtEmailAdress;
	
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Login']") WebElement btnlogin;
	
	public void setEmail(String email)
	{
		txtEmailAdress.sendKeys(email);
		
	}
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	public void clickLogin() {
		btnlogin.click();
	}
}
