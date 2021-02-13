package testCases;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindow {

	public static void main(String[] args) {
		// Read firefox.exe
		//System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

		// Open mozilla
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();

		// Maximize browser
		driver.manage().window().maximize();

		// Open application OrangeHRM
		driver.get("https://www.ouestjob.com/candidat/connexion.html");

		// Input username
		WebElement element = driver.findElement(By.id("Mail"));
		String attValue = element.getAttribute("id");
		System.out.println("The is attribute is: "+attValue);
		element.sendKeys("zakisayad1992@gmail.com");

		//

		// Input password
		driver.findElement(By.id("Password")).sendKeys("8l840uk92C7");
		WebElement dimensionElement = driver.findElement(By.id("Password"));
		Dimension dimension = dimensionElement.getSize();
		System.out.println("Hight button login is : "+dimension.height);
		System.out.println("Width button login is : "+dimension.width);



		//Verify if the button login exists 
		List<WebElement> element5 = driver.findElements(By.xpath("/html/body/div[2]/div/div/form/button"));
		if (element5.size()!=0) {
			System.out.println("Button login is exist");	
		}else {
			System.out.println("Button login is not exist");
		}
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();


		////////////////////////////////////////////////////////////////////////////////////////////////////////////

		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent window is : " +parentHandle);

		driver.findElement(By.xpath("/html/body/footer/section[2]/ul[1]/li[2]/a")).click();

		Set<String> windowHandles = driver.getWindowHandles();


		for (String handles : windowHandles) {
			System.out.println("The  window is :" +handles);

			if(!handles.equals(parentHandle)) {
				driver.switchTo().window(handles);
				driver.findElement(By.xpath("/html/body/header/section[2]/div/div/nav/ul[1]/li[2]/a")).click();


				WebElement dimensionElement2 = driver.findElement(By.xpath("/html/body/div[5]/div/div[3]/div[1]/div/div[2]/form/div[1]/div[1]/div[1]/div[1]/label"));
				Dimension dimension2 = dimensionElement2.getSize();
				System.out.println("Hight element case certificate is : "+dimension2.height);
				System.out.println("Width element case certificate is  : "+dimension2.width);
			}		
		}

	}

}
