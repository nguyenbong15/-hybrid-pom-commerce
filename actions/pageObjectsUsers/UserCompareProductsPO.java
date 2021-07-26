package pageObjectsUsers;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIsUser.AbstracPageUI;
import pageUIsUser.UserCompareProductsUI;
import pageUIsUser.UserMyProductsReviewPageUI;

public class UserCompareProductsPO extends AbstractPage {
	WebDriver driver;
	public UserCompareProductsPO( WebDriver driver) {
		this.driver=driver;
		
	}
	public void hoverToComputerLink() {
		waitToElementVisible(driver, UserCompareProductsUI.COMPUTER_LINK);
		hoverMouseToElement(driver, UserCompareProductsUI.COMPUTER_LINK);
	}
	public void clickToNotebookLink(){
		waitToElementclickable(driver, UserCompareProductsUI.NOTEBOOK_LINK);
		clickToElement(driver, UserCompareProductsUI.NOTEBOOK_LINK);
	
	}
	public void clickAddToComparePageByName(String value) {
		waitToElementclickable(driver, UserCompareProductsUI.ADD_TO_COMPARE_LIST_BUTTON_BY_NAME,value);
		clickToElement(driver, UserCompareProductsUI.ADD_TO_COMPARE_LIST_BUTTON_BY_NAME,value);
		waitToAjaxLoading(driver, UserCompareProductsUI.ICON_LOADING);
		
	}
	public void clickComparePageLink() {
		//waitToAjaxLoading(driver, UserCompareProductsUI.ICON_LOADING);
		waitToElementclickable(driver, UserCompareProductsUI.COMPARE_PRODUCTS_LIST_LINK);
		clickToElement(driver, UserCompareProductsUI.COMPARE_PRODUCTS_LIST_LINK);
	}
	public boolean isInfoProductsDisplayed(String rowName,String coulumName, String valueExpect) {
		int row=countElementSize(driver, UserCompareProductsUI.ROW_INDEX_BY_TITLE,rowName)+1;
		int colum=countElementSize(driver, UserCompareProductsUI.COLUMN_INDEX,coulumName)+1;
		
		return isElementDisplayed(driver, UserCompareProductsUI.GET_TEXT_BY_ROWINDEX_AND_COLUMN,String.valueOf(row),String.valueOf(colum),valueExpect);
	}
	public boolean isInfoProductsDisplayedByName(String rowName,String coulumName, String valueExpect) {
		int row=countElementSize(driver, UserCompareProductsUI.ROW_INDEX_BY_TITLE,rowName)+1;
		int colum=countElementSize(driver, UserCompareProductsUI.COLUMN_INDEX_BY_NAME,coulumName)+1;
		
		return isElementDisplayed(driver, UserCompareProductsUI.GET_TEXT_BY_ROWINDEX_AND_COLUMN,String.valueOf(row),String.valueOf(colum),valueExpect);
	}
	public void clickToClearListButton() {
		waitToElementclickable(driver, UserCompareProductsUI.CLEAR_LIST_BUTTON);
		clickToElement(driver, UserCompareProductsUI.CLEAR_LIST_BUTTON);
		
	}
	public String getTextMessage() {
		waitToElementVisible(driver, UserCompareProductsUI.MESSAGE_NO_DATA);
		return getTextElement(driver, UserCompareProductsUI.MESSAGE_NO_DATA);
	}
	public boolean infoDetialProduct(String name, String prices) {
		waitToElementVisible(driver, UserCompareProductsUI.INFO_PRODUCT,name,prices);
		return isElementDisplayed(driver, UserCompareProductsUI.INFO_PRODUCT,name,prices);
	}
	public void clickToRecentlyViewProducts() {
		waitToElementclickable(driver, UserCompareProductsUI.RECENTLY_VIEW_LINK);
		clickToElement(driver,  UserCompareProductsUI.RECENTLY_VIEW_LINK);
	}
	public int countProducts() {
		waitToAllElementVisible(driver, UserCompareProductsUI.COUNT_PRODUCTS);
		return getElements(driver, UserCompareProductsUI.COUNT_PRODUCTS).size();
	}
	
	
	
}
