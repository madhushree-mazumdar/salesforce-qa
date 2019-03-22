package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class TC5 extends ReusableClass {

	public static void main(String[] args) throws InterruptedException {
		InitializeDriver();
		String reportUrl = "/TC5.html";
		ReportGenerate(reportUrl);
		Launch("https://login.salesforce.com/","TestCase5");
		
		WebElement un = findElement(By.id("username"), "User Name");
		enterText(un, "User Name", "abc@techkarch.com");
		WebElement pass = findElement(By.xpath("//input[@id='password']"), "Password");
		enterText(pass, "Password", "xyz@1234");
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		clickButton(login,"Login");
		Thread.sleep(2000);
		WebElement menudrpdown = findElement(By.id("userNavLabel"),"Menu DropDown");
		clickButton(menudrpdown,"Menu DropDown");
		Thread.sleep(2000);
		
		WebElement myProfile = findElement(By.xpath("//a[@title='My Profile']"), "My Profile");
		logger.log(LogStatus.PASS,"My Profile is present");
		WebElement mySettings = findElement(By.xpath("//a[@title='My Settings']"), "My Settings");
		logger.log(LogStatus.PASS,"My Settings is present");
		WebElement developerConsole = findElement(By.xpath("//a[@title='Developer Console (New Window)']"), "Developer Console");
		logger.log(LogStatus.PASS,developerConsole+" is present");
		WebElement logOut = findElement(By.xpath("//a[@title='Logout']"), "Logout");
		logger.log(LogStatus.PASS,logOut+" is present");
		
 Thread.sleep(2000);
	    EndReport();
	}

}
