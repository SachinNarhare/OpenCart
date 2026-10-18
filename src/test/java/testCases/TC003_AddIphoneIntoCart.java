package testCases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObjects.MyAccountPage;
import testBase.BaseClass;
import testPages.MyAccountPageMethod;

public class TC003_AddIphoneIntoCart extends BaseClass{

	public MyAccountPageMethod myAccountPageMethod;
	
	@Test
	public void AddIphoneIntoCartAndVerify() {
		extentTest=extentReports.createTest("Add and verify Iphone into cart");
		Reporter.log("Add and verify Iphone into cart",true);
		
		extentTest.assignCategory("Add and verify Iphone into cart");
		
		myAccountPageMethod=new MyAccountPageMethod(driver);
		myAccountPageMethod.addItemIntoCart("iPhone","Phones & PDAs");
		
	}
}
