package testNGBootCamp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_10_S05_43_DashboardSubscribe extends BaseClass {
	@Test
	public void runDashboardSubscribe() throws InterruptedException {
		// TODO Auto-generated method stub
		
//			2. Click on the toggle menu button from the left corner
		driver.findElement(By.className("slds-icon-waffle")).click();
		
//			3. Click View All and click Dashboards from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//p[text()='Dashboards']")));
//		5. Search the Dashboard 'Salesforce Automation by Your Name'
//		6. Click on the Dropdown icon and Select Subscribe
		int i=1;
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='slds-truncate' and text()='Dashboards']")));
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[@class='slds-truncate' and text()='Dashboards']")));
		driver.findElement(By.xpath("//label[text()='Search recent dashboards...']/following::input[1]")).sendKeys("Salesforce Anu");
		Thread.sleep(1000);
		builder.moveToElement(driver.findElement(By.xpath("//label[text()='Search recent dashboards...']/following::input[1]"))).click().perform();
		if(driver.findElements(By.xpath("//tbody/tr")).size() > 0) {
			WebElement sElement = driver.findElement(By.xpath("//span[text()='Show actions']/ancestor::td[1]"));
			builder.moveToElement(sElement).click().perform();
			builder.moveToElement(driver.findElement(By.xpath("//span[text()='Subscribe']"))).click().perform();
		
		}
//		do {
//			try {
//				
//				String dashboardName = driver.findElement(By.xpath("//tbody/tr["+i+"]/th[1]//a")).getText();
//				if(dashboardName.equalsIgnoreCase("Salesforce Anu")) {
//					WebElement sElement = driver.findElement(By.xpath("//span[text()='Show actions']/ancestor::td["+i+"]"));
//					builder.moveToElement(sElement).click().perform();
//					builder.moveToElement(driver.findElement(By.xpath("//span[text()='Subscribe']"))).click().perform();
//					break;
//				}
////				System.out.println(dashboardName);
//				i=i+1;	
//				driver.findElement(By.xpath("//tbody/tr["+i+"]/th[1]//a")).sendKeys(Keys.PAGE_DOWN);
//			}
//			 catch (NoSuchElementException e) {
//				break;
//			}
//			
//			} while(true);
//		driver.findElement(By.xpath("//label[text()='Search recent dashboards...']/following::input[1]")).sendKeys("Salesforce Anu");
// 	Verify 'Weekly' is selected by default
//		String cssValue = driver.findElement(By.xpath("//span[text()='Weekly']")).getCssValue("color");
//		System.out.println(cssValue);
//		7. Select frequency as 'Daily' and Click on Save in the Edit Subscription popup window. 
		Thread.sleep(10000);
		builder.moveToElement(driver.findElement(By.xpath("//span[text()='Daily']"))).click().perform();
		Thread.sleep(10000);
		WebElement ddEle = driver.findElement(By.xpath("//select[@class=' select']"));
		Select ddTime = new Select(ddEle);
		System.out.println(ddTime.getOptions().size());
		ddTime.selectByValue("4");
		builder.moveToElement(driver.findElement(By.xpath("//button[@title='Save']"))).click().perform();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(@data-aura-class,'forceActionsText')]")));
		if(driver.findElement(By.xpath("//span[contains(@data-aura-class,'forceActionsText')]")).getText().contains("You started a dashboard subscription.")){
			System.out.println("Subscribed successfully");
			driver.close();
		}
//		8.Verify Whether the dashboard is subscribed.
//		Expected Result:
//		Dashboards should be subscribed Successfully
	
	
	}
}
