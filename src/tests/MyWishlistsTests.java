package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyWishlistsTests extends BaseTest {

	private static final String SHEET_NAME_LOGIN = "TSu2";
	private static final String SHEET_NAME = "TSu6";

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
		myAccountPage.myWishlistsClick();
	}

	@Test(priority = 1)
	public void addOneWishlistTest() {
		String name = excelReader.getStringData(SHEET_NAME, 6, 3);
		myWishlistsPage.insertNameForWishlist(name);
		myWishlistsPage.saveButtonWishListClisck();

		int textForAssertion = excelReader.getIntegerData(SHEET_NAME, 11, 3);
		int wishListCount = myWishlistsPage.wishListCount();
		assertEquals(wishListCount, textForAssertion);
	}

	@Test(priority = 2)
	public void addSeveralWishlistTest() {
		String name = excelReader.getStringData(SHEET_NAME, 20, 3);
		myWishlistsPage.insertNameForWishlist(name);
		myWishlistsPage.saveButtonWishListClisck();
		String name1 = excelReader.getStringData(SHEET_NAME, 22, 3);
		myWishlistsPage.insertNameForWishlist(name1);
		myWishlistsPage.saveButtonWishListClisck();
		String name2 = excelReader.getStringData(SHEET_NAME, 24, 3);
		myWishlistsPage.insertNameForWishlist(name2);
		myWishlistsPage.saveButtonWishListClisck();

		int textForAssertion = excelReader.getIntegerData(SHEET_NAME, 27, 3);
		int wishListCount = myWishlistsPage.wishListCount();
		assertEquals(wishListCount, textForAssertion);
	}

	@Test(priority = 3)
	public void deleteOneWishlistTest() throws InterruptedException {
		myWishlistsPage.deleteButtonClick();
		Thread.sleep(3000);
		int textForAssertion = excelReader.getIntegerData(SHEET_NAME, 40, 3);
		int wishListCount = myWishlistsPage.wishListCount();
		assertEquals(wishListCount, textForAssertion);
	}

	@AfterMethod
	public void afterMethod() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
