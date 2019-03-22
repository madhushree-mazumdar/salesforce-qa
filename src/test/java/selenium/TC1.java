package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC1 extends ReusableClass {

	public static void main(String[] args) throws InterruptedException{
		InitializeDriver();
		String reportUrl = "/TC1.html";
		ReportGenerate(reportUrl);
		Launch("https://login.salesforce.com/","TestCase1");
		
		
		WebElement un = findElement(By.id("username"), "User Name");
		enterText(un, "User Name", "abc@techkarch.com");
		WebElement pass = findElement(By.xpath("//input[@id='password']"), "Password");
		enterText(pass, "Password", "xyz@1234");
		pass.clear();
		if(pass.getText().equals(""))
		{
			logger.log(LogStatus.PASS,"Password cleared sucessfully");
		}
		else
		{
			logger.log(LogStatus.FAIL,"Password not cleared");
		}
			
		Thread.sleep(2000);
	
		EndReport();
	}

}
