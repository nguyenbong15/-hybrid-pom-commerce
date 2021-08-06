package pageObjectAdmin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commons.AbstractPage;
import pageUIAdmin.AdminProductPageUI;
import pageUIsUser.AbstracPageUI;

public class AdminProductsPagePO extends AbstractPage {
	WebDriver driver;

	public AdminProductsPagePO(WebDriver driver) {
		this.driver = driver;

	}

	public void clickSelectAll() {
		waitToElementclickable(driver, AdminProductPageUI.ALL_CHECKBOX);
		checkToCheckbox(driver, AdminProductPageUI.ALL_CHECKBOX);
		

	}

	public void clickToUnSelectAll() {
		waitToElementclickable(driver, AdminProductPageUI.ALL_CHECKBOX);
		uncheckToCheckbox(driver, AdminProductPageUI.ALL_CHECKBOX);
		
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

	public void clickToEditByProductName(String producName) {
		waitToElementclickable(driver, AdminProductPageUI.EDIT_BUTTON,producName);
		clickToElement(driver,  AdminProductPageUI.EDIT_BUTTON,producName);
		waitToElementInvisible(driver, AdminProductPageUI.ICON_LOADING);	
	}

	public void scrollToPicturePanel() {
		scrollToElement(driver, AbstracPageUI.ID_PANEL);
		sleepSecond(1);
		
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

	public void chooseItemInCategoryDropdown(String itemValue) {
		waitToElementVisible(driver, AdminProductPageUI.CATEGORY_DROPDOWN);
		selectItemInDropdown(driver, AdminProductPageUI.CATEGORY_DROPDOWN, itemValue);
	}

	public void uncheckToSearchSubcategoriesCheckbox() {
		waitToElementclickable(driver, AdminProductPageUI.SEARCH_CATEGORY_CHECKBOX);
		uncheckToCheckbox(driver, AdminProductPageUI.SEARCH_CATEGORY_CHECKBOX);
	}

	public boolean isMessageNoItemDisplayed() {
		waitToElementVisible(driver, AdminProductPageUI.MESSAGE_NO_DATA);
		return isElementDisplayed(driver, AdminProductPageUI.MESSAGE_NO_DATA);
	}

	public void checkToSearchSubcategoriesCheckbox() {
		waitToElementclickable(driver, AdminProductPageUI.SEARCH_CATEGORY_CHECKBOX);
		checkToCheckbox(driver, AdminProductPageUI.SEARCH_CATEGORY_CHECKBOX);
		
	}

	public void chooseItemInManufacturerDropdown(String itemValue) {
		waitToElementVisible(driver, AdminProductPageUI.MANUFACTURE_DROPDOWN);
		selectItemInDropdown(driver, AdminProductPageUI.MANUFACTURE_DROPDOWN, itemValue);
		
	}

	public void inputSkuTextBox(String itemValue) {
		waitToElementVisible(driver, AdminProductPageUI.SKU_TEXTBOX);
		senkeyToElement(driver, AdminProductPageUI.SKU_TEXTBOX, itemValue);
		
	}

	public void clickToGoButton() {
		waitToElementclickable(driver, AdminProductPageUI.GO_BUTTON);
		clickToElement(driver,  AdminProductPageUI.GO_BUTTON);
		waitToElementInvisible(driver, AdminProductPageUI.ICON_LOADING);
		
	}

	public boolean isProducInfoPageDisplayed() {
		
		waitToElementVisible(driver, AdminProductPageUI.PRODUCT_INFO_TITLE);
		return isElementDisplayed(driver,  AdminProductPageUI.PRODUCT_INFO_TITLE);
	}

	public String getNameProducts() {
		waitToElementVisible(driver, AdminProductPageUI.PRODUCT_NAME_VERIFY);
		return getAttributeElement(driver, AdminProductPageUI.PRODUCT_NAME_VERIFY, "value");
	}

	public String getSkuProducts() {
		waitToElementVisible(driver, AdminProductPageUI.SKU_VERIFY);
		return getAttributeElement(driver, AdminProductPageUI.SKU_VERIFY, "value");
	}

	public boolean statusPulisherProductIsTrue() {
		waitToElementVisible(driver, AdminProductPageUI.PUBLISHED_VERIFY);
		return isElementSelected(driver, AdminProductPageUI.PUBLISHED_VERIFY);
	}

	public void clickToShowSearchPage() {
		String attributeValue=getAttributeElement(driver, AdminProductPageUI.ICON_TO_OPEN_SEARCH, "class");
		if(attributeValue.contains("far fa-angle-down")) {
			waitToElementclickable(driver, AdminProductPageUI.ICON_TO_OPEN_SEARCH);
			clickToElement(driver, AdminProductPageUI.ICON_TO_OPEN_SEARCH);
			waitToElementInvisible(driver, AdminProductPageUI.ICON_LOADING);
		}else {}
		
	}


}
