package testCases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import testBase.BaseClass;
import testPages.HomePageMethod;

public class TC002_LoginInToOpenCartWebApp extends BaseClass {
	
	public HomePageMethod homePageMethod;
	
	@Test 
	public void loginintoapp() {
		
		extentTest=extentReports.createTest("Verify customer logged in successfully into OpenCart WebApp");
		Reporter.log("Verify customer logged in successfully into OpenCart WebApp",true);
		
		extentTest.assignCategory("Verify login functionality");
		
		homePageMethod=new HomePageMethod(driver);
		homePageMethod.loginInToApplication();
	}
    

}
