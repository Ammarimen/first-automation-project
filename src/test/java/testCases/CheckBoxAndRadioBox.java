package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckBoxAndRadioBox {

	public static void main(String[] args) {

				//Read chromedriver.exe
				System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

				//Open chrome
				WebDriver driver = new ChromeDriver();

				// Implicit wait
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

				//maximize browser
				driver.manage().window().maximize();

				//Open application QAtool
				driver.get("https://demoqa.com/automation-practice-form");
				
				//Check box
				WebElement hobbiesSport = driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\\\"]/div[2]/div[1]/label"));
				hobbiesSport.click();
				
				//Radio box
				Select radio = new Select(driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]")));
				radio.selectByValue("Male");
				
				driver.quit();
			
				


			}

		}
