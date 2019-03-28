package in.lnt.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ComboBoxDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe ");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.blazedemo.com/");
		Select select=new Select(driver.findElement(By.name("fromPort")));
		//select.selectByValue("Boston");
		//select.selectByIndex(4);
		select.selectByVisibleText("Mexico City");
		Thread.sleep(3000);
		driver.quit();
	}

}
