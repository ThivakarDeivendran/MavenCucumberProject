package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageClass {
	public WebDriver localdriver;
	
	public LoginPageClass(WebDriver remotedriver){
		localdriver =remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	@FindBy(id="Email")
	@CacheLookup
	WebElement textEmail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement textPassword;
	
	@FindBy(xpath="//button[contains(text(),'Log in')]")
	@CacheLookup
	WebElement loginButton;
	
	@FindBy(xpath="//a[text()='Logout']")
	@CacheLookup
	WebElement logoutLink;
	
	public void userEmail(String emailAddress) {
		textEmail.clear();
		textEmail.sendKeys(emailAddress);	
	}
	public void userPassword(String userpassword) {
		textPassword.clear();
		textPassword.sendKeys(userpassword);
	}
	public void loginAction() {
		loginButton.click();
	}
	public void logoutAction() {
		logoutLink.click();
	}

}
