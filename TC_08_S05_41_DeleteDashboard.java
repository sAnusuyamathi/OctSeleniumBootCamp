package testNGBootCamp;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_08_S05_41_DeleteDashboard extends BaseClass{
@Test
	public void runDeleteDashboard() throws InterruptedException {
		// TODO Auto-generated method stub
		driver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//p[text()='Dashboards']")));
//		4. Click on the Dashboards tab 
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[@class='slds-truncate' and text()='Dashboards']")));
//		5. Search the Dashboard 'Salesforce Automation by Your Name'
		driver.findElement(By.xpath("//label[text()='Search recent dashboards...']/following::input[1]")).sendKeys("Salesforce Anu");
//		driver.executeScript("arguments[0].value='Salesforce Anu';", driver.findElement(By.xpath("//label[text()='Search recent dashboards...']/following::input[1]")));
		Thread.sleep(1000);
		builder.moveToElement(driver.findElement(By.xpath("//label[text()='Search recent dashboards...']/following::input[1]"))).click().perform();

//		6. Click on the Dropdown icon and Select Delete
		Thread.sleep(10000);
		WebElement showEle = driver.findElement(By.xpath("//span[text()='Show actions']/ancestor::td[1]"));
		
		builder.moveToElement(showEle).click().perform();
		builder.moveToElement(driver.findElement(By.xpath("//span[text()='Delete']"))).click().perform();
		
//		7.Click on the Delete option in the displayed popup window.
		driver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[@title='Delete']")));
//		8. Verify Whether Dashboard is Deleted using Dashboard Name
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Dashboard was deleted.']"))));
		if(driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText().contains("Dashboard was deleted")) {
			System.out.println("Deleted successfully");
			driver.findElement(By.xpath("//label[text()='Search recent dashboards...']/following::input[1]")).clear();
//		Expected Result:
//		The Dashboard is deleted Successfully 
	}
		driver.findElement(By.xpath("//label[text()='Search recent dashboards...']/following::input[1]")).sendKeys("Salesforce Anu");
		if(driver.findElement(By.xpath("//span[@class='emptyMessageTitle']")).getText().contains("No results found")){
			System.out.println("No results found");
		
		}
	
	}
	}