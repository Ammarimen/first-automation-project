package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverCommands {

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
		String url = "https://opensource-demo.orangehrmlive.com/";
		driver.get(url);
		
		String titlePage = driver.getTitle();
		int titleLength = titlePage.length();
		
		System.out.println("Title of the page is: "+titlePage);
		System.out.println("Lenght of title of the page is: "+titleLength);
		
		String actualUrl = driver.getCurrentUrl();
		if(actualUrl.equals(url)) {
			System.out.println("verification successfull - the correct url is opened ");
		} else {
			System.out.println("Verification failed an correct url is opened");

		}
		
		System.out.println("Actual URL is " + actualUrl);
		System.out.println("Expected URL is " + url);
		
		String sourcePage = driver.getPageSource();
		int lengthSourcePage = sourcePage.length();
		System.out.println("Length of the source page is: "+lengthSourcePage);
		
		driver.quit();
		
	
		
		
		
		

	}

}
