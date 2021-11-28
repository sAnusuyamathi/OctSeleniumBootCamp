package testNGBootCamp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ChromeDriver driver;
	WebDriverWait wait;
	Actions builder;
@BeforeMethod

 public void loginFunctionality() {
	WebDriverManager.chromedriver().setup();
	ChromeOptions opt = new ChromeOptions();
	opt.addArguments("--disable-notifications");
	driver = new ChromeDriver(opt);
	wait=new WebDriverWait(driver, Duration.ofMinutes(2));
	builder = new Actions(driver);
//	1. Login to https://login.salesforce.com
	driver.get("https://login.salesforce.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		2. Click on the toggle menu button from the left corner
	driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
//	password = SelBootcamp$1234
	driver.findElement(By.id("password")).sendKeys("SelBootcamp$1234");
	driver.findElement(By.id("Login")).click();
//	Thread.sleep(15000);
	driver.findElement(By.className("slds-icon-waffle")).click();
	driver.findElement(By.xpath("//button[text()='View All']")).click();
}
@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
