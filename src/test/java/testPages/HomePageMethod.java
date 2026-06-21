package testPages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class HomePageMethod extends BaseClass {
	 WebDriver driver;

    public HomePageMethod(WebDriver driver) {
    		this.driver = driver;
        }

		public HomePage homePage;
		public AccountRegistrationPage accountRegistrationPage;
		
		
		public void createAndVerifyCustomerAccount() {
			
		extentTestChild = extentTest.createNode("Create and <b>Verify</b> Customer Account");
		extentTestChild.info("Create and Verify Customer Account");
		Reporter.log("Create and Verify Customer Account", true);
		
		homePage= new HomePage(driver);
		
		String firstname=randomString().toUpperCase();
		extentTestChild.info("First Name is generated as: "+firstname);
		Reporter.log("First Name is generated as: "+firstname);
		
		String lastname=randomString().toUpperCase();
		extentTestChild.info("Last Name is generated as: "+lastname);
		Reporter.log("Last Name is generated as: "+lastname);
		
		String email=randomString();
		extentTestChild.info("Email is generated as: "+email);
		Reporter.log("Email is generated as: "+email);
		
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	homePage.clickMyAccount();
    	homePage.clickRegister();
    	
    	accountRegistrationPage=new AccountRegistrationPage(driver);
    	
    	accountRegistrationPage.setFirstName(firstname);
    	accountRegistrationPage.setLastName(firstname);
    	accountRegistrationPage.setEmail(email+"@gmail.com");
    	
    	accountRegistrationPage.setPassword(randomNumber());
    	
    	accountRegistrationPage.setPrivacyPolicy();
    	accountRegistrationPage.clickContinue();
    	
    	String confmsg=accountRegistrationPage.getConfirmationMsg();
    	Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	}
}
