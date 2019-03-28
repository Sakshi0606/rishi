package TestNG;

import org.testng.annotations.Test;

import util.BrowserSetup;
import util.DataDrivenExcel;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

@Test(dataProvider="dp")
public class DataProviderExcelWay2 {
	WebDriver driver;


	public void Login(String UN, String PWD) {
	  
	 // driver.get("http://127.0.0.1:8080/htmldb");
	  driver.findElement(By.xpath("//*[@id=\"P11_USERNAME\"]")).sendKeys(UN);
	  driver.findElement(By.xpath("//*[@id=\"P11_PASSWORD\"]")).sendKeys(PWD);
	  driver.findElement(By.xpath("//*[@value='Login']")).click();
	  driver.findElement(By.linkText("Logout")).click();
	  driver.findElement(By.partialLinkText("Log")).click();  
	  
  }
  
  @DataProvider
  public Object[][] dp() throws IOException
  {
	  	Object data[][]=new Object[4][2];
	  	DataDrivenExcel excel=new DataDrivenExcel("C:\\Users\\vshadmin\\Desktop\\Book1.xlsx");
	  	
		for(int i=0;i<excel.rowCount("Sheet1");i++)
		{
			data[i][0]=excel.Read("Sheet1",i , 0);
			data[i][1]=excel.Read("Sheet1",i , 1);
		}
	  return data;
  }
  
  @BeforeTest
  public void beforeTest() {
	  
	  driver = BrowserSetup.browserStart("Chrome","http://127.0.0.1:8080/htmldb");
  }
  

  @AfterTest
  public void afterTest() {
	  
	 // driver.quit();
  }
@AfterMethod
public void AfterMethod(ITestResult result)
{
	System.out.println(ITestResult.FAILURE);
	System.out.println(ITestResult.SUCCESS);
	System.out.println(ITestResult.SKIP);
	if(result.getStatus()==ITestResult.FAILURE)
	{
		System.out.println("taking screenshot");
		BrowserSetup.getScreenShot(result.getName());
	}
}

}
