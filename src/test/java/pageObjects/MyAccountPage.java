package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class MyAccountPage extends BaseClass {

	public MyAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	  }

    @FindBy(xpath = "//h2[text()='My Account']")   // MyAccount Page heading
    WebElement msgHeading;

    
    public boolean isMyAccountPageExists() {
        try {
            return (msgHeading.isDisplayed());
        } catch (Exception e) {
            return false;
        }
    }
}
