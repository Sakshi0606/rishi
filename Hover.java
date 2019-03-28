

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;


public class Hover {
	public static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://nseindia.com");
	}

	@Test
	public void test() throws Exception {
		
		List<WebElement> ls=driver.findElements(By.xpath("//*[@class='overlay']"));
		System.out.println(ls.size());
		
		Hover.getScreenShot("FirstPage");
		 WebElement ele = driver.findElement(By.xpath("//a[@href='http://cpdof.devopsppalliance.org/']//div[@class='overlay']"));
			//Create object 'action' of an Actions class
			Actions action = new Actions(driver);
			//Mouseover on an element
			action.moveToElement(ele).perform();
			Thread.sleep(3000);
			Hover.getScreenShot("HoverDOF");
			String val=driver.findElement(By.xpath("/html/body/section/article/div[2]/div[4]/div/a")).getAttribute("href");
			System.out.println(val);

	}
	
	@AfterClass
	public static void setUpAfterClass() throws Exception {
		driver.quit();
	}
	
	public  static void getScreenShot(String Name)
	{	
		Date d=new Date();
		System.out.println("Before "+d.toString());
		String date=d.toString().replaceAll(" ", "_").replaceAll(":","_");
		System.out.println("After "+date);
		
		TakesScreenshot screen=(TakesScreenshot)driver;
		File src=screen.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(".\\"+Name+date+".png"));
		} catch (IOException e) {
			System.out.println("Error  while taking screenshot");
			
		}
	}
	
}
