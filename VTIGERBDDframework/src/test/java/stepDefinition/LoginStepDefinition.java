package stepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginStepDefinition {
	WebDriver driver;
	String orgname;
	@Given("I want to launch the browser")
	public void i_want_to_launch_the_browser() {
	   WebDriverManager.firefoxdriver().setup();
	    driver=new FirefoxDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("I will navigate to login page by entering the url {string}")
	public void i_will_navigate_to_login_page_by_entering_the_url(String url)  {
	  driver.get(url);
	}

	@When("I enter valid username {string} and password {string} and click on login button")
	public void i_enter_valid_username_and_password_and_click_on_login_button(String username, String password) {
	    driver.findElement(By.name("user_name")).sendKeys(username);
	    driver.findElement(By.name("user_password")).sendKeys(password);
	    driver.findElement(By.id("submitButton")).click();
	}

	@Then("I validate Home page is displayed or not {string}")
	public void i_validate_home_page_is_displayed_or_not(String homeTitle) {
	   Assert.assertEquals(homeTitle, driver.getTitle());
	}
	@Then("I signout from application")
	public void i_signout_from_application() {
		new Actions(driver).moveToElement(driver.findElement(By.xpath("//img[contains(@src,'/user.PNG')]"))).build().perform();
	    driver.findElement(By.linkText("Sign Out")).click();
	}
	
	@When("I will click on organization")
	public void i_will_click_on_organization() {
	    driver.findElement(By.linkText("Organizations")).click();
	}
	@When("In organization page I will click on create organization icon")
	public void in_organization_page_i_will_click_on_create_organization_icon() {
	    driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	}

	@When("I enter the organization name {string} and click on save button")
	public void i_enter_the_organization_name_and_click_on_save_button(String org) {
		orgname=org;
	    driver.findElement(By.name("accountname")).sendKeys(org);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
	@Then("I validate that organization name is displayed in the info or not")
	public void i_validate_that_organization_name_is_displayed_in_the_info_or_not() {
	   String orgInfo=driver.findElement(By.xpath("//span[contains(text(),'Information')]")).getText();
	   Assert.assertTrue(orgInfo.contains(orgname));
	}
	@When("I enter the invalid username and password")
	public void i_enter_the_invalid_username_and_password(DataTable dataTable) {
	   List<List<String>> data = dataTable.asLists(String.class);
	   driver.findElement(By.name("user_name")).sendKeys(data.get(0).get(0));//admin123
	    driver.findElement(By.name("user_password")).sendKeys(data.get(0).get(1));//password123
	    driver.findElement(By.id("submitButton")).click();
	}
	@Then("I validate that error message is displayed or not")
	public void i_validate_that_error_message_is_displayed_or_not() {
	    String errMsg=driver.findElement(By.xpath("//div[@class='errorMessage']")).getText();
	    Assert.assertEquals(errMsg, "You must specify a valid username and password.");
	    driver.close();
	}
}
