package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

	public static void main(String[] args) {
		//Read chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

		//Open chrome
		WebDriver driver = new ChromeDriver();
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

		//Maximize browser
		driver.manage().window().maximize(); 
		
		//Open application 
		driver.get("https://demoqa.com/alerts");
		
		driver.findElement(By.id("alertButton")).click();
		
		//Accept Alert
		driver.switchTo().alert().accept();
		
		//Print title page
		String title = driver.getTitle();
		System.out.println("Title of the page is: " +title);
		
		driver.quit();
	}
}
