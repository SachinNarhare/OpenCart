package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver)
	{
	    super(driver);
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
	}

	public void clickRegister()
	{
	    lnkRegister.click();
	}
	
	public void clickonLogin() {
		lnkLogin.click();
	}

}
