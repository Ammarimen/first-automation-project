package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class WebElementCommands {

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
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		WebElement element = driver.findElement(By.id("txtUsername"));
		
		String attValue = element.getAttribute("id");
		System.out.println("The id attribute is: "+attValue);
		
		driver.findElement(By.id("txtUsername")).clear();
		
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		WebElement element2 = driver.findElement(By.id("txtPassword"));
		Dimension dimensions = element2.getSize();
		System.out.println("Height = "+dimensions.height + " | " + "width = "+dimensions.width);
		element2.clear();
		
		WebElement element3 = driver.findElement(By.id("txtPassword"));
		Point point = element3.getLocation();
		System.out.println("X cordinate : " + point.x  + " | "+  " Y cordinate : " + point.y);
		
		//Verify if element is displayed (element est affiché ou non) True or False
		WebElement element4 = driver.findElement(By.id("btnLogin"));
		boolean status = element4.isDisplayed();
		System.out.println(status);
		
		//Verify element is enabled True or False
		WebElement element5 = driver.findElement(By.id("btnLogin"));
		boolean status1 = element5.isEnabled();
		System.out.println(status1);
		
		//Verifiy element is existed True or False
		List<WebElement> element6 = driver.findElements(By.id("btnLogin"));
		if (element6.size() != 0) {
			System.out.println("Button login is exist!");
		}else {
			System.out.println("Button login is not exist!");
		}
					
		driver.quit();
		

	}

}
