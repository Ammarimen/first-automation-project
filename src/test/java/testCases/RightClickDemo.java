package testCases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickDemo {

	public static void main(String[] args) {
		//Read chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

		//Open chrome
		WebDriver driver = new ChromeDriver();

		//Maximize browser
		driver.manage().window().maximize();

		//Open application QAtool
		driver.get("http://demoqa.com/buttons");

		//Instantiate action class
		Actions actions = new Actions(driver);

		//Retrieve webelement to perform right click 
		WebElement btnRightClick = driver.findElement(By.id("rightClickBtn"));

		//Right click on the button 
		actions.contextClick(btnRightClick).perform();

		//Assert verification message right click 
		String rightClickMessage = driver.findElement(By.id("rightClickMessage")).getText();
		Assert.assertTrue(rightClickMessage.contains("You have done a right click"));

		System.out.println("right click context displayed!");

		driver.quit();

	}

}
