

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

public class Minimumlogic {
	public static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://nseindia.com");
	}

	@Test
	public void test() throws Exception 
	{
		double min=100000;
			driver.manage().window().maximize();
			WebElement ele = driver.findElement(By.xpath("//*[@id=\"main_livemkt\"]/a"));
			//Create object 'action' of an Actions class
			Actions action = new Actions(driver);
			//Mouseover on an element
			action.moveToElement(ele).perform();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"main_liveany_ttg\"]/a")).click();
			Minimumlogic.getScreenShot("Firstpage2");
			List<WebElement> lst =driver.findElements(By.xpath("//*[@id=\"topGainers\"]/tbody/tr[*]/td[1]"));	
			for(int i=0;i<lst.size();i++)
			{
				System.out.println(lst.get(i).getText());
				
			}	
			List<WebElement> lst2 =driver.findElements(By.xpath("//*[@id=\"topGainers\"]/tbody/tr[*]/td[2]"));
			for(int i=0;i<lst2.size();i++)
			{
			 double one=Double.parseDouble(lst2.get(i).getText().replaceAll(",",""));
			  if(one<min)
			  {
				  min=one;
			  }
			}
			 System.out.println("minimum="+min);
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