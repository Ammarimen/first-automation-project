package testCases;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class VerifyColorDemo {

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
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		String color = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/span")).getCssValue("color");
		String[] hexValue = color.replace("rgba(","").replace(")", "").split(",");
		
		int hexValue1 = Integer.parseInt(hexValue[0]);
		hexValue[1] = hexValue[1].trim();
		
		int hexValue2 = Integer.parseInt(hexValue[1]);
		hexValue[2] = hexValue[2].trim();
		
		int hexValue3 = Integer.parseInt(hexValue[2]);
		
		String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
		System.out.println("The color of the text is: "+actualColor);
		Assert.assertEquals("#ff0000", actualColor);
		
		driver.quit();
		

	}

}
