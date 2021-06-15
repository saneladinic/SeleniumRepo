package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.CartPage;
import pages.DressesPage;
import pages.LogInPage;
import pages.MenuNavigationPage;
import pages.MyAccountPage;
import pages.MyAddressPage;
import pages.MyPersonalInformationPage;
import pages.MyWishlistsPage;
import pages.WomenPage;
import pages.YourAddressPage;

public class BaseTest {

	WebDriver driver;
	ExcelReader excelReader;
	String ulrHome;
	LogInPage logInPage;
	MenuNavigationPage menuNavigationPage;
	MyAccountPage myAccountPage;
	MyAddressPage myAddressPage;
	YourAddressPage yourAddressPage;
	MyPersonalInformationPage myPersonalInformaitionPage;
	MyWishlistsPage myWishlistsPage;
	WomenPage womanPage;
	DressesPage dressesPage;
	CartPage cartPage;

	@BeforeClass
	public void beforeClass() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver");
		driver = new ChromeDriver();
		ulrHome = "http://automationpractice.com/index.php";
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		excelReader = new ExcelReader("data/projekat.xlsx");
		logInPage = new LogInPage(driver);
		menuNavigationPage = new MenuNavigationPage(driver);
		myAccountPage = new MyAccountPage(driver);
		myAddressPage = new MyAddressPage(driver);
		yourAddressPage = new YourAddressPage(driver);
		myPersonalInformaitionPage = new MyPersonalInformationPage(driver);
		myWishlistsPage = new MyWishlistsPage(driver);
		womanPage = new WomenPage(driver);
		dressesPage = new DressesPage(driver);
		cartPage = new CartPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
