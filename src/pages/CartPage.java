package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

	WebDriver driver;
	WebElement removeButton;
	WebElement messageForRemoveProductFromCart;
	WebElement textForQuantityInput;

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getRemoveButton() {
		return driver.findElement(By.id("4_16_0_519901"));
	}

	public WebElement getMessageForRemoveProductFromCart() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/p"));
	}

	public WebElement getTextForQuantityInput() {
		return driver.findElement(By.id("summary_products_quantity"));
	}

	public int productCount() {
		List<WebElement> productList = driver.findElements(By.cssSelector(".cart_delete.text-center"));
		return productList.size();
	}

	public void removeButtonClick() {
		this.getRemoveButton().click();
	}

	public String TextMessageForRemoveProductFromCart() {
		return this.getMessageForRemoveProductFromCart().getText();
	}

	public String textForQuantityInput() {
		return this.getTextForQuantityInput().getText();
	}
}
