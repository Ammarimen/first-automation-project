package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFileDemo {

	public static void main(String[] args) {
		//Read chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

		//Open chrome
		WebDriver driver = new ChromeDriver();
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		
		//maximize browser
		driver.manage().window().maximize(); 
		
		//Open application 
		driver.get("http://demo.guru99.com/test/upload/");
		
		WebElement uploadFile = driver.findElement(By.id("uploadfile_0"));
		uploadFile.sendKeys("C:\\Users\\Imen BEN AMMAR\\Desktop\\photo bokay\\biscuit-amaretti.jpg");
		driver.findElement(By.id("terms")).click();
		
		//Click on the button Submit using JavaScriptExecutor method 
		WebElement submitButton = driver.findElement(By.id("submitbutton"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", submitButton);
		
		driver.quit();
	

	}

}
