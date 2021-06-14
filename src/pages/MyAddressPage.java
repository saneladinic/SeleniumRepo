package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAddressPage {

	WebDriver driver;
	WebElement updateButton;
	WebElement textMyAddress;
	WebElement addNewAddressButton;
	WebElement deleteButton;

	public MyAddressPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUpdateButton() {
		return driver.findElement(By.cssSelector(".box.first_item.item  a[title='Update'] > span"));
	}

	public WebElement getTextMyAddress() {
		return driver.findElement(By.className("navigation_page"));
	}

	public WebElement getAddNewAddressButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[2]/a"));
	}

	public WebElement getDeleteButton() {
		return driver.findElement(By.xpath(
				"/html//div[@id='center_column']//div[@class='bloc_adresses row']/div[2]/ul//a[@title='Delete']/span"));
	}

	public void updateButtonClick() {
		this.getUpdateButton().click();
	}

	public String textMyAddress() {
		return this.getTextMyAddress().getText();
	}

	public void addNewAddressButtonClick() {
		this.getAddNewAddressButton().click();
	}

	public void deleteButtonClick() {
		this.getDeleteButton().click();
		driver.switchTo().alert().accept();
	}

	public int addressCount() {
		List<WebElement> addressList = driver.findElements(By.cssSelector(".col-xs-12.col-sm-6.address"));
		return addressList.size();
	}
}
