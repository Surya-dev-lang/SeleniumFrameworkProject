package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class FacebookTest extends Base {

	public WebDriver driver;

	@Test()
	public void facebookTest() throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.get("https://www.facebook.com/");
		System.out.println("This is FB test");
		Thread.sleep(2000);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}


}
