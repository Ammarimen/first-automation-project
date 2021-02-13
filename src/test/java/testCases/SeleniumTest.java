package testCases;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	
	public static WebDriver driver;

	@BeforeClass
	public static void OpenBrowser() {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize(); 
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test
	public void valid_UserCredential() {

		driver.findElement(By.id("txtUsername")).sendKeys("Admin"); 
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		String profilMessage = driver.findElement(By.id("welcome")).getText();
		Assert.assertTrue(profilMessage.contains("Welcome Paul"));	
	}
	
	@Test
	public void inValid_UserCredential() {

		driver.findElement(By.id("txtUsername")).sendKeys("Imen"); 
		driver.findElement(By.id("txtPassword")).sendKeys("123456789");
		driver.findElement(By.id("btnLogin")).click();
		String errorMessage = driver.findElement(By.id("spanMessage")).getText();
		Assert.assertTrue(errorMessage.contains("Invalid credentials"));
	}
	
	@AfterClass
	public static void tearDown() {

		driver.quit();	
	}









}
