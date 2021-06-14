package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.LogInPage;
import pages.MainNavigationPage;
import pages.MyAccountPage;
import pages.MyAddressPage;
import pages.MyPersonalInformationPage;
import pages.MyWishlistsPage;
import pages.YourAddressPage;

public class BaseTest {

	private static final String SHEET_NAME = "TSu2";
	WebDriver driver;
	ExcelReader excelReader;
	String ulrHome;
	LogInPage logInPage;
	MainNavigationPage mainNavigation;
	MyAccountPage myAccountPage;
	MyAddressPage myAddressPage;
	YourAddressPage yourAddressPage;
	MyPersonalInformationPage myPersonalInformaitionPage;
	MyWishlistsPage myWishlistsPage;
	
	@BeforeClass
	public void beforeClass() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver");
		driver = new ChromeDriver();
		ulrHome = "http://automationpractice.com/index.php";
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		excelReader = new ExcelReader("data/projekat.xlsx");
		logInPage = new LogInPage(driver);
		mainNavigation = new MainNavigationPage(driver);
		myAccountPage = new MyAccountPage(driver);
		myAddressPage = new MyAddressPage(driver);
		yourAddressPage = new YourAddressPage(driver);
		myPersonalInformaitionPage=new MyPersonalInformationPage(driver);
		myWishlistsPage=new MyWishlistsPage(driver);
	}
	
	public void logInFormFilling(String email, String password) {
		mainNavigation.signInClick();
		logInPage.insertEmail(email);
		logInPage.insertPassword(password);
		logInPage.signInButtonClick();
	}

	public void logIn() {
		String email = excelReader.getStringData(SHEET_NAME, 6, 3);
		String password = excelReader.getStringData(SHEET_NAME, 7, 3);
		mainNavigation.signInClick();
		logInPage.insertEmail(email);
		logInPage.insertPassword(password);
		logInPage.signInButtonClick();
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
