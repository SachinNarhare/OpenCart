package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import testBase.BaseClass;

public class AccountRegistrationPage extends BaseClass{

	    public AccountRegistrationPage(WebDriver driver){
	    	
			this.driver=driver;
			PageFactory.initElements(driver, this);
	    }

	    
	    @FindBy(xpath="//input[@id='input-firstname']")
	    WebElement txtFirstname;

	    @FindBy(xpath="//input[@id='input-lastname']")
	    WebElement txtLastname;

	    @FindBy(xpath="//input[@id='input-email']")
	    WebElement txtEmail;

	    @FindBy(xpath="//input[@id='input-password']")
	    WebElement txtPassword;

	    @FindBy(xpath="//input[@id='input-confirm']")
	    WebElement txtConfirmPassword;

	    @FindBy(css="#form-register > div > div > input")
	    WebElement chkPolicy;

	    @FindBy(css="#form-register > div > button")
	    WebElement btnContinue;

	    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	    WebElement msgConfirmation;

	    public void setFirstName(String fname) {
	        txtFirstname.sendKeys(fname);
	        extentTestChild.info("Entered First Name: "+fname);
	        Reporter.log("Entered First Name: "+fname, true);
	    }

	    public void setLastName(String lname) {
	        txtLastname.sendKeys(lname);
	        extentTestChild.info("Entered Last Name: "+lname);
	        Reporter.log("Entered Last Name: "+lname, true);
	    }

	    public void setEmail(String email) {
	        txtEmail.sendKeys(email);
	        extentTestChild.info("Entered Email: "+email);
	        Reporter.log("Entered Email: "+email, true);
	    }		

	    public void setPassword(String pwd) {
	        txtPassword.sendKeys(pwd);
	        extentTestChild.info("Entered Password: "+pwd);
	        Reporter.log("Entered Password: "+pwd, true);
	    }

	    public void setConfirmPassword(String pwd) {
	        txtConfirmPassword.sendKeys(pwd);
	        extentTestChild.info("Entered Confirm Password"+pwd);
	        Reporter.log("Entered Confirm Password"+pwd,true);;
	    }

	    public void setPrivacyPolicy() {
	        Actions a=new Actions(driver);
	        a.click(chkPolicy).build().perform();
	        extentTestChild.info("Check policy btn enabled");
	        Reporter.log("Check policy btn enabled",true);
	    }

	    public void clickContinue() {
	        //sol1
	        btnContinue.click();
	        extentTestChild.info("Clicked on continue btn");
	        Reporter.log("Clicked on continue btn",true);

	        //sol2
	        //btnContinue.submit();

	        //sol3
	        //Actions act = new Actions(driver);
	        //act.moveToElement(btnContinue).click().perform();

	        //sol4
	        //JavascriptExecutor js=(JavascriptExecutor)driver;
	        //js.executeScript("arguments[0].click();", btnContinue);

	        //sol5
	        //btnContinue.sendKeys(Keys.RETURN);

	        //sol6
	        //WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        //mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	    }

	    public String getConfirmationMsg() {
	        try {
	            return (msgConfirmation.getText());
	        } catch (Exception e) {
	            return e.getMessage();
	        }
	    }


}
