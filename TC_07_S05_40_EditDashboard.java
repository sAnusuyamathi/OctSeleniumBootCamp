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

public class TC_07_S05_40_EditDashboard extends BaseClass {
@Test
	public void runEditDashboard() throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//p[text()='Dashboards']")));
//		4. Click on the Dashboards tab 
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[@class='slds-truncate' and text()='Dashboards']")));
//		5. Search the Dashboard 'Salesforce Automation by Your Name'
		driver.findElement(By.xpath("//label[text()='Search recent dashboards...']/following::input[1]")).sendKeys("Salesforce Anu");
//		driver.executeScript("arguments[0].value='Salesforce Anu';", driver.findElement(By.xpath("//label[text()='Search recent dashboards...']/following::input[1]")));
		Thread.sleep(1000);
		builder.moveToElement(driver.findElement(By.xpath("//label[text()='Search recent dashboards...']/following::input[1]"))).click().perform();
//		Thread.sleep(10000);
//		wait.until(ExpectedConditions.)
//		driver.findElement(By.xpath("//label[text()='Search recent dashboards...']/following::input[1]")).sendKeys(Keys.ENTER);
//		builder.sendKeys(driver.findElement(By.xpath("//label[text()='Search recent dashboards...']/following::input[1]")), Keys.ENTER);		
//		6. Click on the Dropdown icon and Select Edit
//		for (int i = 2; i < driver.findElements(By.xpath("//table//tr[1]")).size() ; i++) {
//			System.out.println(driver.findElements(By.xpath("//table//tr[1]")).size());
//			WebElement descName = driver.findElement(By.xpath("//table//tr["+i+"]/th[1]//a[1]"));
//			if(descName.getText().contains("Anu1745"))
//			{
//				System.out.println("New Dashboard has been created successfully");
//				break;
//				
//			}
		Thread.sleep(10000);
		WebElement showEle = driver.findElement(By.xpath("//span[text()='Show actions']/ancestor::td[1]"));
		
		builder.moveToElement(showEle).click().perform();
		builder.moveToElement(driver.findElement(By.xpath("//span[text()='Edit']"))).click().perform();
		
//		7.Click on the Edit Dashboard Properties icon
		List<WebElement> nElements = driver.findElements(By.xpath("//iFrame"));
		System.out.println(nElements.size());
		WebElement frameEle = driver.findElement(By.xpath("//iFrame[1]"));
		driver.switchTo().frame(frameEle);
		Thread.sleep(25000);
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameEle));
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@title='Edit Dashboard Properties']")));
		
//		builder.moveToElement(driver.findElement(By.xpath("//button[@title='Edit Dashboard Properties']"))).click().perform();
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameEle));
		
//		8. Enter Description as 'SalesForce' and click on save.
		driver.findElement(By.id("dashboardDescriptionInput")).sendKeys("Salesforce");
		driver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//footer/button[text()='Save']")));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frameEle);
		
		Thread.sleep(10000);
		
		
//		9. Click on Done and  Click on save in the popup window displayed.
		builder.moveToElement(driver.findElement(By.xpath("//button[text()='Done']"))).click().perform();
//		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[text()='Done']")));
		Thread.sleep(10000);
		driver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//footer/button[text()='Save']")));
//		10. Verify the Description.
		String text = driver.findElement(By.xpath("//p[@class='slds-page-header__info'][1]")).getText();
		System.out.println(text);
		if(text.equals("Salesforce")) {
			System.out.println("Description is updated successfully");
		}
		
		
		
		
//		
//		
//		
//		
//		
//		
//		
//		driver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//div[@title='New Dashboard']")));
////			5. Enter Name as 'Salesforce Automation by Your Name ' and Click on Create.
//		Thread.sleep(10000);
////		driver.executeScript("arguments[0].value='Salesforce Automation by Anu';", driver.findElement(By.xpath("//div/input[@id='dashboardNameInput']")));
//		WebElement findEle = driver.findElement(By.xpath("//iFrame[1]"));
//		
////		System.out.println(findEle.size());
//		driver.switchTo().frame(findEle);
////		String frameTitle = frameEle.getAttribute("title");
//		driver.findElement(By.id("dashboardNameInput")).sendKeys("Salesforce Automation by Anu1745");
//		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[text()='Create']")));
////			6.Click on Save and Verify Dashboard name.
//		Thread.sleep(15000);
//		driver.switchTo().defaultContent();	
////		List<WebElement> nElements = driver.findElements(By.xpath("//iFrame"));
////		System.out.println(nElements.size());
//		driver.switchTo().frame(driver.findElement(By.xpath("//iFrame[1]")));
//		Thread.sleep(10000);
//		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[text()='Save']")));
////		Explicit wait
//		driver.switchTo().defaultContent();	
//		
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(2));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Dashboard saved']"))));
//		String saveText = driver.findElement(By.xpath("//span[text()='Dashboard saved']")).getText();
//		if(saveText.equals("Dashboard saved")) {
//			System.out.println("Dashboard saved successfully");
//		}
//		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[@class='slds-truncate' and text()='Dashboards']")));
//		System.out.println("Dashboard saved successfully");
//		List<WebElement> webTableElements = driver.findElements(By.xpath("//table//tr/th//a"));
//		for (WebElement tempEle : webTableElements) {
//			if(tempEle.getText().contains("Anu1745"))
//			{
//				System.out.println("New Dashboard with my name has been created successfully");
//				break;
//		
//			}
//		}
//		
//		//		Thread.sleep(10000);
////		for (int i = 2; i < driver.findElements(By.xpath("//table//tr[1]")).size() ; i++) {
////		System.out.println(driver.findElements(By.xpath("//table//tr[1]")).size());
////		WebElement descName = driver.findElement(By.xpath("//table//tr["+i+"]/th[1]//a[1]"));
////		if(descName.getText().contains("Anu1745"))
////		{
////			System.out.println("New Dashboard has been created successfully");
////			break;
////			
////		}
//		}
//		
//		
//		//			Expected Result:
////			The New Dashboard is created Successfully


	}


}
