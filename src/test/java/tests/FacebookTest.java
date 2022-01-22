package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class FacebookTest extends Base {

	public WebDriver driver;

	@Test()
	public void facebookTest() throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.close();
	}

}
