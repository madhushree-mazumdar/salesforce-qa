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
	   
		clickButton(logout,"Menu button");
		WebElement logout1 = findElement(By.xpath("//a[@title='Logout']"),"Logout");
		
		clickButton(logout1,"Menu button");
		Thread.sleep(4000);
		WebElement text = findElement(By.xpath("//input[@id='username']"), "Username");
		String t = text.getText();
		System.out.println(t);
		String email = "mazumdar.madhushree@gmail.com";
		
		if(!t.isEmpty())
		{
		if(t.equals(email))
		{
			System.out.println("un.getText()");
			logger.log(LogStatus.PASS,"Remember me Checkbox clicked sucessfully");
		}
		else
		{
			System.out.println("un.getText()");
			logger.log(LogStatus.FAIL,"Remember me Checkbox not checked.");
		}
		}
		Thread.sleep(2000);
		EndReport();

	}

}
