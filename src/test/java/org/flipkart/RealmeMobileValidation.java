package org.flipkart;


import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RealmeMobileValidation {

	static WebDriver driver;
	
	static long startTime;
	static String name1;
	
    @BeforeClass
   public static void beforeClass() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://www.flipkart.com/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
    }
	
	@AfterClass
	 public static void afterClass() {
    	driver.quit();
    	}

    @Before
   public  void beforeScript() {
    	 startTime =System.currentTimeMillis();
    	
    }
    @After
	 public  void afterScript() {
    	long endTime =System.currentTimeMillis();
   	System.out.println("Time taken is :"+ (endTime-startTime));
    }
    
	@Test
	public void method1() {
		try {
	   WebElement close = driver .findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
	   close.click();
		} catch (Exception e) {
		}
	}
	
	@Test
	public void method2() {
		WebElement search = driver .findElement(By.name("q"));
		search.sendKeys("realme",Keys.ENTER);
		
	}
	@Test
	public void method3() {
		WebElement mobilename =driver .findElement(By.xpath("(//div[contains(text(),'realme')])[1]"));
		 name1 = mobilename.getText();
		System.out.println(name1);
		mobilename.click();
	}
		@Test
		public void method4() {	
		String parent = driver.getWindowHandle();
		Set<String> children  =driver.getWindowHandles();
		
		for (String x : children) {
			
			if(!parent.equals(x)) {
				driver.switchTo().window(x);
				
			}
		}}

		@Test
		public void method5() {	
			WebElement mobilename2 = driver .findElement(By.xpath("//span[@class='B_NuCI']"));
			
			String name2 = mobilename2.getText();
			System.out.println(name2);
		
		if(name1.equals(name2)) {
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
		}
			
}
