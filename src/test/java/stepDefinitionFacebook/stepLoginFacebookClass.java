package stepDefinitionFacebook;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadingPropertiesFileClass;

public class stepLoginFacebookClass {
	public WebDriver driver;
	@Given("Launch the Browser")
	public void launch_the_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();   
	}

	@When("User enter the Facebook URL")
	public void user_enter_the_facebook_url() throws IOException {
		System.out.println("Testing   "+ReadingPropertiesFileClass.readingPropertyFile("FacebookURL"));
	   driver.get(ReadingPropertiesFileClass.readingPropertyFile("FacebookURL"));
	}

	@When("User enter the Username and Password")
	public void user_enter_the_username_and_password() throws InterruptedException {
	    driver.findElement(By.xpath("//input[@id='email']")).sendKeys("UserName");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("passWord");
	}

	@Then("User click the login button")
	public void user_click_the_login_button() throws InterruptedException, IOException {
		//driver.findElement(By.xpath("//button[@id='loginbutton']")).click();
		Thread.sleep(2000);
		driver.navigate().to(ReadingPropertiesFileClass.readingPropertyFile("SwaglabsURL"));
		driver.close();
	}
}
