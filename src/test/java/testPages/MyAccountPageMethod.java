package testPages;

import org.openqa.selenium.WebDriver;

import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class MyAccountPageMethod extends BaseClass {

	WebDriver driver;

	public MyAccountPageMethod(WebDriver driver) {
		this.driver = driver;
	}

	public MyAccountPage myAccountPage;

	public boolean verifyLoginSuccess() {
		myAccountPage = new MyAccountPage(driver);
		return myAccountPage.isMyAccountPageExists();

	}
}
