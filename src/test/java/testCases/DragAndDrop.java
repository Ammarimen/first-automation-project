package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		//Read chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

		//Open chrome
		WebDriver driver = new ChromeDriver();

		//Maximize browser
		driver.manage().window().maximize();

		//Open application demoQA
		String url = "http://demoqa.com/droppable/";
		driver.get(url);

		//Action drag and drop 
		Actions actions = new Actions(driver);
		WebElement from = driver.findElement(By.id("draggable"));
		WebElement to = driver.findElement(By.id("droppable"));
		actions.dragAndDrop(from, to).perform();

		// Verify text was Dropped
		String textTo = to.getText();
		System.out.println(textTo);
		if(textTo.equals("Dropped!")) {
			System.out.println("Pass: Source is dropped to target as expected! ");
		}
		else {
			System.out.println("Fail: Source couldn't be dropped to target as expected! ");
		}

		//Kill browser
		driver.quit();




	}

}
