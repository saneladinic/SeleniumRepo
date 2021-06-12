package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class YourAddressPage {

	WebDriver driver;
	WebElement addressInputField;
	WebElement saveButton;
	WebElement cityInputField;
	WebElement stateDropDownMenu;
	WebElement postcodeInputField;
	WebElement homePhoneInputField;
	WebElement mobilePhoneInputField;
	WebElement namaForAddress;

	public YourAddressPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getAddressInputField() {
		return driver.findElement(By.id("address1"));

	}

	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitAddress"));
	}

	public WebElement getCityInputField() {
		return driver.findElement(By.id("city"));
	}

	public WebElement getStateDropDownMenu() {

		return driver.findElement(By.id("id_state"));
	}

	public WebElement getPostcodeInputField() {
		return driver.findElement(By.xpath("//*[@id=\"postcode\"]"));
	}

	public WebElement getHomePhoneInputField() {
		return driver.findElement(By.id("phone"));
	}

	public WebElement getMobilePhoneInputField() {
		return driver.findElement(By.id("phone_mobile"));
	}

	public WebElement getNamaForAddress() {
		return driver.findElement(By.id("alias"));
	}

	public void updateAddress(String newAddress) {
		this.getAddressInputField().clear();
		this.getAddressInputField().sendKeys(newAddress);
	}

	public void saveButtonClick() {
		this.getSaveButton().click();
	}

	public void insertAddress(String address) {
		this.getAddressInputField().sendKeys(address);
	}

	public void insertCity(String city) {
		this.getCityInputField().sendKeys(city);
	}

	public void stateDropDownManuClick() {
		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByValue("6");
	}

	public void insertPostcode(String postcode) {
		this.getPostcodeInputField().sendKeys(postcode);
	}

	public void insertHomePhone(String homePhone) {
		this.getHomePhoneInputField().sendKeys(homePhone);
	}

	public void insertMobilePhone(String mobilePhone) {
		this.getMobilePhoneInputField().sendKeys(mobilePhone);
	}

	public void insertNameForAddress(String nameAddress) {
		this.getNamaForAddress().sendKeys(nameAddress);
	}
}
