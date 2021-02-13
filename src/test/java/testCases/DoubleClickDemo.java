package testCases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickDemo {

	public static void main(String[] args) throws InterruptedException {

		//Read chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

		//Open chrome
		WebDriver driver = new ChromeDriver();

		//Maximize browser
		driver.manage().window().maximize();

		//Open application QATool
		driver.get("http://demoqa.com/buttons");
		
		//Instantiate action class
		Actions actions = new Actions(driver);
		
		//Retrieve webelement to perform double click 
		WebElement btnDoubleClick = driver.findElement(By.id("doubleClickBtn"));
		
		//Double click on the button 
		actions.doubleClick(btnDoubleClick).perform();
		
		//Assert verification message double click
		String doubleClickMessage = driver.findElement(By.id("doubleClickMessage")).getText();
		Assert.assertTrue(doubleClickMessage.contains("You have done a double click"));
		
		System.out.println("Button is double clicked!");
		
		//Scroll
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,350)", "");
		
		//refresh page
		driver.navigate().refresh();
		Thread.sleep(2000);
		
		//Go back
		driver.navigate().back();
		Thread.sleep(2000);
		
		//Forward page
		driver.navigate().forward();
		Thread.sleep(200);
		
		//driver.quit();


	}

}
