package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {

private WebDriver driver;
public Loginpage(WebDriver driver) {
	this.driver = driver;
}
//enter username
public void enterUsername (String username) {
	driver.findElement(By.id("username")).sendKeys(username);
}
//enter password
public void enterPassword (String password) {
	driver.findElement(By.id("password")).sendKeys(password);

}
//click on login button
public void clickLoginButton() {
	driver.findElement(By.id("submit")).click();
}
//Get success messgae
public String getSuccessMessage() {
	return driver.findElement(By.xpath("//h1[@class='post-title']")).getText();
}
public By getSuccessMessageLocator() {
	return By.xpath("//h1[@class='post-title']");

}
}

