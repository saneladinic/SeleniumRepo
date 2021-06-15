package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOutTests extends BaseTest {

	private static final String SHEET_NAME = "TSu3";

	@BeforeMethod
	public void beforeMethod() {
		driver.navigate().to(ulrHome);
		driver.manage().window().maximize();
		menuNavigationPage.signInClick();
	}

	@Test(priority = 1)
	public void logOut() {
		String email = excelReader.getStringData(SHEET_NAME, 5, 3);
		String password = excelReader.getStringData(SHEET_NAME, 6, 3);
		logInPage.logInFormFilling(email, password);
		menuNavigationPage.signOutClick();
		
		String textForAssertion = excelReader.getStringData(SHEET_NAME, 10, 3);
		String actualText = menuNavigationPage.textSignIn();
		assertEquals(actualText, textForAssertion);
	}

	@AfterMethod
	public void afterMethod() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
