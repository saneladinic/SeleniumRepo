package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DressesPage {

	WebDriver driver;
	WebElement AddToCard;
	WebElement printedDressName;
	WebElement quantityInput;
	WebElement printedSummerDressName;
	WebElement proceedToCheckout;
	WebElement printedChiffonDressName;
	WebElement continueShopping;

	public DressesPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getPrintedDressName() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[2]/h5/a"));
	}

	public WebElement getAddToCart() {
		return driver.findElement(By.id("add_to_cart"));
	}

	public WebElement getProceedToCheckout() {
		return driver
				.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a"));
	}

	public WebElement getQuantityInput() {
		return driver.findElement(By.id("quantity_wanted"));
	}

	public WebElement getPrintedSummerDressName() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[3]/div/div[2]/h5/a"));
	}

	public WebElement getPrintedChiffonDressName() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[5]/div/div[2]/h5/a"));
	}

	public WebElement getContinueShopping() {
		return driver
				.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/span"));
	}

	public void printedDressNameClick() {
		this.getPrintedDressName().click();
	}

	public void addToCartClick() {
		this.getAddToCart().click();
	}

	public void proceedToCheckoutClick() {
		this.getProceedToCheckout().click();
	}

	public void quantityInput(String quantity) {
		this.getQuantityInput().clear();
		this.getQuantityInput().sendKeys(quantity);
	}

	public void printedSummerDressNameClick() {
		this.getPrintedSummerDressName().click();
	}

	public void printedChiffonDressNameClick() {
		this.getPrintedChiffonDressName().click();
	}

	public void continueShoppingButtonClick() {
		this.getContinueShopping().click();
	}

	public void addPrintedDress() {
		printedDressNameClick();
		addToCartClick();
		continueShoppingButtonClick();
	}

	public void addPrintedSummerDress() {
		printedSummerDressNameClick();
		addToCartClick();
		continueShoppingButtonClick();
	}

	public void addPrintedChiffonDress() {
		printedChiffonDressNameClick();
		addToCartClick();
		continueShoppingButtonClick();
	}
}
