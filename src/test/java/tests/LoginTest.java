package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {

	public WebDriver driver;
	LandingPage landingpage;
	LoginPage loginpage;
	AccountPage accountpage;
	Logger log;

	@Test(dataProvider = "getLoginData")
	public void login(String email, String password, String expectedStatus) throws IOException, InterruptedException {

		landingpage = new LandingPage(driver);
		landingpage.myAccountDropdown().click();
		landingpage.loginOption().click();

		Thread.sleep(2000);
		loginpage = new LoginPage(driver);
		// loginpage.emailAddressField().sendKeys(prop.getProperty("email"));
		// loginpage.passwordField().sendKeys(prop.getProperty("password"));
		loginpage.emailAddressField().sendKeys(email);
		loginpage.passwordField().sendKeys(password);
		loginpage.loginButton().click();
		log.debug("Login Button got clicked");

		accountpage = new AccountPage(driver);
		String actualStatus = null;

		try {
			if (accountpage.editAccountInfoOption().isDisplayed()) {
				actualStatus = "successful";
				log.debug("User got logged in");
			}

		} catch (Exception e) {
			actualStatus = "failure";
			log.debug("User didn't got logged in");

		}

		AssertJUnit.assertEquals(expectedStatus, actualStatus);

	}

	@BeforeMethod
	public void openApplication() throws IOException {
		driver = initializeDriver();
		log = LogManager.getLogger(LoginTest.class.getName());
		log.debug("Broswer got lunched");
		driver.get(prop.getProperty("url"));
		log.debug("URL got opened");
		
	}

	@DataProvider
	public Object[][] getLoginData() {

		/*
		Object[][] data = { { "srknt.sahu90@yahoo.com", "12345", "successful" },
				{ "srknt.sahu90@yahoo.com", "123456", "failure" } };
				*/
		
		Object[][] data = { { "srknt.sahu90@yahoo.com", "12345", "successful" }};
		return data;
	}

	@AfterMethod
	public void closure() {
		driver.quit();
	}

}
