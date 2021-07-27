package pageObjectsUsers;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIsUser.UserWishlistPageUI;

public class UserWishlistPagePO extends AbstractPage {

	WebDriver driver;

	public UserWishlistPagePO(WebDriver driver) {
		this.driver = driver;

	}

	public boolean isInfoProductsDisplayed(String sku, String name, String prices) {
		waitToElementVisible(driver, UserWishlistPageUI.PRODUCTS_INFO, sku, name, prices);
		return isElementDisplayed(driver, UserWishlistPageUI.PRODUCTS_INFO, sku, name, prices);
	}

	public void clickToCheckBoxByName(String value) {
		waitToElementclickable(driver, UserWishlistPageUI.CHECKBOX, value);
		clickToElement(driver, UserWishlistPageUI.CHECKBOX, value);
	}

	public boolean isTitlePage(String title) {
		waitToElementVisible(driver, UserWishlistPageUI.TITLE_PAGE, title);
		return isElementDisplayed(driver, UserWishlistPageUI.TITLE_PAGE, title);
	}

	public void clickToAddToCartButton() {
		waitToElementclickable(driver, UserWishlistPageUI.ADD_TO_CART_BUTTON_BY_NAME);
		clickToElement(driver, UserWishlistPageUI.ADD_TO_CART_BUTTON_BY_NAME);
	}

	public void clickToWishlistLink() {
		sleepSecond(2);
		waitToElementclickable(driver, UserWishlistPageUI.WISHLIST_LINK);
		clickToElement(driver, UserWishlistPageUI.WISHLIST_LINK);
	}

	public String isMessageNoData() {
		waitToElementVisible(driver, UserWishlistPageUI.NO_DATA);
		return getTextElement(driver, UserWishlistPageUI.NO_DATA);
	}

	public void clickToRemoveButtonByName(String value) {
		waitToElementclickable(driver, UserWishlistPageUI.REMOVE_BUTTON_BY_NAME, value);
		clickToElement(driver, UserWishlistPageUI.REMOVE_BUTTON_BY_NAME, value);

	}

	public void clickToUpdateButton() {
		waitToElementclickable(driver, UserWishlistPageUI.UPDATE_BUTTON);
		clickToElement(driver, UserWishlistPageUI.UPDATE_BUTTON);

	}

	public void clickToProductByName(String value) {
		waitToElementclickable(driver, UserWishlistPageUI.PRODUCT_NAME_LINK, value);
		clickToElement(driver, UserWishlistPageUI.PRODUCT_NAME_LINK, value);
	}

	public void clickToAddToWishlistButton() {
		// waitToAjaxLoading(driver, UserWishlistPageUI.AJAX_ICON);
		waitToElementclickable(driver, UserWishlistPageUI.ADD_TO_WISHLIST_BUTTON);
		clickToElement(driver, UserWishlistPageUI.ADD_TO_WISHLIST_BUTTON);

	}

	public void closeMessage() {
		waitToElementclickable(driver, UserWishlistPageUI.CLOSE_MESSAGE_BUTTON);
		clickToElement(driver, UserWishlistPageUI.CLOSE_MESSAGE_BUTTON);
	}

	public boolean isMessageDisplay() {
		
		waitToElementVisible(driver, UserWishlistPageUI.MESSAGE_ADD_TO_WISHLIST);
		return isElementDisplayed(driver, UserWishlistPageUI.MESSAGE_ADD_TO_WISHLIST);
	}

	public void hoverToComputerLink() {
		waitToElementVisible(driver, UserWishlistPageUI.COMPUTER_LINK);
		hoverMouseToElement(driver, UserWishlistPageUI.COMPUTER_LINK);

	}

	public void clickToDesktopLink() {
		waitToElementclickable(driver, UserWishlistPageUI.DESKTOP_LINK);
		clickToElement(driver, UserWishlistPageUI.DESKTOP_LINK);

	}

}
