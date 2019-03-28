package in.lnt.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrcaleCSS {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe ");
		WebDriver driver=new ChromeDriver();
		driver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:17286496247486679950::NO:::");
		driver.findElement(By.cssSelector("input#P11_USERNAME")).sendKeys("sys");
		//driver.findElement(By.cssSelector("input#P11_PASSWORD")).sendKeys("Newuser123");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Newuser123");
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		driver.findElement(By.cssSelector("img[title='Logout']")).click();
		driver.findElement(By.cssSelector("a.htmldbInstruct")).click();
		String title =driver.getTitle();
		System.out.println("I am on"+title+"Page");
		Thread.sleep(3000);
		driver.quit();
	}

}
