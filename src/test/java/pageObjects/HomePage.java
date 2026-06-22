package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import testBase.BaseClass;

public class HomePage extends BaseClass{

	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	  }

	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;

	//By lnkMyaccount = By.xpath("//span[normalize-space()='My Account']");
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;

	@FindBy(css="#top > div > div > div.col.text-end > ul > li:nth-child(2) > div > ul > li:nth-child(2) > a")
	WebElement lnkLogin;
	
	public void clickMyAccount()
	{
		lnkMyaccount.click();
		extentTestChild.info("Clicked on My Account btn");
		Reporter.log("Clicked on My Account link", true);
	}

	public void clickRegister()
	{
	    lnkRegister.click();
	    extentTestChild.info("Clicked on Register btn");
	    Reporter.log("Clicked on Register link", true);
	}
	
	public void clickonLogin() {
		lnkLogin.click();
		extentTestChild.info("Clicked on Login btn");
		Reporter.log("Clicked on Login link", true);
	}

}
