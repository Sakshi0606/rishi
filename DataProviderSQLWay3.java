package TestNG;

import org.testng.annotations.Test;

import database.MyConnection;

import util.BrowserSetup;
import util.DataDrivenExcel;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;


public class DataProviderSQLWay3 {
	
	WebDriver driver;
	Connection conn;
	
	@Test
	public void Login() throws Exception {
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		conn=MyConnection.getMyConnection();
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from logindetails");
		
		while(rs.next())
		{
			
			String name=rs.getString(1);
			System.out.println(name);		
			driver.findElement(By.xpath("//*[@id=\"P11_USERNAME\"]")).clear();
			 driver.findElement(By.xpath("//*[@id=\"P11_USERNAME\"]")).sendKeys(name);
			
			String pass=rs.getString(2);
			System.out.println(pass);	
			 driver.findElement(By.xpath("//*[@id=\"P11_PASSWORD\"]")).clear();
			 driver.findElement(By.xpath("//*[@id=\"P11_PASSWORD\"]")).sendKeys(pass);
			
			  driver.findElement(By.xpath("//*[@value='Login']")).click();
			  
			  if (driver.getTitle().equals("Oracle"))
				{
				  PreparedStatement pst=conn.prepareStatement("update  logindetails set status='success' where userid='"+name+"'" );
					System.out.println(pst);
					System.out.println("HHH");
					int row = pst.executeUpdate();
				driver.findElement(By.cssSelector("img[title='Logout']")).click();
				driver.findElement(By.cssSelector("a.htmldbInstruct")).click();
				System.out.println("login done");
				
				}
				else
				{
					System.out.println("login fail");
				PreparedStatement pst=conn.prepareStatement("update  logindetails set status='failed' where userid=' "+name+" ' " );
				System.out.println(pst);
				System.out.println("HHH");
				int row = pst.executeUpdate();
				System.out.println("order created " + row);
				System.out.println("Hjgfj");
					}
			
			}
		} 
  
 /*
  @DataProvider
  public Object[][] dp() throws IOException
  {
	  	Object data[][]=new Object[4][2];
	  	Excel excel=new Excel("C:\\Users\\vshadmin\\Documents\\Book11.xlsx");
	  	
		for(int i=0;i<=excel.rowCount("Sheet1");i++)
		{
			data[i][0]=excel.Read("Sheet1",i , 0);
			data[i][1]=excel.Read("Sheet1",i , 1);
		}
	  return data;
  }*/
 
  @AfterMethod
  public void afterMethod(ITestResult result)
  {
	  System.out.println(ITestResult.FAILURE);
	  System.out.println(ITestResult.SUCCESS);
	  System.out.println(ITestResult.SKIP);
	  if(result.getStatus()==ITestResult.FAILURE);
	  {
		  System.out.println("Take SS");
		 // BrowserSetup.getScreenShot(result.getName());
	  }
  }
  
  @BeforeTest
  public void beforeTest() {
	  
	  driver = BrowserSetup.browserStart("Chrome","http://127.0.0.1:8080/htmldb");
  }
  

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
  }
  

