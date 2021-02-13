package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

public class WebTables {

	public static void main(String[] args) throws ParseException {
		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize(); 
		driver.get("http://demo.guru99.com/test/web-table-element.php#");
		WebElement baseTable = driver.findElement(By.tagName("table"));
		//System.out.println("The content of the table is : \n"+baseTable.getText());

		//No.of Columns
		List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
		System.out.println("Number of columns is : "+col.size());

		//No.of Rows
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td[1]"));
		System.out.println("Number of columns is : "+rows.size());

		//To find the third row of table 
		WebElement thirdRowTable = baseTable.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]"));
		System.out.println("The third row of the table is : "+thirdRowTable.getText());

		//to get 3rd row's 2nd column data
		WebElement cellIneed = baseTable.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]/td[2]"));
		System.out.println("The 3rd row's 2nd column data is : "+cellIneed.getText());

		//Get Maximum of all the Values in a Column 
		String max;
		double m=0,r=0;
		for(int i=1 ; i<rows.size() ; i++) {
			max = driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[" + (i+1) + "]/td[4]")).getText(); 
			NumberFormat f =NumberFormat.getNumberInstance(); 
			Number num = f.parse(max);
			max = num.toString();
			m = Double.parseDouble(max);
			if(m>r){    
				r=m;
			}
		}
		
		System.out.println("Maximum current price is : "+ r);
	}
}
