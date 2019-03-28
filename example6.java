package CP;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class example6 
{
	WebDriver driver;
  @Test
  public void f() 
  {
	  WelComePOM w=new WelComePOM(driver);
	  driver.get("https://www.shoppersstop.com/");
	  //w.getMenShoeCategory();
	  
	  w.getMumbaiStore();
	  Assert.assertTrue(w.isCityPresent("Raipur"));
	  Assert.assertTrue(w.isCityPresent("Jaipur"));
	  Assert.assertTrue(w.isCityPresent("Mahape"),"Mahape is Not Present");	  
  }

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vshadmin\\Desktop\\CPSAT_Jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
