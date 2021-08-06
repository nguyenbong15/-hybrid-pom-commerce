package pageUIAdmin;

public class AdminCustomerPageUI {
	public static final String ADD_BUTTON = "//a[@class='btn btn-primary']";
	public static final String SAVE_AND_CONTINUE_BUTTON = "//button[@name='save-continue']";
	public static final String PARENT_LOCTOR_DROPDOWN = "//div[@class='input-group-append']//div[@class='k-multiselect-wrap k-floatwrap']";
	public static final String PARENT_SEARCHPAGE_LOCTOR_DROPDOWN = "//div[@class='k-multiselect-wrap k-floatwrap']";
	public static final String CHIL_ITEM_IN_NEWLETTER_DROPDOWN = "//ul[@id='%s']//li";
	public static final String MESSAGE_ADD_SUCCESS = "//div[@class='alert alert-success alert-dismissable']";
	public static final String NEWLETTER_VERIFY = "//ul[@id='SelectedNewsletterSubscriptionStoreIds_taglist']//span[text()='Your store name']";
	public static final String MALE_RADIO_VERIFY = "//input[@id='Gender_Male']";
	public static final String ACTIVE_CHECKBOX_VERIFY = "//input[@id='Active']";
	public static final String BACK_TO_CUSTOMER_LIST_LINK = "//a[text()='back to customer list']";
	public static final String 	ICON_TO_OPEN_SEARCH = "//div[@class='card-body']//div[@class='icon-collapse']/i";
	public static final String 	REMOVE_REGISTER_BUTTON = "//ul[@id='SelectedCustomerRoleIds_taglist']//span[@class='k-select']";
	public static final String 	SEARCH_BUTTON = "//button[@id='search-customers']";
	public static final String 	VERIFY_INFO_CUSTOMER_IN_TABLE = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td//i[@class='fas fa-check %s-icon']";
	public static final String 	SHOW_ITEM_DROPDOWN = "//select[@name='customers-grid_length']";
	public static final String 	CLEAR_DROPDOWN = "//select[@name='customers-grid_length']//span[@class='k-icon k-clear-value k-i-close']";
	
 
}
