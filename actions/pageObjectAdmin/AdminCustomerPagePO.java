package pageObjectAdmin;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIAdmin.AdminCustomerPageUI;
import pageUIAdmin.AdminProductPageUI;

public class AdminCustomerPagePO extends AbstractPage {
	WebDriver driver;

	public AdminCustomerPagePO(WebDriver driver) {
		this.driver = driver;

	}

	public void clickToAddButton() {
		waitToElementclickable(driver, AdminCustomerPageUI.ADD_BUTTON);
		clickToElement(driver, AdminCustomerPageUI.ADD_BUTTON);

	}

	public void chooseItemInCustomDropdownById(String itemValue, String id) {
		waitToElementVisible(driver, AdminCustomerPageUI.PARENT_SEARCHPAGE_LOCTOR_DROPDOWN, id);
		selectItemsInCustomDropdown(driver, AdminCustomerPageUI.PARENT_SEARCHPAGE_LOCTOR_DROPDOWN,
				AdminCustomerPageUI.CHIL_ITEM_IN_NEWLETTER_DROPDOWN, itemValue, id);
	}

	public void clickToSaveAndContinueEditButton() {
		waitToElementclickable(driver, AdminCustomerPageUI.SAVE_AND_CONTINUE_BUTTON);
		clickToElement(driver, AdminCustomerPageUI.SAVE_AND_CONTINUE_BUTTON);

	}

	public boolean isMessageAddSucessDispalyed() {
		waitToElementVisible(driver, AdminCustomerPageUI.MESSAGE_ADD_SUCCESS);
		return isElementDisplayed(driver, AdminCustomerPageUI.MESSAGE_ADD_SUCCESS);
	}

	public String getNewletter() {
		waitToElementVisible(driver, AdminCustomerPageUI.NEWLETTER_VERIFY);
		return getTextElement(driver, AdminCustomerPageUI.NEWLETTER_VERIFY);
	}

	public boolean isMaleRadioChecked() {
		waitToElementVisible(driver, AdminCustomerPageUI.MALE_RADIO_VERIFY);
		return isElementSelected(driver, AdminCustomerPageUI.MALE_RADIO_VERIFY);
	}

	public boolean isActiveCheckboxChecked() {
		waitToElementVisible(driver, AdminCustomerPageUI.ACTIVE_CHECKBOX_VERIFY);
		return isElementSelected(driver, AdminCustomerPageUI.ACTIVE_CHECKBOX_VERIFY);
	}

	public void clickToShowSearchPage() {
		String attributeValue = getAttributeElement(driver, AdminCustomerPageUI.ICON_TO_OPEN_SEARCH, "class");
		if (attributeValue.contains("far fa-angle-down")) {
			waitToElementclickable(driver, AdminCustomerPageUI.ICON_TO_OPEN_SEARCH);
			clickToElement(driver, AdminCustomerPageUI.ICON_TO_OPEN_SEARCH);
			waitoAjaxLoaded(driver);
		} else {
		}

	}

	public void clickToRegisterButtonToRemove() {
		waitToElementclickable(driver, AdminCustomerPageUI.REMOVE_REGISTER_BUTTON);
		clickToElementByJS(driver, AdminCustomerPageUI.REMOVE_REGISTER_BUTTON);
	}

	public void clickToBackToListLink() {
		waitToElementclickable(driver, AdminCustomerPageUI.BACK_TO_CUSTOMER_LIST_LINK);
		clickToElement(driver, AdminCustomerPageUI.BACK_TO_CUSTOMER_LIST_LINK);

	}

	public void clickToSearchButton() {

		waitToElementclickable(driver, AdminCustomerPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminCustomerPageUI.SEARCH_BUTTON);
		waitoAjaxLoaded(driver);
	}

	public boolean isInfoCustomerDisplayedInTable(String name, String companyName, String active) {
		waitToElementVisible(driver, AdminCustomerPageUI.VERIFY_INFO_CUSTOMER_IN_TABLE, name, companyName, active);
		return isElementDisplayed(driver, AdminCustomerPageUI.VERIFY_INFO_CUSTOMER_IN_TABLE, name, companyName, active);
	}

	public void chooseNumberItemInPage(String itemValue) {
		waitToElementVisible(driver, AdminCustomerPageUI.SHOW_ITEM_DROPDOWN);
		selectItemInDropdown(driver, AdminCustomerPageUI.SHOW_ITEM_DROPDOWN, itemValue);
		waitoAjaxLoaded(driver);
	}

