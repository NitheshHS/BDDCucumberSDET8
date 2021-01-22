package hook;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.google.common.io.Files;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageFactory.Login;
import utilities.Base;
import utilities.FileUtility;

public class Hook extends Base {
	
	Base base;
	
	public Hook(Base base) {
		this.base=base;
	}
	
	@Before
	public void setUp() throws Throwable {
		base.fUtil=new FileUtility();
		if(base.fUtil.getPropertyKeyValue("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			base.driver=new ChromeDriver();
		}
		else if(base.fUtil.getPropertyKeyValue("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			base.driver=new FirefoxDriver();
		}
		base.driver.manage().window().maximize();
		base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		base.driver.get(base.fUtil.getPropertyKeyValue("url"));
		base.login=new Login(base.driver);
		base.login.login(base.fUtil.getPropertyKeyValue("username"), base.fUtil.getPropertyKeyValue("password"));
		
	}
	
	@After
	public void tearDown(Scenario scenario) throws Throwable {
		if(scenario.isFailed()) {
			EventFiringWebDriver event=new EventFiringWebDriver(base.driver);
			File src = event.getScreenshotAs(OutputType.FILE);
			File dest=new File(System.getProperty("user.dir")+"\\screenshot\\"+scenario.getName()+".PNG");
			Files.copy(src, dest);
			scenario.attach(event.getScreenshotAs(OutputType.BYTES), "image/png", scenario.getName());
		}
		base.driver.close();
	}
	
	
}
