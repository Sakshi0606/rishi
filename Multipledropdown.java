import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class Multipledropdown 
{
	public static WebDriver driver;
  @Test
  public void f() throws Exception 
  {
	  driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("/html/body/main/nav/div[1]/div/ul/li[4]/a"))).perform();
	Thread.sleep(3000);
		ac.moveToElement(driver.findElement(By.xpath("/html/body/main/nav/div[1]/div/ul/li[4]/div/div/ul/li[3]/a"))).perform();
		List<WebElement> ls=driver.findElements(By.xpath("/html/body/main/nav/div[1]/div/ul/li[4]/div/div/ul/li[3]/div/ul/li[1]/div/ul/li[*]/div/span/a"));
		for(int i=0;i<ls.size();i++)
		{
			System.out.println(ls.get(i).getText());
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"header-info-bar\"]/div/div/div[2]/ul/li[1]/a")).click();;
		driver.findElement(By.xpath("//*[@id=\"city-name\"]")).click();;
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//*[@id=\"city-name\"]/option[27]"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		element.click();
		List<WebElement> lst=driver.findElements(By.xpath("//*[@class='selected-store ex-select-menu']"));
		for(int i=0;i<lst.size();i++)
		{
			System.out.println(lst.get(i).getText());
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"city-name\"]")).click();;
		WebElement ch= driver.findElement(By.xpath("//*[@id=\"city-name\"]/option[8]"));
		ch.click();
		boolean ch1=driver.findElements(By.xpath("//*[@class='selected-store ex-select-menu']")).isEmpty();
		if(ch1==false)
		System.out.println("list have value");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"city-name\"]")).click();;
		WebElement jai= driver.findElement(By.xpath("//*[@id=\"city-name\"]/option[18]"));
		jai.click();
		boolean jai1=driver.findElements(By.xpath("//*[@class='selected-store ex-select-menu']")).isEmpty();
		if(jai1==false)
		System.out.println("list have value");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"city-name\"]")).click();;
		WebElement ra= driver.findElement(By.xpath("//*[@id=\"city-name\"]/option[35]"));
		//to scroll inside dropdown
		je.executeScript("arguments[0].scrollIntoView(true);",ra);
		ra.click();
		boolean ra1=driver.findElements(By.xpath("//*[@class='selected-store ex-select-menu']")).isEmpty();
		if(ra1==false)
		System.out.println("list have value");
		
		
  }
  @BeforeClass        
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.shoppersstop.com/");
  }

  @AfterClass
  public void afterClass() 
  {
	  driver.quit();
  }

}
