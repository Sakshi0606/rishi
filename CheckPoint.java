package in.lnt.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class CheckPoint{

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe ");
		WebDriver driver=new ChromeDriver();
		driver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:17286496247486679950::NO:::");
		WebElement E = driver.findElement(By.id("P11_USERNAME"));
		boolean isenabled = E.isDisplayed();
		boolean isdisplayed = E.isEnabled();
		
		String sz= E.getAttribute("Size");
		String typ= E.getAttribute("type");
		
		if(isdisplayed==true && isenabled==true&&sz.equals("30")&&typ.equals("text"))	
			/*correct test case*/
		//if(isdisplayed==true && isenabled==true&&sz.equals("30")&&typ.equals("radio"))
			/*Incorrect test case*/
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test failed");
		}
		
		
	
		Thread.sleep(1000);
		driver.quit();
	}

}
