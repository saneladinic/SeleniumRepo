package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddressTests extends BaseTest {

	@BeforeMethod
	public void beforMethod() {
		driver.navigate().to(ulrHome);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void updateAddresstest() {

		String newAddress = excelReader.getStringData("TSu4", 8, 3);
		logIn();
		myAccountPage.myAddressesClick();
		myAddressPage.updateButtonClick();
		yourAddressPage.updateAddress(newAddress);
		yourAddressPage.saveButtonClick();

		String textForAssertion = excelReader.getStringData("TSu4", 11, 3);
		String actualText = myAddressPage.textMyAddress();
		assertEquals(actualText, textForAssertion);

	}

	@Test(priority = 2)
	public void addNewAddressTest() throws InterruptedException {
		logIn();
		myAccountPage.myAddressesClick();
		myAddressPage.addNewAddressButtonClick();
		String address = excelReader.getStringData("TSu4", 22, 3);
		yourAddressPage.insertAddress(address);
		String city = excelReader.getStringData("TSu4", 23, 3);
		yourAddressPage.insertCity(city);
		yourAddressPage.stateDropDownManuClick();
		Thread.sleep(2000);
		String postcode = excelReader.getStringData("TSu4", 25, 3);
		yourAddressPage.insertPostcode(postcode);
		Thread.sleep(2000);
		String homePhone = excelReader.getStringData("TSu4", 26, 3);
		yourAddressPage.insertHomePhone(homePhone);
		String mobilePhone = excelReader.getStringData("TSu4", 27, 3);
		yourAddressPage.insertMobilePhone(mobilePhone);
		String nameAddress = excelReader.getStringData("TSu4", 28, 3);
		yourAddressPage.insertNameForAddress(nameAddress);
		yourAddressPage.saveButtonClick();

		int textForAssertion = excelReader.getIntegerData("TSu4", 30, 3);
		int addressCount = myAddressPage.addresaCount();
		assertEquals(addressCount, textForAssertion);

	}

	@Test(priority = 3)
	public void removeAddressTest() throws InterruptedException {
		logIn();
		myAccountPage.myAddressesClick();
		Thread.sleep(5000);
		myAddressPage.deleteButtonClick();

		int textForAssertion = excelReader.getIntegerData("TSu4", 42, 3);
		int addressCount = myAddressPage.addresaCount();
		assertEquals(addressCount, textForAssertion);
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
	public void afterMethod() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
