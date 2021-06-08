package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Proba {
	@Test
	public void test() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver");
		WebDriver driver = new ChromeDriver();
		// driver.get("https://www.google.com");
		driver.navigate().to("https://www.google.com");
		Thread.sleep(3000);
	}
}
