package pageObjectAdmin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commons.AbstractPage;
import commons.GlobalConsarts;
import pageUIAdmin.AdminDashboardPageUI;
import pageUIAdmin.AdminProductPageUI;

public class AdminProductsPagePO extends AbstractPage {
	WebDriver driver;

	public AdminProductsPagePO(WebDriver driver) {
		this.driver = driver;

	}

	public void clickSelectAll() {
		waitToElementclickable(driver, AdminProductPageUI.ALL_CHECKBOX);
		checkToCheckbox(driver, AdminProductPageUI.ALL_CHECKBOX);
		;

	}

	public void clickToUnSelectAll() {
		waitToElementclickable(driver, AdminProductPageUI.ALL_CHECKBOX);
		uncheckToCheckbox(driver, AdminProductPageUI.ALL_CHECKBOX);
		;
	}

	public void clickToPageIndex(String... pageIndex) {
		waitToElementclickable(driver, AdminProductPageUI.PAGE_INDEX_TABLE, pageIndex);
		clickToElement(driver, AdminProductPageUI.PAGE_INDEX_TABLE, pageIndex);
	}

	public boolean isNumberPageTableDisplayed(String... pageIndex) {

		waitToElementVisible(driver, AdminProductPageUI.CHECK_PAGE_INDEX_TABLE, pageIndex);

		return isElementDisplayed(driver, AdminProductPageUI.CHECK_PAGE_INDEX_TABLE, pageIndex);
	}

	public void areAllProductSelected() {
		List<WebElement> allProduct= getElements(driver, AdminProductPageUI.ALL_PRODUCTS);
		for (WebElement webElement : allProduct) {
			Assert.assertTrue(webElement.isSelected());
		}
		
	}
	public void areAllProductUnSelected() {
		List<WebElement> allProduct= getElements(driver, AdminProductPageUI.ALL_PRODUCTS);
 		for (WebElement webElement : allProduct) {
			Assert.assertFalse(webElement.isSelected());
		}
		
	}

	public boolean isProductInfoDisplayed(String columName, String rowIndex, String expectedValue) {
		int columIndex=  countElementSize(driver, AdminProductPageUI.COLUMN_NAME,columName)+1;
		String actualValues= getTextElement(driver, AdminProductPageUI.CELL_BY_COLUMN_NAME_AND_ROW_INDEX,rowIndex,String.valueOf(columIndex));
		return actualValues.equals(expectedValue);
	}

	public boolean isPublishedStatusDisplayed(String columName, String rowIndex, String expectedValue) {
		int columIndex=countElementSize(driver, AdminProductPageUI.COLUMN_NAME,columName)+1;
		return isElementDisplayed(driver, AdminProductPageUI.PUBLIC_STATUS_BY_COLUMN_NAME_AND_ROW_INDEX,rowIndex,String.valueOf(columIndex),expectedValue);
	}

	public boolean isProductInfoInRowTableDisplayed(String productName, String sku, String price, String stockQuantity) {
		
		return isElementDisplayed(driver, AdminProductPageUI.PRODUCT_IN_ROW_TABLE,productName,sku, price,stockQuantity);
	}

	public void inputProductName(String productName) {
		waitToElementVisible(driver, AdminProductPageUI.PRODUCT_NAME_SEARCH);
	    senkeyToElement(driver, AdminProductPageUI.PRODUCT_NAME_SEARCH, productName);
		
	}

	public void clickToSearchButton() {
		waitToElementclickable(driver, AdminProductPageUI.SEARCH_BUTTON);
		clickToElement(driver,  AdminProductPageUI.SEARCH_BUTTON);
		waitToElementInvisible(driver, AdminProductPageUI.ICON_LOADING);
	}

	public boolean isSearchProductInfoDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public void clickToEditByProductName(String producName) {
		waitToElementclickable(driver, AdminProductPageUI.EDIT_BUTTON,producName);
		clickToElement(driver,  AdminProductPageUI.EDIT_BUTTON,producName);
		waitToElementInvisible(driver, AdminProductPageUI.ICON_LOADING);	
	}

	public void scrollToPicturePanel() {
		scrollToElement(driver, AdminProductPageUI.PICTURE_PANEL);
		sleepSecond(1);
		
	}

	public void clickToHideButton() {
		String attributeValue=getElementAttribute(driver, AdminProductPageUI.PICTURE_PANEL, "class");
		if(attributeValue.contains("collapsed-card")) {
			waitToElementclickable(driver, AdminProductPageUI.ICON_HIDE_OR_SHOW);
			clickToElement(driver, AdminProductPageUI.ICON_HIDE_OR_SHOW);
			waitToElementInvisible(driver, AdminProductPageUI.ICON_LOADING);
		}else {}
		
	}

	

	public void inputToAlt(String altName) {
		waitToElementVisible(driver, AdminProductPageUI.ALT_TEXTBOX);
		senkeyToElement(driver, AdminProductPageUI.ALT_TEXTBOX, altName);
		
	}

	public void inputToTitle(String title) {
		waitToElementVisible(driver, AdminProductPageUI.TITLE_TEXTBOX);
		senkeyToElement(driver, AdminProductPageUI.TITLE_TEXTBOX, title);
	}

	public void inputToDisplayOrder(String displayOder) {
		waitToElementVisible(driver, AdminProductPageUI.DISPLAY_ORDER);
		senkeyToElement(driver, AdminProductPageUI.DISPLAY_ORDER, displayOder);
		
	}
	public void clickToAddProductPicture() {
		waitToElementclickable(driver, AdminProductPageUI.ADD_PRODUCT_PICTURE_BUTTON);
		clickToElement(driver, AdminProductPageUI.ADD_PRODUCT_PICTURE_BUTTON);
		waitToElementInvisible(driver, AdminProductPageUI.ICON_LOADING);
	}

	public void clictToSaveButton() {
		
		
	}


}
