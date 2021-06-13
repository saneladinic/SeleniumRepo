package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainNavigationPage {

	WebDriver driver;
	WebElement signIn;
	WebElement signOut;

	public MainNavigationPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSignIn() {
		return driver.findElement(By.className("login"));
	}

	public WebElement getSignOut() {
		return driver.findElement(By.className("logout"));
	}

	public String textSignOut() {
		return this.getSignOut().getText();
	}

	public void signOutClick() {
		this.getSignOut().click();
	}

	public void signInClick() {
		this.getSignIn().click();
	}

	public String textSignIn() {
		return this.getSignIn().getText();
	}

}
