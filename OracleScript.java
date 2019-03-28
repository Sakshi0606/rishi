package in.lnt.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class OracleScript{

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe ");
		WebDriver driver=new ChromeDriver();
		driver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:17286496247486679950::NO:::");
		driver.findElement(By.name("p_t01")).sendKeys("sys");
		driver.findElement(By.name("p_t02")).sendKeys("Newuser123");
		driver.findElement(By.xpath("//*[@id=\"wwvFlowForm\"]/div[6]/table/tbody/tr/td[3]/table[2]/tbody/tr/td/input[1]")).click();
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.linkText("Login")).click();
		String title =driver.getTitle();
		
		System.out.println("I am on"+title+"Page");
		Thread.sleep(3000);
		driver.quit();
	}

}
