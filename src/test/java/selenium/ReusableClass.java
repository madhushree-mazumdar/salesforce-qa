package selenium;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
//import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReusableClass {
	static WebDriver driver;
	static ExtentReports report;
	protected static ExtentTest  logger;

	/*
	 * Name: InitializaDriver
	 * Description:Driver initialization.
	 * Arguments: ObjectName : Name of the object
	 * textValue: Value to be entered
	 * 
	 *  Created By: Madhushree
	 *  Creation Date: 21 March 2019
	 *  LAst Modified Date: 21 March 2019
	 * */
	public static void InitializeDriver() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
//		System.setProperty("webdriver.gecko.driver",  "C:\\Data\\Selenium\\geckodriver.exe");

		driver = new ChromeDriver();
//		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}
	/*
	 * Name: Launch
	 * Description: launching the page.
	 * Arguments: ObjectName : Name of the object
	 * textValue: Value to be entered
	 * 
	 *  Created By: Madhushree
	 *  Creation Date: 21 March 2019
	 *  LAst Modified Date: 21 March 2019
	 * */

	public static void Launch(String url, String name) {
		// open chrome browser with this url
		driver.get(url);
		driver.manage().window().maximize();
		logger = report.startTest(name);
	}
	/*
	 * Name: ReportGenerate
	 * Description: Report generating.
	 * Arguments: ObjectName : Name of the object
	 * textValue: Value to be entered
	 * 
	 *  Created By: Madhushree
	 *  Creation Date: 21 March 2019
	 *  LAst Modified Date: 21 March 2019
	 * */
	public static void ReportGenerate(String reporturl)
	{
		System.setProperty("selenium.root", "/Users/surajitpaul/Documents/Selenium");
		String root = System.getProperty("selenium.root");
		//Initialize Extent Report
		String path = root + reporturl;
		report = new ExtentReports(path);
		//logger = report.startTest("Login to SFDC");
	}
	/*
	 * Name: enterText
	 * Description: Enter the text value in to theText object on the page.
	 * Arguments: ObjectName : Name of the object
	 * textValue: Value to be entered
	 * 
	 *  Created By: Madhushree
	 *  Creation Date: 21 March 2019
	 *  LAst Modified Date: 21 March 2019
	 * */
	public static void enterText(WebElement obj, String objName, String textValue) {
		if(obj == null)
			return;
		if (obj.isDisplayed()) {
			obj.sendKeys(textValue);
			logger.log(LogStatus.PASS,objName + "entered sucessfully");
			System.out.println("Pass: " + textValue + " entered in " + objName);
		} else {
			logger.log(LogStatus.FAIL,objName +" does not exit");
			System.out.println("Fail: " + objName + " could not be found");
		}
	}
	/*
	 * Name: selectCheckBox
	 * Description: selecting checkbox.
	 * Arguments: ObjectName : Name of the object
	 * textValue: Value to be entered
	 * 
	 *  Created By: Madhushree
	 *  Creation Date: 21 March 2019
	 *  LAst Modified Date: 21 March 2019
	 * */
	
	public static void selectCheckBox(WebElement obj, String objName)
	{
		if(obj == null)
			return;
		if (obj.isDisplayed()) {
			if(!obj.isSelected())
			{
				obj.click();
			}
			logger.log(LogStatus.PASS,objName + "is selected");
			System.out.println("Pass: checkbox " + objName + " is selected");
		} else {
			logger.log(LogStatus.FAIL,objName + " could not be found");
			System.out.println("Fail: " + objName + " could not be found");
		}
	}
	/*
	 * Name: findElement
	 * Description: finding webelement.
	 * Arguments: ObjectName : Name of the object
	 * textValue: Value to be entered
	 * 
	 *  Created By: Madhushree
	 *  Creation Date: 21 March 2019
	 *  LAst Modified Date: 21 March 2019
	 * */
	
	public static WebElement findElement(By location,String objName)
	{
		WebElement obj = null;
		try {
			obj = driver.findElement(location);
			logger.log(LogStatus.PASS,objName + "found on the page.");
			System.out.println("Pass: " + objName + " found on the page.");
		} catch (NoSuchElementException errMessage) {
			logger.log(LogStatus.FAIL,objName + " could not be found");
			System.out.println("Fail: " + objName + " cound not be found on the page.");
		}
		return obj;
	}
	/*
	 * Name: clickButton
	 * Description: clicking button.
	 * Arguments: ObjectName : Name of the object
	 * textValue: Value to be entered
	 * 
	 *  Created By: Madhushree
	 *  Creation Date: 21 March 2019
	 *  LAst Modified Date: 21 March 2019
	 * */
	public static void clickButton(WebElement obj, String objName)
	{
		if(obj == null)
			return;
		if (obj.isDisplayed()) {
				obj.click();
			
			logger.log(LogStatus.PASS,objName + "is clicked");
			System.out.println("Pass: Button " + objName + " is clicked");
		} else {
			logger.log(LogStatus.FAIL,objName + " could not be found");
			System.out.println("Fail: " + objName + " could not be found");
		}
	}
	
	public static void frame(WebElement obj){
		driver.switchTo().frame(obj);
	}
	
	public static void backToPage(){
		driver.switchTo().defaultContent();
	}
	
	public static void mousehover(WebElement mousehover){
		Actions action = new Actions(driver);
		action.moveToElement(mousehover).build().perform();
	}
	
	public static void dragAndDrop(WebElement dragdrop){
		Actions action = new Actions(driver);
		action.dragAndDropBy(dragdrop, 100, 20);
	}
	
	public static void EndReport()
	{
		report.endTest(logger);
		report.flush();
		driver.quit();
	}


}
