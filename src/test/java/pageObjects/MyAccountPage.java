package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import testBase.BaseClass;

public class MyAccountPage extends BaseClass {

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#account-account > ul > li:nth-child(2) > a") // MyAccount Page heading
	WebElement accountTab;

	public boolean isMyAccountPageExists() {
		extentTestChild.info("Current tab name is: " + accountTab.getText());
		Reporter.log("Current tab name is: " + accountTab.getText(), true);
		try {
			return (accountTab.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}
}
