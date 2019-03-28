import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Readingfromexcel
{ 	
	public static WebDriver driver;
	public static Workbook book;
  @Test(dataProvider="data")
  public void f(String data) throws Exception 
  {
	  driver.findElement(By.xpath("  //*[@id=\"txtsearch\"]")).sendKeys(data);;
	  driver.findElement(By.xpath("//*[@id=\"btnsearch\"]/i")).click();;
	  System.out.println("book start");
	  for(int j=0;j<10;j++)
	  {
		  Thread.sleep(2000);
		String str=driver.findElement(By.xpath("//*[@id='book_list']/ul/li[*]/div[6]")).getText();
		System.out.println("price is"+str);
		
	  }
	
	}
//*[@id="book_list"]/ul/li[1]/div[6]/span[2] 
//*[@id="book_list"]/ul/li[2]/div[5]/span[2]
//*[@id="book_list"]/ul/li[3]/div[6]/span[2]
//*[@id="book_list"]/ul/li[4]/div[6]/span[2]
//*[@id="book_list"]/ul/li[1]/div[6]

	@DataProvider
	public Object[][] data() throws Exception
	{
		Readingfromexcel.Excel1(".\\mock3.1.xlsx");
		Object data[][]=Readingfromexcel.MyDataProvider("Sheet1",1);
		return data;
	}
	
  @BeforeClass
  public void beforeClass() {
  System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
  driver= new FirefoxDriver();
  driver.get(" http://www.meripustak.com/");
  }

  @AfterClass
  public void afterClass()
  {
	  driver.quit();
  }

  public static void Excel1(String fileName)
	{
		try {
			FileInputStream inFile=new FileInputStream(fileName);
			if(fileName.endsWith(".xls"))
			{
				book=new HSSFWorkbook(inFile);
			}
			else if(fileName.endsWith(".xlsx"))
			{
				 book=new XSSFWorkbook(inFile);
			}
		} catch (Exception e) 
		{
			System.out.println("Error with File Reading");
		}
	}
  
  public static  Object[][] MyDataProvider(String sheet,int column) throws Exception
	{
		
		Sheet customSheet =book.getSheet(sheet);
		Object[][] data = new Object[customSheet.getLastRowNum()][column];
		for(int r=1;r<=customSheet.getLastRowNum();r++)
		{
			
			for(int c=0;c<column;c++)
			{
				String cellData=null;
					try
					{
						cellData=customSheet.getRow(r).getCell(c).toString();
						if(cellData.endsWith(".0"))
							cellData=cellData.split("\\.")[0];
							
					}
					catch(NullPointerException N)
					{
						cellData=null;
					}
					System.out.println(cellData);
					data[r-1][c]= cellData;
			}
		}
		
		return data;
		
		
	}

	
	
}
