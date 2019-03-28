package in.lnt.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstScript {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo\\Desktop\\selenium-data-master\\hey\\TSL756\\Drivers\\chromedriver.exe ");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.seleniumhq.org/");
		driver.findElement(By.linkText("Download")).click();
		String title =driver.getTitle();
		driver.findElement(By.name("q")).sendKeys("LNT");
		System.out.println("I am on"+title+"Page");
		Thread.sleep(3000);
		driver.quit();
	}

}
