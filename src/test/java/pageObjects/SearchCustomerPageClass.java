package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPageClass {
	public WebDriver localDriver;
	
	public SearchCustomerPageClass(WebDriver remoteDriver) {
		localDriver= remoteDriver;
		PageFactory.initElements(localDriver, this);
	}
	
	@FindBy(xpath="//input[@id='SearchEmail']")
	WebElement searchCustomerByEmail;
	
	@FindBy(id="SearchFirstName")
	WebElement searchCustomerByFirstName;
	
	
	@FindBy(id="SearchLastName")
	WebElement searchCustomerByLastName;
	
	@FindBy(id="search-customers")
	WebElement searchCustomerButton;
	
	@FindBy(xpath="(//div[@class='row'])[4]/div/div/div[2]/table/tbody/tr")
	List<WebElement> acutualEmailAddressResult;
	
	public void searchCustomerByEmailMethod(String customerEmailAddress) {
		searchCustomerByEmail.clear();
		searchCustomerByEmail.sendKeys(customerEmailAddress);
	}
	public void searchCustomerByFirstNameMethod(String customerFirstName) {
		searchCustomerByFirstName.clear();
		searchCustomerByFirstName.sendKeys(customerFirstName);
	}
	public void searchCustomerByLastNameMethod(String customerLastName) {
		searchCustomerByLastName.clear();
		searchCustomerByLastName.sendKeys(customerLastName);
	}
	public void searchCustomerButtonMethod() {
		searchCustomerButton.click();
	}
	public boolean acutualEmailAddressResultMethod() {
		boolean result = false;
			if(acutualEmailAddressResult.size()==1) {
				result =true;
			}else {
				result= false;
			}
		return result;
	}
}
