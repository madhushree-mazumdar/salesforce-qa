package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class TC3 extends ReusableClass {

	public static void main(String[] args) {
		InitializeDriver();
		String reportUrl = "/TC3.html";
		ReportGenerate(reportUrl);
		Launch("https://login.salesforce.com/","TestCase3");
		
		WebElement un = findElement(By.id("username"), "User Name");
		enterText(un, "User Name", "231");
		WebElement pass = findElement(By.xpath("//input[@id='password']"), "Password");
		enterText(pass, "Password", "22131");
		WebElement login = findElement(By.xpath("//*[@id='Login']"), "Login");
		clickButton(login,"Login");
		WebElement error = findElement(By.id("error"),"Error");
		System.out.println(error.getText());
		String err = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		if(error.getText().equals(err))
		{
			logger.log(LogStatus.PASS,"Test case pass.");
		}
		else
		{
			logger.log(LogStatus.FAIL,"Test case failed.");
		}
		EndReport();
	}
}
