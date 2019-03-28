package TestNG;

import org.testng.annotations.Test;


import util.BrowserSetup;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DataProviderMM {
	WebDriver driver;
	
@Test(dataProvider="dp")
public void Login(String UN,String PWD)
{
	driver.get(" http://127.0.0.1:8080/htmldb/f?p=4550:11:13182744854133669183::NO:::");
	driver.findElement(By.cssSelector("input#P11_USERNAME")).sendKeys(UN);
	//driver.findElement(By.cssSelector("input#P11_PASSWORD")).sendKeys("Newuser123");
	driver.findElement(By.cssSelector("input[type='password']")).sendKeys(PWD);
	driver.findElement(By.cssSelector("input[value='Login']")).click();
	driver.findElement(By.cssSelector("img[title='Logout']")).click();
	driver.findElement(By.cssSelector("a.htmldbInstruct")).click();
}
  
@DataProvider
public Object[][] dp()
{
	Object data[][]=new Object[3][2];
	data[0][0]="sys";
	data[0][1]="Newuser123";
	data[1][0]="system";
	data[1][1]="123";
	data[2][0]="kkkk";
	data[2][1]="12";
	return data;
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
