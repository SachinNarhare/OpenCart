package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{


    @Test
    public void verify_account_registration()
    {
		extentTest = extentReports.createTest("Verify Account Registration Functionality");
		Reporter.log("Verify Account Registration Functionality",true);

		extentTest.assignCategory("Verify Account Registration Functionality");
    	
		
		extentTestChild = extentTest.createNode("Create and <b>Verify</b> Customer Account");
		extentTestChild.info("Create and Verify Customer Account");
		Reporter.log("Create and Verify Customer Account", true);
		
    	HomePage hp=new HomePage(driver);
    	hp.clickMyAccount();
    	hp.clickRegister();
    	
    	AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
    	
    	regpage.setFirstName(randomString().toUpperCase());
    	regpage.setLastName(randomString().toUpperCase());
    	regpage.setEmail(randomString()+"@gmail.com");
    	
    	regpage.setPassword(randomNumber());
    	
    	regpage.setPrivacyPolicy();
    	regpage.clickContinue();
    	
    	String confmsg=regpage.getConfirmationMsg();
    	
    	Assert.assertEquals(confmsg, "Your Account Has Been Created!");
    	
    }
    

}
