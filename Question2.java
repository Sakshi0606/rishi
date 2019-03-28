package day3;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import util.BrowserSetup;

public class Question2 {
public static void main(String[] args) throws IOException {

	WebDriver driver = BrowserSetup.browserStart("chrome", "https://nseindia.com");
	FileInputStream inFile = new FileInputStream("C:\\Users\\vshadmin\\Desktop\\Question2.xlsx");
	XSSFWorkbook book = new XSSFWorkbook(inFile);
	XSSFSheet sheet = book.getSheet("Sheet1");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	
	for(int i =0 ; i<=sheet.getLastRowNum();i++)
	{
	String data = sheet.getRow(i).getCell(0).toString();
	System.out.print(data);
	
	Actions  action= new Actions(driver);
	driver.manage().window().maximize();
	 driver.findElement(By.id("keyword")).sendKeys(data);
	WebElement E=driver.findElement(By.xpath("//b[contains(text(), '"+data+"')] "));
	action.moveToElement(E).click(E).perform();	
	
	
	BrowserSetup.getScreenShot("Question1"+i);
	 String myText = driver.findElement(By.xpath("//*[@id=\"faceValue\"]")).getText();
     System.out.println("FaceValue :  " + myText);
     sheet.getRow(i).createCell(1).setCellValue(myText);
     FileOutputStream op = new FileOutputStream("C:\\Users\\vshadmin\\Desktop\\Question2.xlsx");
 	book.write(op);
 	
 	driver.navigate().back();//To go back to main page

	}
	
	
}
}