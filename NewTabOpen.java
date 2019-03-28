package day2;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import util.BrowserSetup;

public class NewTabOpen {

	public static void main(String[] args) {
		
		WebDriver driver = BrowserSetup.browserStart("chrome","https://www.seleniumhq.org/");
		Actions  action= new Actions(driver);
		WebElement download = driver.findElement(By.xpath("//*[@id=\"menu_download\"]/a"));
		
		String ParentID = driver.getWindowHandle();//To get Id of parent tab
		Action	a= action.moveToElement(download)
				.keyDown(Keys.CONTROL).click()
				.build();
			a.perform();
			
			
		Set<String>allWin = driver.getWindowHandles();
		Iterator<String>itr = allWin.iterator();
		
		
		while(itr.hasNext())
		{
			String ID = itr.next();
				System.out.println(ID);
				if(!(ID.equals(ParentID)))
				{
					driver.switchTo().window(ID);
					System.out.println("you are on"+driver.getTitle());
					driver.close();
				}
				driver.switchTo().window(ParentID);
		}
		
	}
}
