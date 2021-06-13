package tests;

import static org.testng.Assert.assertEquals;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyPesonalInformationTests extends BaseTest {

	@BeforeMethod
	public void beforMethod() {
		driver.navigate().to(ulrHome);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void radioBottunCheckedTest() {
		logIn();
		myAccountPage.myPersonalInformationClick();
		myPersonalInformaitionPage.getSelectedMr();
		myPersonalInformaitionPage.mrsRadioButtonClick();

		boolean expectedMrs = excelReader.getStringData("TSu5", 11, 3).equalsIgnoreCase("true");
		boolean actualMrsValue = myPersonalInformaitionPage.isSelectedMrs();
		assertEquals(actualMrsValue, expectedMrs);

		boolean expectedMr = excelReader.getStringData("TSu5", 12, 3).equalsIgnoreCase("true");
		boolean actualMrValue = myPersonalInformaitionPage.isSelectedMr();
		assertEquals(actualMrValue, expectedMr);
	}

	@Test(priority = 2)
	public void emptyFirstNameTest() {
		logIn();
		myAccountPage.myPersonalInformationClick();
		myPersonalInformaitionPage.clearFirstName();
		String oldPassword = excelReader.getStringData("TSu5", 21, 3);
		myPersonalInformaitionPage.insertOldPassword(oldPassword);
		myPersonalInformaitionPage.saveButtonClick();

		String expectedText = excelReader.getStringData("TSu5", 26, 3);
		String actualText = myPersonalInformaitionPage.textErrorMessage();
		assertEquals(actualText, expectedText);
	}

	@Test(priority = 3)
	public void emptyLastNameTest() {
		logIn();
		myAccountPage.myPersonalInformationClick();
		myPersonalInformaitionPage.clearLastName();
		String oldPassword = excelReader.getStringData("TSu5", 36, 3);
		myPersonalInformaitionPage.insertOldPassword(oldPassword);
		myPersonalInformaitionPage.saveButtonClick();

		String expectedText = excelReader.getStringData("TSu5", 41, 3);
		String actualText = myPersonalInformaitionPage.textErrorMessage();
		assertEquals(actualText, expectedText);
	}

	@Test(priority = 4)
	public void changeDateOfBirthTest() {
		logIn();
		myAccountPage.myPersonalInformationClick();

		String day = String.valueOf(excelReader.getIntegerData("TSu5", 50, 3));
		myPersonalInformaitionPage.insertDayOfBirth(day);
		String month = excelReader.getStringData("TSu5", 51, 3);
		myPersonalInformaitionPage.insertMonthOfBirth(month);
		String year = String.valueOf(excelReader.getIntegerData("TSu5", 52, 3));
		myPersonalInformaitionPage.insertYearOfBirth(year);
		String oldPassword = excelReader.getStringData("TSu5", 53, 3);
		myPersonalInformaitionPage.insertOldPassword(oldPassword);

		myPersonalInformaitionPage.saveButtonClick();

		String expectedText = excelReader.getStringData("TSu5", 56, 3);
		String actualText = myPersonalInformaitionPage.textGreenMessage();
		assertEquals(actualText, expectedText);
	}

	@Test(priority = 5)
	public void emptyPasswordTest() {
		logIn();
		myAccountPage.myPersonalInformationClick();
		myPersonalInformaitionPage.saveButtonClick();

		String expectedText = excelReader.getStringData("TSu5", 70, 3);
		String actualText = myPersonalInformaitionPage.textErrorMessage();
		assertEquals(actualText, expectedText);
	}

	@Test(priority = 6)
	public void invalidPasswordTest() {
		logIn();
		myAccountPage.myPersonalInformationClick();
		String oldPassword = excelReader.getStringData("TSu5", 79, 3);
		myPersonalInformaitionPage.insertOldPassword(oldPassword);

		myPersonalInformaitionPage.saveButtonClick();

		String expectedText = excelReader.getStringData("TSu5", 84, 3);
		String actualText = myPersonalInformaitionPage.textErrorMessage();
		assertEquals(actualText, expectedText);
	}

	public void logIn() {
		String email = excelReader.getStringData("TSu2", 6, 3);
		String password = excelReader.getStringData("TSu2", 7, 3);
		mainNavigation.signInClick();
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
