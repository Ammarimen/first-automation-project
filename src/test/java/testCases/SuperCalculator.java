package testCases;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuperCalculator {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize(); 
		driver.get("https://juliemr.github.io/protractor-demo/");

		driver.findElement(By.xpath("//input[contains(@ng-model,'first')]")).sendKeys("5");
		driver.findElement(By.xpath("//input[contains(@ng-model,'second')]")).sendKeys("5");
		driver.findElement(By.id("gobutton")).click();
		
		WebElement result = driver.findElement(By.tagName("h2"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Pattern pattern = Pattern.compile("\\d+");
		wait.until(ExpectedConditions.textMatches(By.tagName("h2"), pattern));

		System.out.println("the result is : " + result.getText());

		driver.quit();
	}
}
