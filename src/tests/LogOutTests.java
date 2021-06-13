package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOutTests extends BaseTest {

	@BeforeMethod
	public void beforeMethod() {
		driver.navigate().to(ulrHome);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void logOut() {
		String email = excelReader.getStringData("TSu3", 5, 3);
		String password = excelReader.getStringData("TSu3", 6, 3);
		String textForAssertion = excelReader.getStringData("TSu3", 10, 3);

		logInFormFilling(email, password);
		mainNavigation.signOutClick();

		String actualText = mainNavigation.textSignIn();
		assertEquals(actualText, textForAssertion);
	}

	public void logInFormFilling(String email, String password) {
		mainNavigation.signInClick();
		logInPage.insertEmail(email);
		logInPage.insertPassword(password);
		logInPage.signInButtonClick();
	}

	@AfterMethod
	public void afterMethod() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
