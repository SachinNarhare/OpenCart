package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import testBase.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	  }

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmailAddress;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnLogin;

	public void setEmail(String email) {
		txtEmailAddress.sendKeys(email);
		extentTestChild.info("Email Entered: "+email);
		Reporter.log("Email Entered: "+email,true);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
		extentTestChild.info("Password Entered: "+pwd);
		Reporter.log("Password Entered: "+pwd,true);
	}

	public void clickLogin() {
		btnLogin.click();
		extentTestChild.info("Clicked on Login btn");
		Reporter.log("Clicked on Login btn",true);
	}

}
