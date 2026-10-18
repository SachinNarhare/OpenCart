package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.openqa.selenium.interactions.Actions;

import testBase.BaseClass;

public class MyAccountPage extends BaseClass {

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#account-account > ul > li:nth-child(2) > a") // MyAccount Page heading
	WebElement accountTab;
	
	@FindBy(xpath="//div[@id='navbar-menu']//ul//li[6]")
	WebElement PhoneAndPDAs_btn;
	
	//Xpath to locate a product by its name
	public By productName(String productname) {
		return By.xpath( "//div[@id='product-list']//div//div//div[2]//div//h4//a[text()='"+productname+"']");
	}
	
	//Xpath to locate a tab name by its name 
	public By tabName(String tabname) {
		return By.xpath("//div[@id='navbar-menu']//li//a[text()='"+tabname+"']");
	}
	
	

	public boolean isMyAccountPageExists() {
		extentTestChild.info("Current tab name is: " + accountTab.getText());
		Reporter.log("Current tab name is: " + accountTab.getText(), true);
		try {
			return (accountTab.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}
	
	public void clickOnPhoneAndPDAsBtn() {
		PhoneAndPDAs_btn.click();
		extentTestChild.info("Click on Phone & PDAs btn");
		Reporter.log("Click on Phone & PDAs btn",true);
	
	}
	
	public void clickOnTabByItsName(String tabname) {
		driver.findElement(tabName(tabname)).click();
		
		extentTestChild.info("Click on "+tabname+" btn");
		Reporter.log("Click on "+tabname+" btn",true);
	}
	
	 // This method locate the product by its name provided
	public WebElement locatePrductByItsName(String productname) {
		
		//Action class used to scroll the webpage
		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 500).perform();
		
		WebElement productNameSpecified= driver.findElement(productName(productname));
		
		extentTestChild.info(productname+ "element located in webpage");
		Reporter.log(productname +"element located in webpage",true);
		
		return productNameSpecified;
	}
	

    // Click Add to Cart btn of the specified product name defined in testcase
    public void clickAddToCart(String productName){
    	WebElement cartBtn=locatePrductByItsName(productName).findElement(By.xpath(".//parent::h4//parent::div//parent::div//form//div//button[1]"));
    	cartBtn.click();
    	
    	extentTestChild.info("Clicked on "+productName+" add to cart btn");
    	Reporter.log("Clicked on "+productName+"add to ccart btn");
    	
    }
    
}
