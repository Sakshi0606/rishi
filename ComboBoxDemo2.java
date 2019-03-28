package in.lnt.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ComboBoxDemo2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe ");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.blazedemo.com/");
		Select select=new Select(driver.findElement(By.name("fromPort")));
		select.selectByValue("Boston");
		System.out.println(driver.findElement(By.name("fromPort")).getText());
		//select.selectByIndex(4);
		//select.selectByVisibleText("Mexico City");
		List<WebElement> ls =select.getOptions();
		for(int i=0;i<ls.size();i++)
		{
			System.out.println(ls.get(i).getText());
		}
		new Select (driver.findElement(By.name("toPort"))).selectByVisibleText("Rome");
		driver.findElement(By.cssSelector("input[value='Find Flights']")).click();
		//driver.findElement(By.cssSelector("input[value='Choose This Flight']")).click();//first method
		List<WebElement> place= driver.findElements(By.cssSelector("input[value='Choose This Flight']"));//second method
		place.get(4).click();
		driver.findElement(By.id("inputName")).clear();
		driver.findElement(By.id("inputName")).sendKeys("sakshi");
		driver.findElement(By.id("address")).clear();
		driver.findElement(By.id("address")).sendKeys("sushil kunj");
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys("gwalior");
		driver.findElement(By.id("state")).clear();
		driver.findElement(By.id("state")).sendKeys("Mp");
		driver.findElement(By.id("zipCode")).clear();
		driver.findElement(By.id("zipCode")).sendKeys("22445");
		Select card=new Select(driver.findElement(By.id("cardType")));
		card.selectByValue("visa");
		driver.findElement(By.id("creditCardMonth")).clear();
		driver.findElement(By.id("creditCardMonth")).sendKeys("10");
		driver.findElement(By.id("creditCardNumber")).clear();
		driver.findElement(By.id("creditCardNumber")).sendKeys("224577881112");
		driver.findElement(By.id("creditCardYear")).clear();
		driver.findElement(By.id("creditCardYear")).sendKeys("2022");
		driver.findElement(By.id("nameOnCard")).clear();
		driver.findElement(By.id("nameOnCard")).sendKeys("sakshi saxena");
		driver.findElement(By.cssSelector("input[value='Purchase Flight']")).click();
		System.out.println("purchase done");
		Thread.sleep(5000);
		driver.quit();
	}

}
