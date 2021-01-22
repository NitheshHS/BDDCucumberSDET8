package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Nitheesha
 *
 */
public class Login {
		WebDriver driver;

		public Login(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(name="user_name")
		private WebElement usernameTF;
		
		@FindBy(name="user_password")
		private WebElement passwordTF;
		
		@FindBy(id="submitButton")
		private WebElement loginBTN;

		public WebElement getUsernameTF() {
			return usernameTF;
		}

		public WebElement getPasswordTF() {
			return passwordTF;
		}

		public WebElement getLoginBTN() {
			return loginBTN;
		}
		
		public void login(String username,String password) {
			usernameTF.sendKeys(username);
			passwordTF.sendKeys(password);
			loginBTN.click();
			
		}
		

}
