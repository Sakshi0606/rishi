import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class Questionagain {
 public static WebDriver driver;
	@Test
  public void f() throws Exception 
	{
		double min=0;
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//*[@id=\"main_livemkt\"]/a"))).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"main_livewth_currderi\"]/a")).click();
		Thread.sleep(3000);
		List<WebElement> lst = driver.findElements(By.xpath("//*[@id=\"rbi_ref_rate\"]/div/table/tbody/tr/td[*]"));
		for(int i=0;i<lst.size();i++)
		{
			System.out.println(lst.get(i).getText());
			String s[]=lst.get(i).getText().split(" ");
			double one=Double.parseDouble(s[2]);		
			  if(one>min)
			  {
				  min=one;
			  }	
		}
		System.out.println(min);
	}
	
  @BeforeClass
  public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://nseindia.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }
 
  @AfterClass
  public void afterClass() 
  {
	  driver.quit();
  }

}
