package test;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SimpleLaunch {
	WebDriver driver;
	By aboutUs = By.xpath("//span[contains(text(),'AboutUs')]");
	By  ourOffice = By.xpath("//span[contains(text(),'Our')]");
	By chennai = By.xpath("//span[contains(text(),'Chennai')]");
	
	
	
	@Test(enabled=true)
	public void handleWindowMethod() {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(aboutUs))
		.moveToElement(driver.findElement(ourOffice))
		.moveToElement(driver.findElement(chennai)).click().build().perform();
		Set<String> allWindows = driver.getWindowHandles();
		String contactUsTab = allWindows.toArray()[1].toString();
		driver.switchTo().window(contactUsTab);
	
		
	}
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
		
		
	}

	@Test
	public void handleAlert() {
		driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
		if(ExpectedConditions.alertIsPresent()!=null) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
	}

}
