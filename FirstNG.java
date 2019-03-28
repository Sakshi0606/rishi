package TestNG;

import org.testng.annotations.Test;

import util.BrowserSetup;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class FirstNG {
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("https://www.google.com/");
	  String title=driver.getTitle();
	  Assert.assertEquals(title,"Google");//right
	//  Assert.assertEquals(title,"Google Search");//wrong
  }
  @BeforeTest
  public void beforeTest() {
	  driver=BrowserSetup.browserStart("chrome");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
