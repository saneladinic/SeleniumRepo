package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
	
	WebDriver driver;
	WebElement emailInputField;
	WebElement passwordInputField;
	WebElement signInButton;
	WebElement invalidCredentialsText;

	public LogInPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmailInputField() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getPasswordInputField() {
		return driver.findElement(By.id("passwd"));
	}

	public WebElement getSignInButton() {
		return driver.findElement(By.id("SubmitLogin"));
	}

	public WebElement getInvalidCredentialsText() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
	}

	public void insertEmail(String email) {
		this.getEmailInputField().clear();
		this.getEmailInputField().sendKeys(email);
	}

	public void insertPassword(String password) {
		this.getPasswordInputField().clear();
		this.getPasswordInputField().sendKeys(password);
	}

	public void signInButtonClick() {
		this.getSignInButton().click();
	}

	public String textInvalidCredentials() {
		return this.getInvalidCredentialsText().getText();
	}

}
