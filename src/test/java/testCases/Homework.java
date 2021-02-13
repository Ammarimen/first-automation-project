package testCases;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Homework {

	public static void main(String[] args) throws InterruptedException{

		//Read chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

		//Open chrome
		WebDriver driver = new ChromeDriver();
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

		//Maximize browser
		driver.manage().window().maximize();

		//Open application Patient Medical HIstory
		String url = "https://form.jotform.com/81665408084158";
		driver.get(url);

		//Drop down list "Patient Gender"
		Select patientGender= new Select(driver.findElement(By.id("input_71")));
		patientGender.selectByValue("Female");

		//Input Patient Name 
		driver.findElement(By.name("q45_patientName[first]")).sendKeys("Imen");
		driver.findElement(By.name("q45_patientName[last]")).sendKeys("BEN AMMAR");

		//Drop down lists "Patient Birth Date"
		Select month = new Select(driver.findElement(By.id("input_46_month")));
		month.selectByValue("March");
		Select day = new Select(driver.findElement(By.id("input_46_day")));
		day.selectByValue("25");
		Select year = new Select(driver.findElement(By.id("input_46_year")));
		year.selectByValue("2000");

		//Input Patient Height (cm's) , Patient Weight (kg's) , Patient Email
		driver.findElement(By.id("input_72")).sendKeys("160");
		driver.findElement(By.id("input_73")).sendKeys("100");
		driver.findElement(By.id("input_74")).sendKeys("Imen@gmail.com");
		driver.findElement(By.id("input_50")).sendKeys("Nothing");

		//Scroll
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1100)", "");

		//Check box "Anemia"
		WebElement anemie = driver.findElement(By.xpath("//input[contains(@value,'Anemia')]"));
		anemie.click();

		//Check box "Sleep Apnea"
		WebElement sleepApnea = driver.findElement(By.xpath("//input[contains(@value,'Sleep Apnea')]"));
		sleepApnea.click();

		//Scroll
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,3000)", "");
		
		//Radio box
		WebElement noSmoke = driver.findElement(By.id("input_78_0"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", noSmoke);
		Thread.sleep(500);
		//Select noSmoke = new Select(driver.findElement(By.xpath("//*[@id=\"input_78_0\"]")));
		//noSmoke.selectByValue("No");

		//Click button Submit
		driver.findElement(By.id("input_14")).click();

		//Assert verification inscription 
		String rightClickMessage = driver.findElement(By.xpath("//*[@id=\"stage\"]/div")).getText();
		Assert.assertTrue(rightClickMessage.contains("Your submission has been received."));
		
		System.out.println("Thank you! Your submission has been received");


		driver.quit();


	}

}
