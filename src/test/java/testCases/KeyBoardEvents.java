package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KeyBoardEvents {

	public static void main(String[] args) {
		//Read chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

		//Open chrome
		WebDriver driver = new ChromeDriver();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);

		//Maximize browser
		driver.manage().window().maximize(); 

		//Open application 
		driver.get("https://demoqa.com/text-box");

		//Find Elments 
		WebElement fullName = driver.findElement(By.id("userName"));
		WebElement email = driver.findElement(By.id("userEmail"));
		WebElement currentAdress = driver.findElement(By.id("currentAddress"));
		WebElement permanentAdress = driver.findElement(By.id("permanentAddress"));

		//Instanciate class action 
		Actions actions = new Actions(driver);
		actions.sendKeys(fullName, "test").perform();
		actions.sendKeys(email, "test1@gmail.com").perform();
		actions.sendKeys(currentAdress, "10 rue de test").perform();

		//Copy current Adress
		actions.keyDown(currentAdress, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(permanentAdress, Keys.CONTROL).perform();
		actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		
		//Submit with the alternative method
		WebElement btnSubmit; 
		btnSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
		btnSubmit.submit();
		
		System.out.println("Great! Test keys board events is OK!");
		
		driver.quit();










	}

}
