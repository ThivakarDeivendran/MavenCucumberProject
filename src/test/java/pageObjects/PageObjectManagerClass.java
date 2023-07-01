package pageObjects;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

public class PageObjectManagerClass {
	
	public WebDriver driver;
	public LoginPageClass loginpageclass;
	public AddCustomerPageClass addcustomerpageclass;
	public SearchCustomerPageClass searchcustomerpageclass;
	
	
	//method for generating unique E-mail address
	public static String randomEmailAddress()
	{
		String randomAlphabetic = RandomStringUtils.randomAlphabetic(5);
		return randomAlphabetic;
	}
}
