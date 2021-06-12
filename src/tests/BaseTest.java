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
import pages.YourAddressPage;

public class BaseTest {

	WebDriver driver;
	ExcelReader excelReader;
	String ulrHome;
	LogInPage logInPage;
	MainNavigationPage mainNavigation;
	MyAccountPage myAccountPage;
	MyAddressPage myAddressPage;
	YourAddressPage yourAddressPage;

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
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
