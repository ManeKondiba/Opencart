package pageObject;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Searchfunction extends BasePage {

	public Searchfunction(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy(xpath="//input[@placeholder='Search']") WebElement txt_Search;
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']") WebElement btnSearch ;
	@FindBy(css = ".product-thumb h4 a")
    List<WebElement> productTitles;
	
	public void setSearchtxt(String Search){
		
		txt_Search.sendKeys(Search);
	}
	
	public void ClickonSearch() {
		btnSearch.click();
	}
	 
	public boolean isProductFound(String productName) {
        for (WebElement title : productTitles) {
            if (title.getText().toLowerCase().contains(productName.toLowerCase())) {
                return true;
            }
        }
        return false;
	
	
	}}

	
	
	
	
	
	
	
	
	
	

	
	
	
	


