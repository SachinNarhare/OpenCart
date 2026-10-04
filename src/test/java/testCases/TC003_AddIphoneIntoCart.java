package testCases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import testBase.BaseClass;

public class TC003_AddIphoneIntoCart extends BaseClass{

	
	@Test
	public void AddIphoneIntoCart() {
		extentTest=extentReports.createTest("Add and verify Iphone into cart");
		Reporter.log("Add and verify Iphone into cart",true);
		
		extentTest.assignCategory("Add and verify Iphone into cart");
	}
}
