package day3;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import util.BrowserSetup;

public class Question1 {
public static void main(String[] args) {

	WebDriver driver = BrowserSetup.browserStart("chrome", "https://nseindia.com");
	
	Actions action = new Actions(driver);
	WebElement search = driver.findElement(By.name("companyED") );
	 
	Action a =	action.moveToElement(search).
	sendKeys(search, "Reliance Industries Limited")
	.build();
	a.perform();
	driver.findElement(By.xpath("//*[text()='Reliance Industries Limited'] ")).click();
	BrowserSetup.getScreenShot("Question1");
	 String myText = driver.findElement(By.xpath("//*[@id=\"faceValue\"]")).getText();
     System.out.println("FaceValue :  " + myText);
	
     String myText1 = driver.findElement(By.xpath("//*[@id=\"high52\"]/font")).getText();
     System.out.println("52 week high :  " + myText1);
     
     String myText2 = driver.findElement(By.xpath("//*[@id=\"low52\"]/font")).getText();
     System.out.println("52 week low :  " + myText2);
	
}
}