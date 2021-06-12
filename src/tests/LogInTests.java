package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTests extends BaseTest {

	@BeforeMethod
	public void beforMethod() {
		driver.navigate().to(ulrHome);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void logInValidCredentials() throws InterruptedException {
		String email = excelReader.getStringData("TSu2", 6, 3);
		String password = excelReader.getStringData("TSu2", 7, 3);
		String textForAssertion = excelReader.getStringData("TSu2", 11, 3);

		logInFormFilling(email, password);
		String actualText = mainNavigation.textSingOut();
		assertEquals(actualText, textForAssertion);
	}

	@Test(priority = 2)
	public void logInInvalidPassword() {
		String email = excelReader.getStringData("TSu2", 20, 3);
		String password = excelReader.getStringData("TSu2", 21, 3);
		String textForAssertion = excelReader.getStringData("TSu2", 25, 3);

		logInFormFilling(email, password);
		String actualText = logInPage.textInvalidCredentials();
		assertEquals(actualText, textForAssertion);
	}

	@Test(priority = 3)
	public void logInInvalidEmailAddress() {
		String email = excelReader.getStringData("TSu2", 34, 3);
		String password = excelReader.getStringData("TSu2", 35, 3);
		String textForAssertion = excelReader.getStringData("TSu2", 39, 3);

		logInFormFilling(email, password);
		String actualText = logInPage.textInvalidCredentials();
		assertEquals(actualText, textForAssertion);
	}

	@Test(priority = 4)
	public void logInEmptyCredentials() {

		String textForAssertion = excelReader.getStringData("TSu2", 53, 3);
		logInFormFilling("", "");

		String actualText = logInPage.textInvalidCredentials();
		assertEquals(actualText, textForAssertion);
	}

	public void logInFormFilling(String email, String password) {
		mainNavigation.singInClick();
		logInPage.insertEmail(email);
		logInPage.insertPassword(password);
		logInPage.signInButtonClick();
	}

	@AfterMethod
	public void AfterMethod() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
