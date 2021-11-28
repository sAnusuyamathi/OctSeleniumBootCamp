package testNGBootCamp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_05_S05_35_DeleteLegalEntity extends BaseClass {
	@Test
	public void runDeleteEntity() throws InterruptedException {
		// TODO Auto-generated method stub
		//		4. Click on the legal Entities tab 
		Thread.sleep(15000);
		driver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//p[text()='Legal Entities']")));
//			5. Search the Legal Entity 'Salesforce Automation by Your Name'
		driver.executeScript("arguments[0].value='Salesforce Automation by Anu';",driver.findElement(By.xpath("//input[@placeholder='Search this list...']")));
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(Keys.ENTER);;
		Thread.sleep(15000);
//		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Salesforce Automation by Anu"+Keys.ENTER);
//		6. Click on the Dropdown icon and Select Edit
		Thread.sleep(10000);
		//a[@title='Show 2 more actions']
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']//tr[1]/td[5]//a")));
//		driver.executeScript("arguments[0].click;", driver.findElement(By.xpath("//tr[1]//td[5]//span[@class='slds-icon_container slds-icon-utility-down']")));

		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@title='Delete']")));
		
		Thread.sleep(10000);
		
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Delete']")));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']"))));
		if(driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText().contains("Legal Entity \"Salesforce Automation by Anu\" was deleted. ")){
			System.out.println("Legal entity is deleted");
		}
		}

}
