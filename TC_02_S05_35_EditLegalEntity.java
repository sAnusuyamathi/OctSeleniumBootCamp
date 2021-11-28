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

public class TC_02_S05_35_EditLegalEntity extends BaseClass{
	@Test(priority=3)
	public void runEditLegalEntity() throws InterruptedException {
		// TODO Auto-generated method stub
//		4. Click on the legal Entities tab 
		Thread.sleep(15000);
		driver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//p[text()='Legal Entities']")));
//			5. Search the Legal Entity 'Salesforce Automation by Your Name'
//		driver.executeScript("arguments[0].value='Salesforce Automation by Anu';",driver.findElement(By.xpath("//input[@placeholder='Search this list...']")));
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Salesforce Automation by Anu");;
//		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(Keys.ENTER);;
		Thread.sleep(15000);
//		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Salesforce Automation by Anu"+Keys.ENTER);
//		6. Click on the Dropdown icon and Select Edit
		Thread.sleep(10000);
		//a[@title='Show 2 more actions']
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']//tr[1]/td[5]//a")));
//		driver.executeScript("arguments[0].click;", driver.findElement(By.xpath("//tr[1]//td[5]//span[@class='slds-icon_container slds-icon-utility-down']")));
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@title='Edit']")));
//		6. Enter the Company name as 'Testleaf'.
		driver.executeScript("arguments[0].value='Testleaf123';",driver.findElement(By.xpath("//span[text()='Company Name']/following::input")));
//		7. Enter Description as 'SalesForce'.
		driver.findElement(By.xpath("//span[text()='Description']/following::textarea")).sendKeys("SalesForce");
//		8. Select Status as 'Active'
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Status']/following::a[text()='--None--'][1]")));
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//li/a[text()='Active']")));
//		9. Click on Save &  Verify Status as Active
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Save']")));
		driver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[@title='Save']")));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']"))));
		if(driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText().contains("Legal Entity \"Salesforce Automation by Anu\" was saved. ")){
			System.out.println("Legal entity is edited");
		}
		
		}

}
