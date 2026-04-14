package testBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ResourceCDN;
import org.testng.Reporter;
import utilities.Helper;

public class BaseClass {

public WebDriver driver;
public static ExtentReports extentReports;
public static ExtentHtmlReporter extentHtmlReporter;
public static Helper helper;
public static String currentDate;
public static ExtentTest extentTest;
public static ExtentTest extentTestChild;
public static SoftAssert testAssert;
public Properties properties;


	@BeforeSuite
	public void setUpSuite(ITestContext context) {
	    String suitname=context.getCurrentXmlTest().getSuite().getName();	      
		testAssert=new SoftAssert();
		helper = new Helper();
		if (extentReports == null) {
			
			extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports"+ "/" +"OPenCart-"+ suitname+  "-extent-report"+helper.timeStamp()+".html");
			extentHtmlReporter.config().setResourceCDN(ResourceCDN.EXTENTREPORTS);
			extentReports=new ExtentReports();
			extentReports.attachReporter(extentHtmlReporter);
			extentHtmlReporter.config().setDocumentTitle("OpenCart setDocumentTitle");
			extentHtmlReporter.config().setReportName("OpenCart setReportName");
		}
		helper.timeStamp();
		helper.dateFormater1();
		Reporter.log("****************Setting up reports and Test is getting ready*****************",true);
	}
	
	 @BeforeClass
    @Parameters({"os","browser"})
    public void setup(String os,String browser)
    {
    	//<--Note-->Properties file loading
    	try {
			FileReader file=new FileReader("./src\\test\\resources\\Config.properties");
	    	properties=new Properties();
	    	try {
				properties.load(file);
			} catch (IOException e) {e.printStackTrace();}
		} catch (FileNotFoundException e) {e.printStackTrace();}

    	
    	
    	switch(browser.toLowerCase()){
    	
    		case "chrome":	 driver = new ChromeDriver(); 
    		break;
    		
    		case "firefox": driver=new FirefoxDriver();
    		break;
    		
    		case "edge": driver=new EdgeDriver();
    		break;
    		
    		default: Reporter.log("Browser name is invalid",true);
    		return;
    	}
    	
       
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(properties.getProperty("applicationURL"));
        driver.manage().window().maximize();
    }	

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
    
    public String randomString() {
    	String generatestring=RandomStringUtils.randomAlphabetic(5);
    	return generatestring;
    }
    
    public String randomNumber() {
    	String generatenumber=RandomStringUtils.randomAlphanumeric(8);
    	return generatenumber;
    }
    
    @AfterMethod
	public void afterTest(ITestResult result) throws IOException {
		Reporter.log(
				"*******************************Test is about to end****************************************************",
				true);
		try {
			if (result.getStatus() == ITestResult.FAILURE) {
				Reporter.log("afterTest method if block-failure", true);
				extentTest.fail(
						"Test Failed Name -> " + result.getName() + "<br/>" + "Failed Test logs -> "
								+ result.getThrowable(),
						MediaEntityBuilder
								.createScreenCaptureFromPath(Helper.captureScreenShots(driver, result.getName()))
								.build());
			} else if (result.getStatus() == ITestResult.SKIP) {
				Reporter.log("afterTest method elseif block-skip", true);
				extentReports.removeTest(extentTest);
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				Reporter.log("afterTest method elseif block-SUCCESS", true);
			}
			extentReports.flush();
			testAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Exception in afterTest: " + e.getMessage(), true);
		} finally {
			Reporter.log("*******************************Test completed >> Reports Generated >> Report Project Path is "
					+ System.getProperty("user.dir"), true);
		}
	}
}
