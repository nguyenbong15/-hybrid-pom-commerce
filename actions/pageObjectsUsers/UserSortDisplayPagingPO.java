package pageObjectsUsers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.AbstractPage;
import pageUIsUser.UserSortDisplayPagingUI;

public class UserSortDisplayPagingPO extends AbstractPage{
	WebDriver driver;
	public UserSortDisplayPagingPO( WebDriver driver) {
		this.driver=driver;
		
	}
	public void selectItemInSortByDropdown(String itemValue) {
		waitToElementclickable(driver, UserSortDisplayPagingUI.SORTBY_DROPDOWN);
		selectItemInDropdown(driver, UserSortDisplayPagingUI.SORTBY_DROPDOWN, itemValue);
	}
	public boolean isCorrectSortNameAToZ() {
		waitToAjaxLoading(driver, UserSortDisplayPagingUI.AJAX_ICON);
		List<WebElement> allProducts= getElements(driver, UserSortDisplayPagingUI.PRODUCTS_SORT_BY_NAME);
		ArrayList<String> dataOnUI=new ArrayList<String>();
		for (WebElement element : allProducts) {
			dataOnUI.add(element.getText());
		}
		
		ArrayList<String> dataAfterSort=new ArrayList<String>();
		for (String string : dataOnUI) {
			dataAfterSort.add(string);
		}
		Collections.sort(dataAfterSort);
		
		return dataAfterSort.equals(dataOnUI);
	}
	public boolean isCorrectSortNameZToA() {
		waitToAjaxLoading(driver, UserSortDisplayPagingUI.AJAX_ICON);
		List<WebElement> allProducts= getElements(driver, UserSortDisplayPagingUI.PRODUCTS_SORT_BY_NAME);
		ArrayList<String> dataOnUI=new ArrayList<String>();
		for (WebElement element : allProducts) {
			dataOnUI.add(element.getText());
		}
		
		ArrayList<String> dataAfterSort=new ArrayList<String>();
		for (String string : dataOnUI) {
			dataAfterSort.add(string);
		}
		Collections.sort(dataAfterSort);
		Collections.reverse(dataAfterSort);
		
		return dataAfterSort.equals(dataOnUI);
	}
	public boolean isCorrectSortPriceHighToLow() {
		waitToAjaxLoading(driver, UserSortDisplayPagingUI.AJAX_ICON);
		List<WebElement> allProducts= getElements(driver, UserSortDisplayPagingUI.PRODUCTS_SORT_BY_PRICES);
		ArrayList<Float> dataOnUI=new ArrayList<Float>();
		for (WebElement element : allProducts) {
			dataOnUI.add(Float.valueOf(element.getText().replace("$", "").replace(",", "").trim()));
		}
		
		ArrayList<Float> dataAfterSort=new ArrayList<Float>();
		for (Float string : dataOnUI) {
			dataAfterSort.add(string);
		}
		Collections.sort(dataAfterSort);
		Collections.reverse(dataAfterSort);
		
		return dataAfterSort.equals(dataOnUI);
	}
	public boolean isCorrectSortPriceLowToHigh() {
		waitToAjaxLoading(driver, UserSortDisplayPagingUI.AJAX_ICON);
		List<WebElement> allProducts= getElements(driver, UserSortDisplayPagingUI.PRODUCTS_SORT_BY_PRICES);
		ArrayList<Float> dataOnUI=new ArrayList<Float>();
		for (WebElement element : allProducts) {
			dataOnUI.add(Float.valueOf(element.getText().replace("$", "").replace(",", "").trim()));
		}
		
		ArrayList<Float> dataAfterSort=new ArrayList<Float>();
		for (Float string : dataOnUI) {
			dataAfterSort.add(string);
		}
		Collections.sort(dataAfterSort);
	
		return dataAfterSort.equals(dataOnUI);
	}
	public void selectItemInPagingDropDown(String itemValue) {
		waitToElementVisible(driver, UserSortDisplayPagingUI.PAGING_DROPDOWN);
		selectItemInDropdown(driver, UserSortDisplayPagingUI.PAGING_DROPDOWN, itemValue);
	}
	public boolean areProductsDisplayByNumberPaging(String numberPaging) {
		waitToAjaxLoading(driver, UserSortDisplayPagingUI.AJAX_ICON);
	    List<WebElement> products= getElements(driver, UserSortDisplayPagingUI.PRODUCTS_SORT_BY_NAME);
	    if(Integer.parseInt(numberPaging)< products.size() || Integer.parseInt(numberPaging)== products.size() ) {
	    	return true;
	    }else {
	    	return false;
	    }
	}
	public boolean iconNextPageDiplayed() {
		waitToAjaxLoading(driver, UserSortDisplayPagingUI.AJAX_ICON);
		return isElementDisplayed(driver, UserSortDisplayPagingUI.NEXT_ICON);
	}
	public void clickToTwoPage() {
		waitToElementclickable(driver, UserSortDisplayPagingUI.TWO_PAGE);
		clickToElement(driver, UserSortDisplayPagingUI.TWO_PAGE);
	}
	public boolean iconPreviousPageDiplayed() {
		waitToAjaxLoading(driver, UserSortDisplayPagingUI.AJAX_ICON);
		return isElementDisplayed(driver, UserSortDisplayPagingUI.PREVIOUS_ICON);
	}
	public boolean iconNextPageAndPreviousUnDiplayed() {
		return waitToElementStaleness(driver, UserSortDisplayPagingUI.NEXT_ICON);
		
	}
	
	
}
