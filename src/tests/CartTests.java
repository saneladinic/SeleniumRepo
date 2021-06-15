package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

	private static final String SHEET_NAME_LOGIN = "TSu2";
	private static final String SHEET_NAME = "TSu7";

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
	}

	@Test(priority = 1)
	public void addOneProductToCartTest() throws InterruptedException {
		menuNavigationPage.womenTabClick();
		womanPage.dressesTabClick();
		dressesPage.printedDressNameClick();
		dressesPage.addToCartClick();
		dressesPage.proceedToCheckoutClick();

		int textForAssertion = excelReader.getIntegerData(SHEET_NAME, 12, 3);
		int productCount = cartPage.productCount();
		assertEquals(productCount, textForAssertion);
	}

	@Test(priority = 2)
	public void addOneProductToCartThreeTimesTest() throws InterruptedException {
		menuNavigationPage.womenTabClick();
		womanPage.dressesTabClick();
		dressesPage.printedDressNameClick();
		String quntity = excelReader.getStringData(SHEET_NAME, 23, 3);
		dressesPage.quantityInput(quntity);
		dressesPage.addToCartClick();
		dressesPage.proceedToCheckoutClick();

		String textForAssertion = excelReader.getStringData(SHEET_NAME, 28, 3);
		String actualText = cartPage.textForQuantityInput();
		assertEquals(actualText, textForAssertion);
	}

	@Test(priority = 3)
	public void addSeveralProductTest() {
		menuNavigationPage.womenTabClick();
		womanPage.dressesTabClick();
		dressesPage.addPrintedDress();
		menuNavigationPage.womenTabClick();
		womanPage.dressesTabClick();
		dressesPage.addPrintedSummerDress();
		menuNavigationPage.womenTabClick();
		womanPage.dressesTabClick();
		dressesPage.addPrintedChiffonDress();
		dressesPage.proceedToCheckoutClick();

		int textForAssertion = excelReader.getIntegerData(SHEET_NAME, 53, 3);
		int productCount = cartPage.productCount();
		assertEquals(productCount, textForAssertion);
	}

	@Test(priority = 4)
	public void removeProductFromCartTest() throws InterruptedException {
		menuNavigationPage.womenTabClick();
		womanPage.dressesTabClick();
		dressesPage.printedDressNameClick();
		dressesPage.addToCartClick();
		dressesPage.proceedToCheckoutClick();
		cartPage.removeButtonClick();
		Thread.sleep(3000);
		String textForAssertion = excelReader.getStringData(SHEET_NAME, 68, 3);
		String actualText = cartPage.TextMessageForRemoveProductFromCart();
		assertEquals(actualText, textForAssertion);
	}

	@AfterMethod
	public void afterMethod() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
