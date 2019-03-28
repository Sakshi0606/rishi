package TestNG;

import org.testng.annotations.Test;


import util.BrowserSetup;
import util.DataDrivenExcel;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DataProviderExcel {
	WebDriver driver;
	
@Test(dataProvider="dp")
public void Login(String UN,String PWD)
{
	driver.get(" http://127.0.0.1:8080/htmldb/f?p=4550:11:13182744854133669183::NO:::");
	driver.findElement(By.cssSelector("input#P11_USERNAME")).clear();
	driver.findElement(By.cssSelector("input#P11_USERNAME")).sendKeys(UN);
	
	driver.findElement(By.cssSelector("input[type='password']")).clear();
	driver.findElement(By.cssSelector("input[type='password']")).sendKeys(PWD);
	
	driver.findElement(By.cssSelector("input[value='Login']")).click();
	//driver.findElement(By.cssSelector("img[title='Logout']")).click();
	//driver.findElement(By.cssSelector("a.htmldbInstruct")).click();
	if (driver.getTitle().equals("Oracle"))
	{
	
	System.out.println("login done");
	
	driver.findElement(By.cssSelector("img[title='Logout']")).click();
	driver.findElement(By.cssSelector("a.htmldbInstruct")).click();
	}
	else
	{
		System.out.println("login fail");
		BrowserSetup.getScreenShot("failed_test");
		}
	}

  
@DataProvider
public Object[][] dp() throws Exception
{
	Object data[][]=new Object[4][2];
	FileInputStream inFile = new FileInputStream("C:\\Users\\lenovo\\Desktop\\Book1.xlsx");
	XSSFWorkbook book = new XSSFWorkbook(inFile);
	XSSFSheet sheet = book.getSheet("Sheet1");
	
	
	for(int i =0 ; i<=sheet.getLastRowNum();i++)
	{
		String data1 = sheet.getRow(i).getCell(0).toString();
		System.out.print(data1);
		
		
		String data2 = sheet.getRow(i).getCell(1).toString();
		System.out.println("  "+data2);
		for(int j =0 ; j<1;j++)
		{
			data[i][j]= data1;
			data[i][j+1]= data2;
		}
	
}
	return data;
	
	/*data[0][0]="sys";
	data[0][1]="Newuser123";
	data[1][0]="system";
	data[1][1]="123";
	data[2][0]="kkkk";
	data[2][1]="12";
	return data;*/
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
