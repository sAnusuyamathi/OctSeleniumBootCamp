package testNGBootCamp;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_11_S05_88_CreateCampaign extends BaseClass {
	@Test
	public void runCreateCampaign() throws InterruptedException {
//		String cName = "Anu";
//		System.out.println("Campaign \""+cName+"\" was created.");
		
		driver.findElement(By.className("slds-icon-waffle")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
//		 Click on Campaigns tab 
		Thread.sleep(15000);
		driver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//p[text()='Campaigns']")));
//		 5. Click on New button
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@title='New']")));
//		 6. Enter Campaign name as 'Bootcamp',Get the text and Store it 
//		driver.executeScript("arguments[0].value='BootCamp Anu'", driver.findElement(By.xpath("//label[@data-aura-class='uiLabel']/span[text()='Campaign Name']/following::input[1]")));
		Thread.sleep(10000);
		driver.findElement(By.xpath("//label[@data-aura-class='uiLabel']/span[text()='Campaign Name']/following::input[1]")).sendKeys("Bootcamp Anu");
		
	
//		 7. Choose Start date as Tomorrow
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);
		System.out.println(currentDate.getDayOfMonth());
		System.out.println(currentDate.getDayOfYear());
		System.out.println(currentDate.getDayOfWeek().plus(1));
		System.out.println(currentDate.getMonth());
		System.out.println(currentDate.plusDays(1).getDayOfMonth());
		int dayOfMonth = currentDate.plusDays(1).getDayOfMonth();
		int eDate = currentDate.plusDays(2).getDayOfMonth();
		String startDate = Integer.toString(dayOfMonth);
		String endDate = Integer.toString(eDate);
		System.out.println(startDate);
		driver.findElement(By.xpath("//span[text()='Start Date']/following::a[@class='datePicker-openIcon display'][1]")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//table[@class='calGrid']//tbody/tr[1]"))));
		List<WebElement> calStartDate = driver.findElements(By.xpath("//table[@class='calGrid']//tbody//td"));
		for (WebElement dayEle : calStartDate) {
			if(dayEle.getText().equalsIgnoreCase(startDate)) {
				dayEle.click();
				break;
			}
		}
		

//		 8. End date as Tomorrow+1
		driver.findElement(By.xpath("(//span[text()='End Date']/following::a[@class='datePicker-openIcon display'])[2]")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//table[@class='calGrid']//tbody/tr[1]"))));
		List<WebElement> calEndDate = driver.findElements(By.xpath("//table[@class='calGrid']//tbody//td"));
		for (WebElement dayEle : calEndDate) {
			if(dayEle.getText().equalsIgnoreCase(endDate)) {
				dayEle.click();
				break;
			}
		}
//		 9. click Save and Verify the newly created Campaign 
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		String cName = driver.findElement(By.xpath("//label[@data-aura-class='uiLabel']/span[text()='Campaign Name']/following::input[1]")).getAttribute("value");
		System.out.println("Campaign \""+cName+ "\" was created.");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']"))));
		if(driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText().contains("Campaign \""+cName+"\" was created.")) {
			System.out.println("Campaign has been created successfully");
		}
		
	}

}
