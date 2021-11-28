package testNGBootCamp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_03_S05_36CreateLegalEntityWithoutMandatoryFields extends BaseClass{
	@Test
	public void runCreateEntityWOMandatory() throws InterruptedException {
		// TODO Auto-generated method stub
		
//		4. Click on the legal Entities tab 
		Thread.sleep(15000);
		driver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//p[text()='Legal Entities']")));
//			4. Click on the Dropdown icon in the legal Entities tab
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[contains(text(),'Legal Entities Menu')]")));
//			5. Click on New Legal Entity
		driver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//span[contains(text(),'New Legal Entity')]")));
//		6. Enter the Company name as 'Testleaf'.
		driver.executeScript("arguments[0].value='Testleaf';",driver.findElement(By.xpath("//span[text()='Company Name']/following::input")));
//		7. Enter Description as 'SalesForce'.
		driver.findElement(By.xpath("//span[text()='Description']/following::textarea")).sendKeys("SalesForce w/o mandatory");
//		8. Select Status as 'Active'
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Status']/following::a[text()='--None--'][1]")));
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//li/a[text()='Active']")));
//		9. Click on Save
		Thread.sleep(10000);
		driver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[@title='Save']")));
//		10. Verify the Alert message (Complete this field) displayed for Name
		String text = driver.findElement(By.xpath("//div[@class='genericNotification']")).getText();
		if(text.equals("Review the errors on this page.")) {
			String text1 = driver.findElement(By.xpath("//span[text()='Name']/following::li[2]")).getText();
			if(text1.contains("Complete this field"))
				System.out.println("It is a mandatory field");
		}
//		Expected Result:
//		Complete this field message should be displayed for Name field
}

}
