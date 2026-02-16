package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import testBase.BaseClass;

public class Helper extends BaseClass{

	public String timeStamp() {
		DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy_MM_dd__hh_mm_ss");
		LocalDateTime now = LocalDateTime.now();
		return now.format(dft); 
	}
	public String dateFormater1()
	{
		
		Date date = new Date();
		
        SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
		String strDate =sdf.format(date);
	    currentDate =strDate;
	    Reporter.log("Current Date  : "+currentDate,true);
		return currentDate;
		
	}
	
	public static String captureScreenShots(WebDriver driver, String testName) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// String screenShotPath=
		// System.getProperty("user.dir")+"/Screenshots/"+""+testName+""+getCurretTimeStamp()+".png";
		String screenShotPath = System.getProperty("user.dir") + "/Screenshots/" + System.currentTimeMillis() + ".png";
		try {
			FileHandler.copy(src, new File(screenShotPath));
			System.out.println("ScreenShots Captured");
		} catch (IOException e) {
			System.out.println("Unable to capture screenshots" + e.getMessage());
		}
		return screenShotPath;
	}
	
}
