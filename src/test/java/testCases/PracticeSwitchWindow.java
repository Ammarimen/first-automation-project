package testCases;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeSwitchWindow {

	public static void main(String[] args) {
		//Read chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

		//Open chrome
		WebDriver driver = new ChromeDriver();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

		//maximize browser
		driver.manage().window().maximize(); 

		//Open application OrangeHRM
		driver.get("https://demoqa.com/browser-windows");

		//Store and print the name of the first window
		String handle = driver.getWindowHandle();
		System.out.println(handle);

		//Click on the button "new window"
		driver.findElement(By.id("messageWindowButton")).click();

		// Store and print the name of all the windows open
		Set handles = driver.getWindowHandles();
		System.out.println("All window open " + handles);

		// Pass window handle to other window
		for (String handle1 : driver.getWindowHandles()) {
			System.out.println(handle1);
			driver.switchTo().window(handle1);
		}






	}

}
