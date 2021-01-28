package stepDefinition;


import java.util.Random;

import org.testng.Assert;

import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageFactory.CreateorganizationPage;
import pageFactory.HomePage;
import pageFactory.OrganizationInfoPage;
import pageFactory.OrganizationPage;
import utilities.Base;

public class OraganizationStepDef extends Base{
	String orgName;
	Base base;
	public OraganizationStepDef(Base base) {
		this.base=base;
	}

	@Given("I want to navigate to organization")
	public void i_want_to_navigate_to_organization() throws ClassNotFoundException {
		base.feature=base.reports.createTest(Feature.class, "Oragnaization");
		base.scenario=base.feature.createNode(Scenario.class, " As a valid user I wnat to create an oraganization");
		base.scenario=base.feature.createNode(new GherkinKeyword("Given"),"I want to navigate to organization");
		base.homePage=new HomePage(base.driver);
		base.homePage.getOrgLnk().click();
	}
	@Given("naviagate to create new organizationpage by click on +  image")
	public void naviagate_to_create_new_organizationpage_by_click_on_image() throws Throwable {
		base.scenario.createNode(new GherkinKeyword("Given"), "naviagate to create new organizationpage by click on +  image");
		base.orgPage=new OrganizationPage(base.driver);
		base.orgPage.getCreateOrgImg().click();

	}
	@When("create a organization with madatory field {string}")
	public void create_a_organization_with_madatory_field(String string) throws Throwable {
		base.scenario.createNode(new GherkinKeyword("When"), "create a organization with madatory field "+string);
		Random ran=new Random();
		orgName=string+ran.nextInt(1000);
		base.createOrgPage=new CreateorganizationPage(base.driver); 
		base.createOrgPage.creatOrganization(orgName);
	}
	@Then("I validate the Oraganization created or not")
	public void i_validate_the_oraganization_created_or_not() throws Throwable {
		base.scenario.createNode(new GherkinKeyword("Then"),"I validate the Oraganization created or not");
		base.orgInfoPage=new OrganizationInfoPage(base.driver);
		String info = base.orgInfoPage.getSuccessFullMsg();
		Assert.assertTrue(info.contains(orgName));
		//info.contains(orgName)
	}

}
