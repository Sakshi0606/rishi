import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Selectingfromdropdown {
public static WebDriver driver;
	@BeforeClass
	public static void BeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.shoppersstop.com/");
	}

	@Test
	public void test() throws Exception {
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
		
	}
	
	@AfterClass
	public static void AfterClass() throws Exception {
		driver.quit();
	}

}
