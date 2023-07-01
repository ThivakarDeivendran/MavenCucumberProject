package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPageClass {
	public WebDriver localdriver;

	public AddCustomerPageClass(WebDriver remoteDriver) {
		localdriver = remoteDriver;
		PageFactory.initElements(localdriver, this);
	}

	By customerLink = By.xpath("//nav[@class='mt-2']/ul/li[4]/a");
	By customerSubLink = By.xpath("//nav[@class='mt-2']/ul/li[4]/ul/li/a");
	By addButton = By.xpath("//div[@class='float-right']/a");

	By emailTextBox = By.xpath("//input[@id='Email']");
	By passwordTextBox = By.xpath("//input[@id='Password']");

	By firstNameTextBox = By.xpath("//input[@id='FirstName']");
	By lastNameTextBox = By.xpath("//input[@id='LastName']");

	By companyTextBox = By.xpath("//input[@id='Company']");

	By genderRatioButtonMale = By.xpath("//input[@id='Gender_Male']");
	By genderRatioButtonFemale = By.xpath("//input[@id='Gender_Female']");

	By dateOfBirthTextBox = By.xpath("(//span[@class='k-select'])[1]");
	By dateOfBirthYear = By.xpath("(//*[@class='k-header']/a)[2]");
	By previousMonthYearButton = By.xpath("//div[@class='k-header']/a[contains(@aria-label,'Previous')]");
	By dayOfBirth = By.xpath("//div[@class='k-calendar-view']/table/tbody/tr[3]/td[3]/a");///particular date for testing purpose
	By isTaxExempt = By.xpath("//input[@id='IsTaxExempt']");

	By newsLetter = By.xpath("(//div[@class='input-group'])[2]");
	By newsLetterStoryName = By.xpath("//select[@id='SelectedNewsletterSubscriptionStoreIds']/option");
	
	By customer =By.xpath("(//div[@class='form-group row'])[10]/div[2]/div/div/div");
	By customerRoles = By.xpath("//select[@id='SelectedCustomerRoleIds']/option");

	By managerVendor = By.xpath("//select[@id='VendorId']/option");

	By adminComment = By.tagName("textarea");
	By saveButton = By.xpath("//button[@name='save']");
	By newCustomerConfirmMessage = By.xpath("//div[@class='content-wrapper']/div");

	// Action Methods
	
	public String getPageTitle()
	{
		return localdriver.getTitle();
	}	
	public void customerLinkMenu() {
		localdriver.findElement(customerLink).click();
	}

	public void customerSubLinkMenu() {
		localdriver.findElement(customerSubLink).click();
	}

	public void addButtonMethod() {
		localdriver.findElement(addButton).click();
	}

	public void emailMethod(String emailAddress) {
		localdriver.findElement(emailTextBox).sendKeys(emailAddress);
	}

	public void passwordTextBoxMethod(String passwordAddress) {
		localdriver.findElement(passwordTextBox).sendKeys(passwordAddress);
	}

	public void firstNameMethod(String firstName) {
		localdriver.findElement(firstNameTextBox).sendKeys(firstName);
	}

	public void lastNameTextBoxMethod(String lastName) {
		localdriver.findElement(lastNameTextBox).sendKeys(lastName);
	}

	public void companyTextBoxMethod(String companyName) {
		localdriver.findElement(companyTextBox).sendKeys(companyName);
	}

	public void genderRatioButton(char gender) {
		if (gender == 'M') {
			localdriver.findElement(genderRatioButtonMale).click();
		} else {
			localdriver.findElement(genderRatioButtonFemale).click();
		}
	}

	public void dateOfBirth(String date) throws InterruptedException {
		localdriver.findElement(dateOfBirthTextBox).click();
//	    String monthYear=localdriver.findElement(dateOfBirthYear).getText();
//		String[] year =date.split("/");
//		if(!(year[2]).equals(monthYear.substring(10))) {
//			Thread.sleep(2000);
//			localdriver.findElement(previousMonthYearButton).click();
//		}
		Thread.sleep(2000);
		localdriver.findElement(dayOfBirth).click();
	}

	public void isTaxExemptMethod() {
		localdriver.findElement(isTaxExempt).click();
	}

	public void newsLetterStoryNameList(String story) {
		List<WebElement> listOfNewsLetterStoryName = localdriver.findElements(newsLetterStoryName);
		for (WebElement newsLetter : listOfNewsLetterStoryName) {
			if ((newsLetter.getText()).equals(story)) {
				newsLetter.click();
			}
		}
	}

	public void customerRolesList(String role) {
		List<WebElement> listOfcustomerRoles = localdriver.findElements(customerRoles);
		for (WebElement cusRole : listOfcustomerRoles) {
			if ((cusRole.getText()).equals(role)) {
				cusRole.click();
			}
		}
	}

	public void managerVendorList(String vendor) {
		List<WebElement> listOfManagerVendor = localdriver.findElements(managerVendor);
		for (WebElement manager : listOfManagerVendor) {
			if ((manager.getText()).equals(vendor)) {
				manager.click();
			}
		}
	}

	public void adminCommentMethod(String comment) {
		localdriver.findElement(adminComment).sendKeys(comment);
	}

	public void saveCustomerMethod() {
		localdriver.findElement(saveButton).click();
	}
	public String newCustomerConfrimationMessage(){
		return (localdriver.findElement(newCustomerConfirmMessage).getText()).trim();
		}
	}
