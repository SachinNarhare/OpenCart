package testCases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import testBase.BaseClass;
import testPages.HomePageMethod;

public class TC001_AccountRegistrationTest extends BaseClass{

	public HomePageMethod homePageMethod;
	
    @Test
    public void verify_account_registration()
    {
		extentTest = extentReports.createTest("Verify Account Registration Functionality");
		Reporter.log("Verify Account Registration Functionality",true);

		extentTest.assignCategory("Verify Account Registration Functionality");
    	
		homePageMethod = new HomePageMethod(driver);
		homePageMethod.createAndVerifyCustomerAccount();
		
    }
    

}
