package testPages;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

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
	
	public void addItemIntoCart(String productname,String tabname) {
		extentTestChild = extentTest.createNode("Add "+productname+" into cart");
		extentTestChild.info("Add "+productname+" into cart");
		Reporter.log("Add "+productname+" into cart",true);
		
		myAccountPage=new MyAccountPage(driver);
		myAccountPage.clickOnTabByItsName(tabname);
		//myAccountPage.clickOnPhoneAndPDAsBtn();
		myAccountPage.clickAddToCart(productname);
	}
}
