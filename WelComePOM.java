package CP;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WelComePOM
{
	WebDriver driver;
	WelComePOM(WebDriver idriver)
	{
		this.driver=idriver;
	}

	By E_MEN=By.xpath("//*[text()='MEN']");
	By E_Shoes=By.xpath("//*[text()='Shoes']");
	By E_Cat=By.xpath("/html/body/main/nav/div[1]/div/ul/li[4]/div/div/ul/li[3]/div/ul/li[1]/div/ul/li");
	By E_AllStore=By.xpath("//*[text()='All Stores']");
	By E_City=By.xpath("//*[@id='city-name']");
	By E_Store=By.xpath("//*[@id='selectedPOS']");

	public void getMenShoeCategory()
	{
		new Actions(driver).moveToElement(driver.findElement(E_MEN)).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Actions(driver).moveToElement(driver.findElement(E_Shoes)).build().perform();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> allShoe=driver.findElements(E_Cat);
		
		for(int i=0;i<=allShoe.size();i++)
		{
			System.out.println(allShoe.get(i).getText());
		}
	}
	
	public void getMumbaiStore()
	{
		driver.findElement(E_AllStore).click();
		new Select(driver.findElement(E_City)).selectByVisibleText("Mumbai");
		System.out.println(driver.findElement(E_Store).getText());
	}

	public boolean isCityPresent(String City)
	{
	String Cities=	driver.findElement(E_City).getText();
	Boolean b=Cities.contains(City);
	return b;
	}
	
	
	
	
	
	
	
}
