package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	public OrganizationInfoPage(WebDriver driver) {             
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//span[contains(text(),'Information')]")
	  private WebElement successFullMsg;


	public String getSuccessFullMsg() {
		return successFullMsg.getText();
	}
}