	public void hoverToCustomDropdown() {
		waitToElementVisible(driver, AdminCustomerPageUI.PARENT_SEARCHPAGE_LOCTOR_DROPDOWN);
		hoverMouseToElement(driver, AdminCustomerPageUI.PARENT_SEARCHPAGE_LOCTOR_DROPDOWN);
		waitToElementclickable(driver, AdminCustomerPageUI.CLEAR_DROPDOWN);
		clickToElement(driver, AdminCustomerPageUI.CLEAR_DROPDOWN);
	}

	public void chosseItemInDropdownById(String itemValue, String idDropdown) {
		waitToElementVisible(driver, AdminCustomerPageUI.MONTH_DAY_DROPDOWN, idDropdown);
		selectItemInDropdown(driver, AdminCustomerPageUI.MONTH_DAY_DROPDOWN, itemValue, idDropdown);
	}

	public void clickToEditLinkByName_Company(String name, String companyName) {
		waitToElementclickable(driver, AdminCustomerPageUI.EDIT_LINK_BY_NAME_COMPANY, name, companyName);
		clickToElement(driver, AdminCustomerPageUI.EDIT_LINK_BY_NAME_COMPANY, name, companyName);
		waitoAjaxLoaded(driver);

	}

	public void clickToSaveButton() {
		waitToElementclickable(driver, AdminCustomerPageUI.SAVE_IN_CUSTOMER_PAGE_BUTTON);
		clickToElement(driver, AdminCustomerPageUI.SAVE_IN_CUSTOMER_PAGE_BUTTON);
		waitoAjaxLoaded(driver);

	}

	public void clickToAddNewAddressButton() {
		
		waitToElementclickable(driver, AdminCustomerPageUI.ADD_NEW_ADDRESS_BUTTON);
		clickToElement(driver, AdminCustomerPageUI.ADD_NEW_ADDRESS_BUTTON);
		waitoAjaxLoaded(driver);
		
	}

	public void clickToSaveAddressButton() {
		waitToElementclickable(driver, AdminCustomerPageUI.SAVE_ADDRESS_BUTTON);
		clickToElement(driver, AdminCustomerPageUI.SAVE_ADDRESS_BUTTON);
		waitoAjaxLoaded(driver);
		
	}

	public void clickToBackToDetailsLink() {
		waitToElementclickable(driver, AdminCustomerPageUI.BACK_TO_CUSTOMER_DETAILS_LINK);
		clickToElement(driver, AdminCustomerPageUI.BACK_TO_CUSTOMER_DETAILS_LINK);
		waitoAjaxLoaded(driver);
		
	}

	public boolean isInfoAddressDisplayed(String firstname, String lastname, String email, String phone) {
		waitToElementVisible(driver, AdminCustomerPageUI.VERIFY_INFO_ADDRESS, firstname,lastname,email,phone);
		return isElementDisplayed(driver,  AdminCustomerPageUI.VERIFY_INFO_ADDRESS, firstname,lastname,email,phone);
	}

	public String getAddress() {
		waitToElementVisible(driver, AdminCustomerPageUI.TEXT_ADDRESS_BUTTON);
		return getTextElement(driver, AdminCustomerPageUI.TEXT_ADDRESS_BUTTON);
	}

	public void clickToEditAddressByEmail(String emailCustomer) {
		waitToElementclickable(driver, AdminCustomerPageUI.EDIT_ADDRESS_LINK,emailCustomer);
		clickToElement(driver, AdminCustomerPageUI.EDIT_ADDRESS_LINK,emailCustomer);
		waitoAjaxLoaded(driver);
		
	}

	public void clickToDeleteAddressByEmail(String emailCustomer) {
		
		waitToElementclickable(driver, AdminCustomerPageUI.DELETE_ADDRESS_LINK,emailCustomer);
		clickToElement(driver, AdminCustomerPageUI.DELETE_ADDRESS_LINK,emailCustomer);
	//	waitoAjaxLoaded(driver);
	}

	public boolean isMessageNoDataInTable() {
		waitToElementVisible(driver, AdminCustomerPageUI.VERIFY_NO_DATA_IN_TABLE);
		return isElementDisplayed(driver,  AdminCustomerPageUI.VERIFY_NO_DATA_IN_TABLE);
	}

	

}
