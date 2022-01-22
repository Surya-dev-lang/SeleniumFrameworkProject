package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class GoogleTest extends Base {
	
	public WebDriver driver;
	
	@Test()
	public void googleTest() throws IOException, InterruptedException {
		
		driver = initializeDriver();
		driver.get("https://www.google.com/");
		System.out.println("This is google test");
		Thread.sleep(2000);
		Assert.assertTrue(false);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
