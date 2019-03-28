package in.lnt.day1;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrcaleCSS2 {

	public static void main(String[] args) throws InterruptedException {
		String a;
		String b;
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe ");
		WebDriver driver=new ChromeDriver();
		driver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:17286496247486679950::NO:::");
		System.out.println("enter username");
		Scanner sc=new Scanner(System.in);
		a=sc.next();
		driver.findElement(By.cssSelector("input#P11_USERNAME")).clear();
		driver.findElement(By.cssSelector("input#P11_USERNAME")).sendKeys(a);
		//driver.findElement(By.cssSelector("input#P11_PASSWORD")).sendKeys("Newuser123");
		System.out.println("enter password");
		Scanner sc1=new Scanner(System.in);
		b=sc1.next();
		driver.findElement(By.cssSelector("input[type='password']")).clear();
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(b);
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		if (driver.getTitle().equals("Oracle"))
		{
		driver.findElement(By.cssSelector("img[title='Logout']")).click();
		driver.findElement(By.cssSelector("a.htmldbInstruct")).click();
		System.out.println("login done");
		}
		else
		{System.out.println("login fail");}
		Thread.sleep(3000);
		driver.quit();
	}

}
