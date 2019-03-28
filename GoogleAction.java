package day2;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import util.BrowserSetup;
public class GoogleAction {

	
	public static void main(String[] args) {
		WebDriver driver = BrowserSetup.browserStart("chrome","http://google.com");
	//WebDriver driver1 = BrowserSetup.browserStart("chrome");
		Actions  action= new Actions(driver);
	
		WebElement search = driver.findElement(By.name("q"));
	
		
	Action	a= action.moveToElement(search)
		.keyDown(Keys.SHIFT)
		.sendKeys(search, "lnt")
		.keyUp(Keys.SHIFT)
		.doubleClick(search)
		.contextClick(search)
		//.sendKeys(search, Keys.ENTER)
		.build();
	
		a.perform();
		
		
	}

}
