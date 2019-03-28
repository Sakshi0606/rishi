import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Gettext
{
	public static WebDriver driver;
  @Test
  public void f() throws Exception {
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id=\"keyword\"]")).sendKeys("Mahindra & Mahindra Limited");
	 Actions ac = new Actions(driver);
	 WebElement ele=driver.findElement(By.xpath("//*[@id=\"ajax_response\"]/ol/li[1]"));
	 Action seriesOfActions = ac
				.moveToElement(ele)
				//.keyDown(txtUsername, Keys.SHIFT)
				.sendKeys(Keys.ENTER)
				//.keyUp(txtUsername, Keys.SHIFT)
				.build();		
			seriesOfActions.perform() ;
	
	 String str=driver.findElement(By.xpath("//*[@id='faceValue']")).getText();
	System.out.println(str);
	Gettext.getScreenShot("FaceValue");
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver",".\\drivers\\geckodriver.exe");
  driver= new FirefoxDriver();
  driver.get("https://nseindia.com/");
  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
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
