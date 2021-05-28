package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commons.AbstractPage;
import pageUIs.AdminDashboardPageUI;
import pageUIs.AdminProductPageUI;

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

}
