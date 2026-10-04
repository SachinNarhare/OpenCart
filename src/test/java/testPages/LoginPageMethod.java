package testPages;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class LoginPageMethod extends BaseClass{
	
	public LoginPage loginPage;
	
	public void loginintoapplication() {
		
		loginPage=new LoginPage(driver);
		
		loginPage.clickLogin();
	}

}
