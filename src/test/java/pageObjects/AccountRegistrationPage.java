package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AccountRegistrationPage extends BasePage{

	    public AccountRegistrationPage(WebDriver driver){
	    	
	        super(driver);
	        //this.driver = driver;  
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
	        Reporter.log("Entered First Name: "+fname, true);
	    }

	    public void setLastName(String lname) {
	        txtLastname.sendKeys(lname);
	        Reporter.log("Entered Last Name: "+lname, true);
	    }

	    public void setEmail(String email) {
	        txtEmail.sendKeys(email);
	        Reporter.log("Entered Email: "+email, true);
	    }		

	    public void setPassword(String pwd) {
	        txtPassword.sendKeys(pwd);
	        Reporter.log("Entered Password: "+pwd, true);
	    }

	    public void setConfirmPassword(String pwd) {
	        txtConfirmPassword.sendKeys(pwd);
	        Reporter.log("Entered Confirm Password"+pwd,true);;
	    }

	    public void setPrivacyPolicy() {
	        Actions a=new Actions(driver);
	        a.click(chkPolicy).build().perform();
	        Reporter.log("Check policy btn enabled",true);
	    }

	    public void clickContinue() {
	        //sol1
	        btnContinue.click();
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
