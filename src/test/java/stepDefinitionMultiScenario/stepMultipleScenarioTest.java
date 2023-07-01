package stepDefinitionMultiScenario;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepMultipleScenarioTest {
	
		WebDriver multiScenarioDriver;

		@Given("^Need open one browser$")
		public void need_open_one_browser() {
		    WebDriverManager.chromedriver().setup();
		    ChromeOptions options = new ChromeOptions();
		    options.addArguments("--remote-allow-origins=*");
		    multiScenarioDriver = new ChromeDriver(options);
		    multiScenarioDriver.manage().window().maximize();
		    multiScenarioDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}

		@When("^Launch the application \"([^\"]*)\"$")
		public void launch_the_application(String browserURL) {
			multiScenarioDriver.get(browserURL);
		}

		@When("^Navigate to the next page$")
		public void navigate_to_the_next_page() {
			multiScenarioDriver.findElement(By.xpath("//div[@id='cssmenu']/ul/li/a")).click();
		}

		@When("^click the page link with proper system$")
		public void click_the_page_link_with_proper_system() throws InterruptedException {
			Thread.sleep(7000);
			multiScenarioDriver.findElement(By.xpath("//div[@id='uni_ctrl']/select")).click();
			multiScenarioDriver.navigate().back();
		}

		@Then("^close the browser$")
		public void close_the_browser() {
			multiScenarioDriver.quit();
		}


}
