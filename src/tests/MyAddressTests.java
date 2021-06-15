package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAddressTests extends BaseTest {

	private static final String SHEET_NAME_LOGIN = "TSu2";
	private static final String SHEET_NAME = "TSu4";

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
		myAccountPage.myAddressesClick();
	}

	@Test(priority = 1)
	public void updateAddressTest() {
		myAddressPage.updateButtonClick();
		String newAddress = excelReader.getStringData(SHEET_NAME, 8, 3);
		yourAddressPage.updateAddress(newAddress);
		yourAddressPage.saveButtonClick();

		String textForAssertion = excelReader.getStringData(SHEET_NAME, 11, 3);
		String actualText = myAddressPage.textMyAddress();
		assertEquals(actualText, textForAssertion);
	}

	@Test(priority = 2)
	public void addNewAddressTest() throws InterruptedException {
		myAddressPage.addNewAddressButtonClick();
		String address = excelReader.getStringData(SHEET_NAME, 22, 3);
		yourAddressPage.insertAddress(address);
		String city = excelReader.getStringData(SHEET_NAME, 23, 3);
		yourAddressPage.insertCity(city);
		yourAddressPage.stateDropDownManuClick();
		Thread.sleep(2000);
		String postcode = excelReader.getStringData(SHEET_NAME, 25, 3);
		yourAddressPage.insertPostcode(postcode);
		Thread.sleep(2000);
		String homePhone = excelReader.getStringData(SHEET_NAME, 26, 3);
		yourAddressPage.insertHomePhone(homePhone);
		String mobilePhone = excelReader.getStringData(SHEET_NAME, 27, 3);
		yourAddressPage.insertMobilePhone(mobilePhone);
		String nameAddress = excelReader.getStringData(SHEET_NAME, 28, 3);
		yourAddressPage.insertNameForAddress(nameAddress);
		yourAddressPage.saveButtonClick();

		int textForAssertion = excelReader.getIntegerData(SHEET_NAME, 30, 3);
		int addressCount = myAddressPage.addressCount();
		assertEquals(addressCount, textForAssertion);

	}

	@Test(priority = 3)
	public void removeAddressTest() {
		myAddressPage.deleteButtonClick();

		int textForAssertion = excelReader.getIntegerData(SHEET_NAME, 42, 3);
		int addressCount = myAddressPage.addressCount();
		assertEquals(addressCount, textForAssertion);
	}

	@AfterMethod
	public void afterMethod() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
