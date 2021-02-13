package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) {
		//Read chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

		//Open chrome
		WebDriver driver = new ChromeDriver();

		//Maximize browser
		driver.manage().window().maximize();

		//Open application QAtool
		driver.get("http://demoqa.com/menu/");

		//Instantiate action class
		Actions actions = new Actions(driver);
		
		WebElement mouseHover = driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/a"));
		actions.moveToElement(mouseHover).perform();

		driver.quit();

	}

}
