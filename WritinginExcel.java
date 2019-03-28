package day3;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.BrowserSetup;

public class WritinginExcel {

	public static void main(String[] args)throws Exception {
		
	//	WebDriver driver = BrowserSetup.browserStart("chrome","http://127.0.0.1:8080/htmldb/f?p=4550:11:9296082441459421866::NO:::");
		
		FileInputStream inFile = new FileInputStream("C:\\Users\\vshadmin\\Desktop\\Book1.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(inFile);
		XSSFSheet sheet = book.getSheet("Sheet1");
		
	//	sheet.getRow(2).getCell(1).setCellValue("LNT");
	//	sheet.getRow(2).getCell(1).setCellValue("LNT");
		//sheet.createRow(3).createCell(2).setCellValue("LNT");
		
		
		FileOutputStream op = new FileOutputStream("C:\\Users\\vshadmin\\Desktop\\Book1.xlsx");
		book.write(op);
	}

}
