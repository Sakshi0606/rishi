package day3;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.BrowserSetup;

public class ExcelDemo1 {

	public static void main(String[] args)throws Exception {
		
		WebDriver driver = BrowserSetup.browserStart("chrome","http://127.0.0.1:8080/htmldb/f?p=4550:11:9296082441459421866::NO:::");
		
		FileInputStream inFile = new FileInputStream("C:\\Users\\lenovo\\Desktop\\Book1.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(inFile);
		XSSFSheet sheet = book.getSheet("Sheet1");
		
		for(int i =0 ; i<=sheet.getLastRowNum();i++)
		{
		String data = sheet.getRow(i).getCell(0).toString();
		System.out.print(data);
		driver.findElement(By.cssSelector("input#P11_USERNAME")).sendKeys(data);
		
		String data1 = sheet.getRow(i).getCell(1).toString();
		System.out.println("  "+data1);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(data1);
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		
		
		
		if (driver.getTitle().equals("Oracle"))
		{
		
		System.out.println("login done");
		
		driver.findElement(By.cssSelector("img[title='Logout']")).click();
		driver.findElement(By.cssSelector("a.htmldbInstruct")).click();
		}
		else
		{
			System.out.println("login fail");}
		}
	}

}
