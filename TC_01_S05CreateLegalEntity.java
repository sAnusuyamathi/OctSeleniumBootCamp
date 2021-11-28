package testNGBootCamp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_01_S05CreateLegalEntity extends BaseClass {
	@Test(priority=1)
	public void runCreateLegalEntity() throws InterruptedException {
		// TODO Auto-generated method stub

//		4. Click on the legal Entities tab 
		Thread.sleep(15000);
		driver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//p[text()='Legal Entities']")));
//			4. Click on the Dropdown icon in the legal Entities tab
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[contains(text(),'Legal Entities Menu')]")));
//			5. Click on New Legal Entity
		driver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//span[contains(text(),'New Legal Entity')]")));
		
//			6. Enter Name as 'Salesforce Automation by Your Name'
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[text()='Name']/following::input[@class=' input'][1]")).sendKeys("Salesforce Automation by Anu");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[text()='Street']/following::textarea")).sendKeys("test");
		//			7.Click save and verify Legal Entity Name
		Thread.sleep(10000);
		driver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[@title='Save']")));
//			Expected Result:
//			The Legal Entity is created Successfully
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']"))));
		
		if(driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText().contains("Legal Entity \"Salesforce Automation by Anu\" was created. ")){
		System.out.println("Legal entity is created");
	}
	
		}
		}
