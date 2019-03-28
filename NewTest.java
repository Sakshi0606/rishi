package CP;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;

	@Test
	public void f() throws Exception {
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(".\\data.xls"));
		HSSFSheet sh = wb.getSheet("Sheet1");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		for (int i = 0; i <= sh.getLastRowNum(); i++) {
			String data = sh.getRow(i).getCell(0).toString();
			driver.get("http://nseindia.com");
			driver.findElement(By.id("keyword")).sendKeys(data);
			driver.findElement(By.xpath("//*[contains(text(),'" + data + "')]")).click();
			TakesScreenshot screen = (TakesScreenshot) driver;
			File src = screen.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File(".\\example4_" + data + ".png"));
			System.out.println("face value is " + driver.findElement(By.id("faceValue")).getText());
			System.out.println("face value is " + driver.findElement(By.xpath("//*[@id='high52']/font")).getText());

		}

	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\vshadmin\\Desktop\\CPSAT_Jars\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
