package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WomenPage {

	WebDriver driver;
	WebElement dressesTab;

	public WomenPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getDressesTab() {
		return driver.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[2]/div[1]/a"));
	}

	public void dressesTabClick() {
		this.getDressesTab().click();
	}
}
