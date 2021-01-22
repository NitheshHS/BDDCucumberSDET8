package stepDefinition;


import java.util.Random;

import org.testng.Assert;

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
	public void i_want_to_navigate_to_organization() {
	    base.homePage=new HomePage(base.driver);
	    base.homePage.getOrgLnk().click();
	}
	@Given("naviagate to create new organizationpage by click on +  image")
	public void naviagate_to_create_new_organizationpage_by_click_on_image() {
	   base.orgPage=new OrganizationPage(base.driver);
	   base.orgPage.getCreateOrgImg().click();
	   
	}
	@When("create a organization with madatory field {string}")
	public void create_a_organization_with_madatory_field(String string) {
		Random ran=new Random();
		orgName=string+ran.nextInt(1000);
	    base.createOrgPage=new CreateorganizationPage(base.driver); 
	    base.createOrgPage.creatOrganization(orgName);
	}
	@Then("I validate the Oraganization created or not")
	public void i_validate_the_oraganization_created_or_not() {
	   base.orgInfoPage=new OrganizationInfoPage(base.driver);
	   String info = base.orgInfoPage.getSuccessFullMsg();
	   Assert.assertTrue(false);
	   //info.contains(orgName)
	}

}
