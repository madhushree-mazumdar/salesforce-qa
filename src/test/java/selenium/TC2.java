package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class TC2 extends ReusableClass {

	public static void main(String[] args) {
		InitializeDriver();
		String reportUrl = "/TC2.html";
		ReportGenerate(reportUrl);
		
		Launch("https://login.salesforce.com/","TestCase2");
		
		WebElement forgotpswd = findElement(By.xpath("//a[@class='fl small']"), "ForgotPassword");
		forgotpswd.click();
		
		WebElement un = findElement(By.xpath("//input[@id='un']"), "User Name");
		enterText(un, "User Name", "abc@techkarch.com");
		
		WebElement cont = findElement(By.xpath("//input[@id='continue']"), "Continue");

		clickButton(cont,"Continue");
		
		logger.log(LogStatus.PASS,"Password change link sent");
		
		EndReport();
	}
		

}
