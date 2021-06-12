package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	
	WebDriver driver;
	WebElement myAddresses;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getMyAddresses() {
		return driver.findElement(By.className("icon-building"));
	}

	public void myAddressesClick() {
		this.getMyAddresses().click();
	}
}
