package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.*;
import org.junit.*;

import pageObjects.AddCustomerPageClass;
import pageObjects.PageObjectManagerClass;
import pageObjects.LoginPageClass;
import pageObjects.SearchCustomerPageClass;

public class StepsLoginPageClass extends PageObjectManagerClass{
	
	@Given("^User launch the Chrome Browser$")
	public void user_launch_the_chrome_browser() {
		System.setProperty("Webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
		driver =new FirefoxDriver();
		loginpageclass= new LoginPageClass(driver);   
	}

	@When("^User opens URL {string}$")
	public void user_opens_url(String userURL) {
		driver.manage().window().maximize();
	    driver.get(userURL);
	}
	@When("^User enters Email as {string} and Password as {string}$")
	public void user_enters_email_as_and_password_as(String emailAddress, String userpassword) {
		loginpageclass.userEmail(emailAddress);
		loginpageclass.userPassword(userpassword);
	}

	@When("Click on login")
	public void click_on_login() {
	   loginpageclass.loginAction();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String homePageTitle) {
	   String pageActualTitle = driver.getPageSource();
	   if(pageActualTitle.contains("Login was unsuccessful.")) {
		   driver.close();
		   Assert.assertTrue(false);
	   }else {
		   Assert.assertEquals(homePageTitle, driver.getTitle());
	   }
	  
	}

	@When("User click on log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		loginpageclass.logoutAction();
		Thread.sleep(3000);
	
	}

	@Then("close browser")
	public void close_browser() {
	   driver.quit();
	}
	///Customers.feature step definitions
	@Then("User view the Dashboard")
	public void user_view_the_dashboard() {
		addcustomerpageclass =new AddCustomerPageClass(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addcustomerpageclass.getPageTitle());
	}
	@When("User click on Customers Menu")
	public void user_click_on_customers_menu() {
		addcustomerpageclass.customerLinkMenu();
	}
	@When("Click on Customer Menu Item")
	public void click_on_customer_menu_item() {
	  addcustomerpageclass.customerSubLinkMenu();
	}
	@When("Click on Add new button")
	public void click_on_add_new_button() {
	    addcustomerpageclass.addButtonMethod();
	}
	@Then("User can view Add new Customer page")
	public void user_can_view_add_new_customer_page() {
	    Assert.assertEquals("Add a new customer / nopCommerce administration", addcustomerpageclass.getPageTitle());
	}
	@When("User enters customer info")
	public void user_enters_customer_info() throws InterruptedException {
		addcustomerpageclass.emailMethod(randomEmailAddress()+"@gmail.com");
		addcustomerpageclass.passwordTextBoxMethod("thivakar12");
		addcustomerpageclass.firstNameMethod("Thivakar");
		addcustomerpageclass.lastNameTextBoxMethod("Deivendran");
		addcustomerpageclass.genderRatioButton('M');
		addcustomerpageclass.dateOfBirth("29/02/1999");
		addcustomerpageclass.companyTextBoxMethod("xyzCompany");
		addcustomerpageclass.isTaxExemptMethod();
		addcustomerpageclass.newsLetterStoryNameList("Test store 2");
		addcustomerpageclass.customerRolesList("Guests");
		addcustomerpageclass.managerVendorList("Vendor 2");
		addcustomerpageclass.adminCommentMethod("Testing Cucumber BDD");
	}
	
	
	@When("click on save button")
	public void click_on_save_button() {
	addcustomerpageclass.saveCustomerMethod();
	}
	@Then("User can view Confirmation message {string}")
	public void user_can_view_confirmation_message(String confrimMessage) {
		Assert.assertNotEquals(confrimMessage, (addcustomerpageclass.newCustomerConfrimationMessage()));
	}
	@When("Enter customer EMail as {string}")
	public void enter_customer_e_mail(String emailAddress) {
		searchcustomerpageclass = new SearchCustomerPageClass(driver);
		searchcustomerpageclass.searchCustomerByEmailMethod(emailAddress);
	}
	@When("Click the search button")
	public void click_the_search_button() {
		searchcustomerpageclass.searchCustomerButtonMethod();
	}
	@Then("User should found Email in the search table")
	public void user_should_found_email_in_the_search_table() {
	    Assert.assertNotEquals(true, searchcustomerpageclass.acutualEmailAddressResultMethod());	
	}
}
