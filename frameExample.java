package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.BrowserSetup;

public class frameExample {

	public static void main(String[] args) {
		
		WebDriver driver = BrowserSetup.browserStart("chrome","file:///C:/Users/vshadmin/Desktop/frame.html");
		driver.switchTo().frame(0);
		driver.findElement(By.name("q")).sendKeys("LNT");
		//driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		
		
		//driver.switchTo().frame(1);
		driver.switchTo().frame("new");
		driver.findElement(By.name("userName")).sendKeys("123");
		
		driver.switchTo().defaultContent();
		//driver.switchTo().frame(2);
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe[3]")));
		driver.findElement(By.name("p_t01")).sendKeys("sys");
		driver.findElement(By.name("p_t02")).sendKeys("Newuser123");
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		driver.findElement(By.cssSelector("img[title='Logout']")).click();
		driver.findElement(By.cssSelector("a.htmldbInstruct")).click();

	}

}
