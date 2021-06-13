package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {

	WebDriver driver;
	WebElement myAddresses;
	WebElement myPersonalInformation;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getMyAddresses() {
		return driver.findElement(By.className("icon-building"));
	}

	public WebElement getMyPersonalInformation() {
		return driver.findElement(By.className("icon-user"));
	}

	public void myAddressesClick() {
		this.getMyAddresses().click();
	}

	public void myPersonalInformationClick() {
		this.getMyPersonalInformation().click();
	}
}
