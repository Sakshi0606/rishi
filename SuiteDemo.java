package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class SuiteDemo {
  @Test
  public void Test1() {
	  System.out.println("Test 1");  }
 @Test
  public void Test2() {
	  System.out.println("Test 2");  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method test");
  }
  

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Method  test");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before  class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After class  test");
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before  test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After  test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Before  suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("After Suite");
  }

}
