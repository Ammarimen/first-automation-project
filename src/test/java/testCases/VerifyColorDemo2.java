package testCases;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyColorDemo2 {

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
		
		String color = driver.findElement(By.id("alertButton")).getCssValue("background-color");
		String[] hexValue = color.replace("rgba(","").replace(")", "").split(",");
		
		int hexValue1 = Integer.parseInt(hexValue[0]);
		hexValue[1] = hexValue[1].trim();
		
		int hexValue2 = Integer.parseInt(hexValue[1]);
		hexValue[2] = hexValue[2].trim();
		
		int hexValue3 = Integer.parseInt(hexValue[2]);
		
		String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
		System.out.println("The color of the text is: "+actualColor);
		Assert.assertEquals("#007bff", actualColor);	
		
		driver.quit();

	}

}
