package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyWishlistsPage {

	WebDriver driver;
	WebElement nameForWishlist;
	WebElement saveButtonwishList;
	WebElement deleteButtonWishlist;
	
	public MyWishlistsPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getNameForWishlist() {
		return driver.findElement(By.id("name"));
	}
	
	
	public WebElement getSaveButtonwishList() {
		return driver.findElement(By.id("submitWishlist"));
	}
	

	public WebElement getDeleteButtonWishlist() {
		return driver.findElement(By.className("icon"));
	}

	public void insertNameForWishlist(String name) {
		this.getNameForWishlist().sendKeys(name);
	}
	public void saveButtonWishListClisck() {
		this.getSaveButtonwishList().click();
	}
	public void deleteButtonClick() {
		this.getDeleteButtonWishlist().click();
		driver.switchTo().alert().accept();
	}
	public int wishListCount() {
		List<WebElement> wishlistList = driver.findElements(By.className("wishlist_delete"));
		return wishlistList.size();
	}
	
}
