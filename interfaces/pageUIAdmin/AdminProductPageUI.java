package pageUIAdmin;

public class AdminProductPageUI {
	public static final String ICON_LOADING = "//div[@id='ajaxBusy']/span";
	public static final String ALL_CHECKBOX = "//th/input[@class='mastercheckbox']";
	public static final String ALL_PRODUCTS = "//input[@name='checkbox_products']";
	public static final String PAGE_INDEX_TABLE = "//ul[@class='pagination']//a[text()='%s']";
	public static final String CHECK_PAGE_INDEX_TABLE = "//li[@class='paginate_button page-item active']/a[text()='%s']";
	public static final String NUMBER_PRODUCT_DROPDOWN = "//select[@name='products-grid_length']";
	public static final String 	COLUMN_NAME = "//th[text()='%s']/preceding-sibling::th";
	public static final String 	CELL_BY_COLUMN_NAME_AND_ROW_INDEX = "//tr[%s]//td[%s]";
	public static final String 	PUBLIC_STATUS_BY_COLUMN_NAME_AND_ROW_INDEX = "//tr[%s]/td[%s]/i[contains(@class,'%s-icon')]";
	public static final String 	PRODUCT_IN_ROW_TABLE = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']";
	public static final String 	PRODUCT_NAME_SEARCH = "//input[@id='SearchProductName']";
	public static final String 	SEARCH_BUTTON = "//button[@id='search-products']";
	public static final String 	EDIT_BUTTON = "//td[text()='%s']/following-sibling::td[@class=' button-column']/a";
	public static final String 	PICTURE_PANEL = "//div[@id='product-pictures']";
	public static final String 	ICON_HIDE_OR_SHOW = "//div[@id='product-pictures']//button[@class='btn btn-tool']/i";
	public static final String 	UPLOAD_FILE_INPUT = "//div[@id='%s']//input[@type='file']";
	public static final String 	ALT_TEXTBOX = "//input[@id='AddPictureModel_OverrideAltAttribute']";
	public static final String 	TITLE_TEXTBOX = "//input[@id='AddPictureModel_OverrideTitleAttribute']";
	public static final String 	DISPLAY_ORDER = "//div[@id='product-pictures']//input[@class='k-formatted-value k-input']";
	public static final String 	ADD_PRODUCT_PICTURE_BUTTON = "//button[@id='addProductPicture']";
	public static final String 	ICON_LOADING_PICTURE = "//span[@class='qq-upload-spinner-selector qq-upload-spinner']";
	

}
