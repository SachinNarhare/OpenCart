package testPages;

import org.openqa.selenium.WebDriver;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class LoginPageMethod extends BaseClass {

	WebDriver driver;

	public LoginPageMethod(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage loginPage;
	public HomePageMethod homePageMethod;

	public void loginintoapplication() {

		loginPage = new LoginPage(driver);
		homePageMethod=new HomePageMethod(driver);
		loginPage.enterEmail(homePageMethod.email+"@gmail.com");
		loginPage.enterPassword(homePageMethod.password);
		loginPage.clickLogin();
	}

}
