package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class TC4 extends ReusableClass {

	public static void main(String[] args) throws InterruptedException {
		InitializeDriver();
		String reportUrl = "/TC4.html";
		ReportGenerate(reportUrl);
	
		Launch("https://login.salesforce.com/","TestCase4");
		
		WebElement un = findElement(By.id("username"), "User Name");
		enterText(un, "User Name", "abc@techkarch.com");
		WebElement pass = findElement(By.xpath("//input[@id='password']"), "Password");
		enterText(pass, "Password", "xyz@1234");
		
		WebElement run = findElement(By.xpath("//*[@id='rememberUn']"),"Remember Me");
		selectCheckBox(run, "Remember Me");
		
		WebElement login = findElement(By.xpath("//*[@id='Login']"),"Login");
		
		clickButton(login,"Login");
		Thread.sleep(2000);
		
		WebElement logout = findElement(By.xpath("//div[@class='userNav-buttonArrow mbrButtonArrow']"),"Logout");   
		clickButton(logout,"Log Out");
		WebElement logout1 = findElement(By.xpath("//a[@title='Logout']"),"Logout");
		clickButton(logout1,"Log Out");
		Thread.sleep(4000);
		WebElement text = findElement(By.xpath("//input[@id='username']"), "Username");
		String t = text.getText();
		System.out.println( "email: "+t);
		String email = "abc@techkarch.com";
		
		if(!t.isEmpty())
		{
		if(t.equals(email))
		{
			System.out.println("Email: "+text.getText());
			logger.log(LogStatus.PASS,"correct email id");
		}
		else
		{
			System.out.println("Email: "+text.getText());
			logger.log(LogStatus.FAIL,"In correct email id.");
		}
		}
		Thread.sleep(2000);
		EndReport();

	}

}
