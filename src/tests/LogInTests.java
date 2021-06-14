package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTests extends BaseTest {

	private static final String SHEET_NAME = "TSu2";

	@BeforeMethod
	public void beforeMethod() {
		driver.navigate().to(ulrHome);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void logInValidCredentials() throws InterruptedException {
		String email = excelReader.getStringData(SHEET_NAME, 6, 3);
		String password = excelReader.getStringData(SHEET_NAME, 7, 3);
		String textForAssertion = excelReader.getStringData(SHEET_NAME, 11, 3);

		logInFormFilling(email, password);
		
		String actualText = mainNavigation.textSignOut();
		assertEquals(actualText, textForAssertion);
	}

	@Test(priority = 2)
	public void logInInvalidPassword() {
		String email = excelReader.getStringData(SHEET_NAME, 20, 3);
		String password = excelReader.getStringData(SHEET_NAME, 21, 3);
		String textForAssertion = excelReader.getStringData(SHEET_NAME, 25, 3);

		logInFormFilling(email, password);
		
		String actualText = logInPage.textInvalidCredentials();
		assertEquals(actualText, textForAssertion);
	}

	@Test(priority = 3)
	public void logInInvalidEmailAddress() {
		String email = excelReader.getStringData(SHEET_NAME, 34, 3);
		String password = excelReader.getStringData(SHEET_NAME, 35, 3);
		String textForAssertion = excelReader.getStringData(SHEET_NAME, 39, 3);

		logInFormFilling(email, password);
		
		String actualText = logInPage.textInvalidCredentials();
		assertEquals(actualText, textForAssertion);
	}

	@Test(priority = 4)
	public void logInEmptyCredentials() {

		String textForAssertion = excelReader.getStringData(SHEET_NAME, 53, 3);
		
		logInFormFilling("", "");

		String actualText = logInPage.textInvalidCredentials();
		assertEquals(actualText, textForAssertion);
	}

	@AfterMethod
	public void afterMethod() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
