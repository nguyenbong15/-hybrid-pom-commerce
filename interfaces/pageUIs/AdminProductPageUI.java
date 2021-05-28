package pageUIs;

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

}
