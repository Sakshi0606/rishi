package day3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import util.BrowserSetup;

public class CpsatEqityAssignment {

	public static void main(String[] args) {
	
		

		WebDriver driver = BrowserSetup.browserStart("chrome","https://nseindia.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
			Actions  action= new Actions(driver);
		
			 driver.findElement(By.id("keyword")).sendKeys("Reliance Industries Limited");
			WebElement E=driver.findElement(By.xpath("//*[(text()='Reliance Industries Limited')]"));
			action.moveToElement(E).click(E).perform();	
		//	action.sendKeys(driver.findElement(By.id("keyword")),Keys.ENTER);
					
	}
}
