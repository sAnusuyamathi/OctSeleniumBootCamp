package testNGBootCamp;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_06_S05_39_CreateNewDashboard extends BaseClass {
@Test
	public void runCreateNewDashboard() throws InterruptedException {
		// TODO Auto-generated method stub
		driver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//p[text()='Dashboards']")));
//			4. Click on the New Dashboard option
		driver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//div[@title='New Dashboard']")));
//			5. Enter Name as 'Salesforce Automation by Your Name ' and Click on Create.
		Thread.sleep(10000);
//		driver.executeScript("arguments[0].value='Salesforce Automation by Anu';", driver.findElement(By.xpath("//div/input[@id='dashboardNameInput']")));
		WebElement findEle = driver.findElement(By.xpath("//iFrame[1]"));
		
//		System.out.println(findEle.size());
		driver.switchTo().frame(findEle);
//		String frameTitle = frameEle.getAttribute("title");
		driver.findElement(By.id("dashboardNameInput")).sendKeys("Salesforce Anu");
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[text()='Create']")));
//			6.Click on Save and Verify Dashboard name.
		Thread.sleep(15000);
		driver.switchTo().defaultContent();	
//		List<WebElement> nElements = driver.findElements(By.xpath("//iFrame"));
//		System.out.println(nElements.size());
		driver.switchTo().frame(driver.findElement(By.xpath("//iFrame[1]")));
		Thread.sleep(10000);
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[text()='Save']")));
//		Explicit wait
		driver.switchTo().defaultContent();	
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Dashboard saved']"))));
		String saveText = driver.findElement(By.xpath("//span[text()='Dashboard saved']")).getText();
		if(saveText.equals("Dashboard saved")) {
			System.out.println("Dashboard saved successfully");
		}
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[@class='slds-truncate' and text()='Dashboards']")));
		System.out.println("Dashboard saved successfully");
		List<WebElement> webTableElements = driver.findElements(By.xpath("//table//tr/th//a"));
		for (WebElement tempEle : webTableElements) {
			if(tempEle.getText().contains("Salesforce Anu"))
			{
				System.out.println("New Dashboard with my name has been created successfully");
				break;
		
			}
		}
		
		//		Thread.sleep(10000);
//		for (int i = 2; i < driver.findElements(By.xpath("//table//tr[1]")).size() ; i++) {
//		System.out.println(driver.findElements(By.xpath("//table//tr[1]")).size());
//		WebElement descName = driver.findElement(By.xpath("//table//tr["+i+"]/th[1]//a[1]"));
//		if(descName.getText().contains("Anu1745"))
//		{
//			System.out.println("New Dashboard has been created successfully");
//			break;
//			
//		}
		}
		
		
		//			Expected Result:
//			The New Dashboard is created Successfully


	}


