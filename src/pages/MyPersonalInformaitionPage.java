package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyPersonalInformaitionPage {

	WebDriver driver;
	WebElement mrRadioButton;
	WebElement mrsRadioButton;
	WebElement selectedMr;
	WebElement selectedMrs;
	WebElement firstNamaInputField;
	WebElement ErrorMessage;
	WebElement lastNamaInputField;
	WebElement saveButton;
	WebElement oldPassword;
	WebElement dayOfBirth;
	WebElement monthOfBirth;
	WebElement yearOfBirth;
	WebElement greenMessage;

	public MyPersonalInformaitionPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getMrRadioButton() {
		return driver.findElement(By.id("id_gender1"));
	}

	public WebElement getMrsRadioButton() {
		return driver.findElement(By.id("id_gender2"));
	}

	public WebElement getSelectedMr() {
		return driver.findElement(By.xpath("//*[@id=\"uniform-id_gender1\"]/span"));
	}

	public WebElement getSelectedMrs() {
		return driver.findElement(By.xpath("//*[@id=\"uniform-id_gender2\"]/span"));
	}

	public WebElement getFirstNamaInputField() {
		return driver.findElement(By.id("firstname"));
	}

	public WebElement getErrorMessage() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/ol/li"));
	}

	public WebElement getLastNamaInputField() {
		return driver.findElement(By.id("lastname"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/form/fieldset/div[11]/button"));
	}

	public WebElement getOldPassword() {
		return driver.findElement(By.id("old_passwd"));
	}

	public WebElement getDayOfBirth() {
		return driver.findElement(By.id("days"));
	}

	public WebElement getMonthOfBirth() {
		return driver.findElement(By.id("months"));
	}

	public WebElement getYearOfBirth() {
		return driver.findElement(By.id("years"));
	}

	public WebElement getGreenMessage() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p"));
	}

	public void mrRadioButtonClick() {
		this.getMrRadioButton().click();
	}

	public void mrsRadioButtonClick() {
		this.getMrsRadioButton().click();
	}

	public boolean isSelectedMr() {
		return this.getSelectedMr().getAttribute("class").equals("checked");
	}

	public boolean isSelectedMrs() {
		return this.getSelectedMrs().getAttribute("class").equals("checked");
	}

	public void clearFirstName() {
		this.getFirstNamaInputField().clear();
	}

	public void clearLastName() {
		this.getLastNamaInputField().clear();
	}

	public String textErrorMessage() {
		return this.getErrorMessage().getText();
	}

	public void saveButtonClick() {
		this.getSaveButton().click();
	}

	public void insertOldPassword(String oldPassword) {
		this.getOldPassword().sendKeys(oldPassword);
	}

	public void insertDayOfBirth(String day) {
		this.getDayOfBirth().sendKeys(day);
	}

	public void insertMonthOfBirth(String month) {
		this.getMonthOfBirth().sendKeys(month);
	}

	public void insertYearOfBirth(String year) {
		this.getYearOfBirth().sendKeys(year);
	}

	public String textGreenMessage() {
		return this.getGreenMessage().getText();
	}
}
