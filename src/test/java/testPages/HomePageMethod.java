package testPages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class HomePageMethod extends BaseClass {
	WebDriver driver;

	public HomePageMethod(WebDriver driver) {
		this.driver = driver;
	}

	public static String firstname;
	public static String lastname;
	public static String email;
	public HomePage homePage;
	public static String password;
	public AccountRegistrationPage accountRegistrationPage;
	public LoginPageMethod loginPageMethod;
	public MyAccountPageMethod myAccountPageMethod;

	public void createAndVerifyCustomerAccount() {

		extentTestChild = extentTest.createNode("Create and <b>Verify</b> Customer Account");
		extentTestChild.info("Create and Verify Customer Account");
		Reporter.log("Create and Verify Customer Account", true);

		homePage = new HomePage(driver);

		firstname = randomString().toUpperCase();
		extentTestChild.info("First Name is generated as: " + firstname);
		Reporter.log("First Name is generated as: " + firstname);

		lastname = randomString().toUpperCase();
		extentTestChild.info("Last Name is generated as: " + lastname);
		Reporter.log("Last Name is generated as: " + lastname);

		email = randomString();
		extentTestChild.info("Email is generated as: " + email);
		Reporter.log("Email is generated as: " + email);

		password = randomNumber();
		extentTestChild.info("Email is generated as: " + email);
		Reporter.log("Password is generated as: " + email);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		homePage.clickMyAccount();
		homePage.clickRegister();

		accountRegistrationPage = new AccountRegistrationPage(driver);

		accountRegistrationPage.enterFirstName(firstname);
		accountRegistrationPage.enterLastName(lastname);
		accountRegistrationPage.enterEmail(email + "@gmail.com");

		accountRegistrationPage.enterPassword(password);

		accountRegistrationPage.enablePrivacyPolicy();
		accountRegistrationPage.clickContinue();

		String confmsg = accountRegistrationPage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");

		try {
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
			extentTestChild.pass("Account creation message verified successfully. Actual: " + confmsg);
		} catch (AssertionError e) {
			extentTestChild.fail(
					"Account creation message verification failed. Expected: Your Account Has Been Created! | Actual: "
							+ confmsg);
			throw e;
		}
		homePage.clickMyAccount();
		homePage.clickonLogout();
	}

	public void loginInToApplication() {
		extentTestChild = extentTest.createNode("Login into application");
		extentTestChild.info("Login into application");
		Reporter.log("Login into application");

		homePage = new HomePage(driver);
		homePage.clickMyAccount();
		homePage.clickonLogin();

		loginPageMethod = new LoginPageMethod(driver);
		loginPageMethod.loginintoapplication();

		myAccountPageMethod = new MyAccountPageMethod(driver);

		try {
			Assert.assertTrue(myAccountPageMethod.verifyLoginSuccess());
			extentTestChild.pass("Customer successfully login");
		} catch (AssertionError e) {
			extentTestChild.fail("Customer successfully not login");
		}

	}
}
