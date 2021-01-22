package utilities;

import org.openqa.selenium.WebDriver;

import pageFactory.CreateorganizationPage;
import pageFactory.HomePage;
import pageFactory.Login;
import pageFactory.OrganizationInfoPage;
import pageFactory.OrganizationPage;

public class Base {

	public WebDriver driver;
	public FileUtility fUtil;
	public Login login;
	public HomePage homePage;
	public OrganizationPage orgPage;
	public CreateorganizationPage createOrgPage;
	public OrganizationInfoPage orgInfoPage;
}
