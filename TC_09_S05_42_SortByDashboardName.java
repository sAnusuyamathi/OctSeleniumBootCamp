package testNGBootCamp;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_09_S05_42_SortByDashboardName extends BaseClass {
	@Test
	public void runSortByDashboardName() throws InterruptedException {
		
		Thread.sleep(10000);
		driver.findElement(By.className("slds-icon-waffle")).click();
		
//			3. Click View All and click Dashboards from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//p[text()='Dashboards']")));
//		4. Click on the Dashboards tab 
		driver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[@title='Dashboards']")));
		Thread.sleep(10000);
//		List<WebElement> dashboardElements = driver.findElements(By.xpath("//tbody/tr/th[1]//a"));
//		System.out.println(dashboardElements.size());
		ArrayList<String> dNamesB4Sort = new ArrayList<String>();
		int i=1;
//		int size = dashboardElements.size();
		do {
		try {
			driver.findElement(By.xpath("//tbody/tr["+i+"]/th[1]//a")).sendKeys(Keys.PAGE_DOWN);
			
			String dashboardName = driver.findElement(By.xpath("//tbody/tr["+i+"]/th[1]//a")).getText();
			dNamesB4Sort.add(dashboardName);
			System.out.println(dashboardName);
			i=i+1;	
		}
		 catch (NoSuchElementException e) {
			break;
		}
		
		} while(true);
		System.out.println("Total Dashboards:"+i);
		Collections.sort(dNamesB4Sort);
		//	5. Click the sort arrow in the Dashboard Name.
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Dashboard Name']/ following-sibling::*[@class='slds-icon_container']")));
		//	6. Verify the Dashboard displayed in ascending order by Dashboard name.
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dashboard Name']/following::span[text()='Sorted Ascending']")));
		ArrayList<String> dNamesAfterSort = new ArrayList<String>();
		int nCount=0;
		do {
			try {
				driver.findElement(By.xpath("//tbody/tr["+i+"]/th[1]//a")).sendKeys(Keys.PAGE_DOWN);
				
				String dashboardName = driver.findElement(By.xpath("//tbody/tr["+i+"]/th[1]//a")).getText();
				dNamesAfterSort.add(dashboardName);
				System.out.println(dashboardName);
				i=i+1;	
			}
			 catch (NoSuchElementException e) {
				break;
			}
			
			} while(true);
	if(dNamesB4Sort.size()==dNamesAfterSort.size()) {
		for(i=0;i<dNamesB4Sort.size();i++) {
			if(dNamesB4Sort.get(i).equalsIgnoreCase(dNamesAfterSort.get(i))){
				nCount= 0;
			}
			else {
				nCount = nCount +1;
			}
		}
	}
	if(nCount==0) {
		System.out.println("Table sorted correctly");
	}
	}
}
