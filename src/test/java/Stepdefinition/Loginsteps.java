package Stepdefinition;


import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.Loginpage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class Loginsteps{
private WebDriver driver;
private Loginpage logintest;






@Before
public void setUp() {
	System.setProperty("webdriver.chrome.driver", ".\\src\\test\\java\\Libraries\\chromedriver.exe");
	driver = new ChromeDriver();
	logintest = new Loginpage(driver);
	
	driver.manage().window().maximize();
	}
	
	@Given("I am on the login page")
	public void iAmOnTheLoginPage() {
		driver.get("https://practicetestautomation.com/practice-test-login/");}
	
	@When ("I enter username {string} and password {string}" )
	public void iEnterUsernameAndPassword(String username,String passsword) {
		logintest.enterUsername(username);
		logintest.enterPassword(passsword);
	}
	@And("I click on the login button")
	public void iClickOnLoginButto() {
		logintest.clickLoginButton();
	}
		@Then	("I should see the welcome message")
		public void welcomeMessage() {
			WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(logintest.getSuccessMessageLocator() ));
		String successMessage = logintest.getSuccessMessage();
		Assert.assertEquals ("Logged In Successfully", successMessage);
		System.out.println ("Login Sucessfull");
		}
@After
public void closeBrowser() {
	driver.quit();
}
}
	