package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.AbstractPage;
import pageUIs.UserSeachPageUI;

public class UserSearchPagePO extends AbstractPage {
	WebDriver driver;

	public UserSearchPagePO(WebDriver driver) {
		this.driver = driver;

	}

	public void clickToSearchButton() {
		waitToElementclickable(driver, UserSeachPageUI.SEARCH_BUTTON);
		clickToElement(driver, UserSeachPageUI.SEARCH_BUTTON);
	}

	public boolean isMessageError() {
		waitToElementVisible(driver, UserSeachPageUI.MESSAGE_ERROR);
		return isElementDisplayed(driver, UserSeachPageUI.MESSAGE_ERROR);
	}

	public void senkeyToSeachTexbox(String keySearch) {
		waitToElementVisible(driver, UserSeachPageUI.SEARCH_TEXTBOX);
		senkeyToElement(driver, UserSeachPageUI.SEARCH_TEXTBOX, keySearch);
	}

	public boolean isMessageNoProducts() {
		waitToElementVisible(driver, UserSeachPageUI.NO_PRODUCTS);
		return isElementDisplayed(driver, UserSeachPageUI.NO_PRODUCTS);
	}

	public boolean isProductDisplayed(String b) {
		waitToElementVisible(driver, UserSeachPageUI.PRODUCTS);
		List<WebElement> products = getElements(driver, UserSeachPageUI.PRODUCTS);
		List<String> a=new ArrayList<String>();
		for (WebElement element : products) {
			if (element.getText().contains(b))
				a.add(element.getText());
		}
		return !a.isEmpty();
	}

	

}
