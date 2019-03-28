package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

import util.BrowserSetup;
  
public class ScreenShot {
	
	public static void main(String[] args) {
		WebDriver driver = BrowserSetup.browserStart("firefox","http://jqueryui.com/droppable/");
		Actions  action= new Actions(driver);
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement srcElement = driver.findElement(By.id("draggable"));
		WebElement desElement = driver.findElement(By.id("droppable"));
		action.dragAndDrop(srcElement, desElement).perform();
		/*TakesScreenshot screen =(TakesScreenshot)driver;
		
		File src = screen.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src,new File(".\\dragNDropfirefox.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		BrowserSetup.getScreenShot("abc");//To call time time stamp
		
	}
}
