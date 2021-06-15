package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyPersonalInformationTests extends BaseTest {
	
	private static final String SHEET_NAME_LOGIN = "TSu2";
	private static final String SHEET_NAME = "TSu5";

	@BeforeMethod
	public void beforeMethod() {
		driver.navigate().to(ulrHome);
		driver.manage().window().maximize();
		String email = excelReader.getStringData(SHEET_NAME_LOGIN, 6, 3);
		String password = excelReader.getStringData(SHEET_NAME_LOGIN, 7, 3);
		menuNavigationPage.signInClick();
		logInPage.insertEmail(email);
		logInPage.insertPassword(password);
		logInPage.signInButtonClick();
		myAccountPage.myPersonalInformationClick();
	}

	@Test(priority = 1)
	public void radioButtonCheckedTest() {
		myPersonalInformaitionPage.getSelectedMr();
		myPersonalInformaitionPage.mrsRadioButtonClick();

		boolean expectedMrs = excelReader.getStringData(SHEET_NAME, 11, 3).equalsIgnoreCase("true");
		boolean actualMrsValue = myPersonalInformaitionPage.isSelectedMrs();
		assertEquals(actualMrsValue, expectedMrs);

		boolean expectedMr = excelReader.getStringData(SHEET_NAME, 12, 3).equalsIgnoreCase("true");
		boolean actualMrValue = myPersonalInformaitionPage.isSelectedMr();
		assertEquals(actualMrValue, expectedMr);
	}

	@Test(priority = 2)
	public void emptyFirstNameTest() {
		myPersonalInformaitionPage.clearFirstName();
		String oldPassword = excelReader.getStringData(SHEET_NAME, 21, 3);
		myPersonalInformaitionPage.insertOldPassword(oldPassword);
		myPersonalInformaitionPage.saveButtonClick();

		String expectedText = excelReader.getStringData(SHEET_NAME, 26, 3);
		String actualText = myPersonalInformaitionPage.textErrorMessage();
		assertEquals(actualText, expectedText);
	}

	@Test(priority = 3)
	public void emptyLastNameTest() {
		myPersonalInformaitionPage.clearLastName();
		String oldPassword = excelReader.getStringData(SHEET_NAME, 36, 3);
		myPersonalInformaitionPage.insertOldPassword(oldPassword);
		myPersonalInformaitionPage.saveButtonClick();

		String expectedText = excelReader.getStringData(SHEET_NAME, 41, 3);
		String actualText = myPersonalInformaitionPage.textErrorMessage();
		assertEquals(actualText, expectedText);
	}

	@Test(priority = 4)
	public void changeDateOfBirthTest() {
		String day = String.valueOf(excelReader.getIntegerData(SHEET_NAME, 50, 3));
		myPersonalInformaitionPage.insertDayOfBirth(day);
		String month = excelReader.getStringData(SHEET_NAME, 51, 3);
		myPersonalInformaitionPage.insertMonthOfBirth(month);
		String year = String.valueOf(excelReader.getIntegerData(SHEET_NAME, 52, 3));
		myPersonalInformaitionPage.insertYearOfBirth(year);
		String oldPassword = excelReader.getStringData(SHEET_NAME, 53, 3);
		myPersonalInformaitionPage.insertOldPassword(oldPassword);
		myPersonalInformaitionPage.saveButtonClick();

		String expectedText = excelReader.getStringData(SHEET_NAME, 56, 3);
		String actualText = myPersonalInformaitionPage.textGreenMessage();
		assertEquals(actualText, expectedText);
	}

	@Test(priority = 5)
	public void emptyPasswordTest() {
		myPersonalInformaitionPage.saveButtonClick();

		String expectedText = excelReader.getStringData(SHEET_NAME, 70, 3);
		String actualText = myPersonalInformaitionPage.textErrorMessage();
		assertEquals(actualText, expectedText);
	}

	@Test(priority = 6)
	public void invalidPasswordTest() {
		String oldPassword = excelReader.getStringData(SHEET_NAME, 79, 3);
		myPersonalInformaitionPage.insertOldPassword(oldPassword);
		myPersonalInformaitionPage.saveButtonClick();

		String expectedText = excelReader.getStringData(SHEET_NAME, 84, 3);
		String actualText = myPersonalInformaitionPage.textErrorMessage();
		assertEquals(actualText, expectedText);
	}

	@AfterMethod
	public void afterMethod() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
