package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyPersonalInformationTests extends BaseTest {

	private static final String SHEET_NAME = "TSu5";

	@BeforeMethod
	public void beforeMethod() {
		driver.navigate().to(ulrHome);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void radioButtonCheckedTest() {
		logIn();
		myAccountPage.myPersonalInformationClick();
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
		logIn();
		myAccountPage.myPersonalInformationClick();
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
		logIn();
		myAccountPage.myPersonalInformationClick();
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
		logIn();
		myAccountPage.myPersonalInformationClick();

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
		logIn();
		myAccountPage.myPersonalInformationClick();
		myPersonalInformaitionPage.saveButtonClick();

		String expectedText = excelReader.getStringData(SHEET_NAME, 70, 3);
		String actualText = myPersonalInformaitionPage.textErrorMessage();
		assertEquals(actualText, expectedText);
	}

	@Test(priority = 6)
	public void invalidPasswordTest() {
		logIn();
		myAccountPage.myPersonalInformationClick();
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
