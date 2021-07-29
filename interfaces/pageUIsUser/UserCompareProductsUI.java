package pageUIsUser;

public class UserCompareProductsUI {
	public static final String COMPUTER_LINK="//ul[@class='top-menu notmobile']//li[1]//a[text()='Computers ']";
	public static final String NOTEBOOK_LINK="//ul[@class='top-menu notmobile']//a[text()='Notebooks ']";
	public static final String ADD_TO_COMPARE_LIST_BUTTON_BY_NAME="//div[@class='center-2']//a[text()='%s']/parent::h2/following-sibling::div[@class='add-info']//button[text()='Add to compare list']";
	public static final String COMPARE_PRODUCTS_LIST_LINK="//div[@class='footer']//a[text()='Compare products list']";
	public static final String ROW_INDEX_BY_TITLE="//label[text()='%s']/parent::td/parent::tr/preceding-sibling::tr";
	public static final String COLUMN_INDEX="//td[text()='%s']/preceding-sibling::td";
	public static final String COLUMN_INDEX_BY_NAME="//a[text()='%s']/parent::td/preceding-sibling::td";
	public static final String GET_TEXT_BY_ROWINDEX_AND_COLUMN="//tr[%s]//td[%s]";//hang truwoc cot sau
	public static final String ICON_LOADING = "//div[@id='ajaxBusy']/span";
	public static final String CLEAR_LIST_BUTTON = "//a[text()='Clear list']";
	public static final String MESSAGE_NO_DATA = "//div[@class='no-data']";
	public static final String INFO_PRODUCT = "//a[text()='%s']/parent::h2/following-sibling::div[@class='add-info']//span[text()='%s']";
	public static final String RECENTLY_VIEW_LINK = "//a[text()='Recently viewed products']";
	public static final String COUNT_PRODUCTS = "//div[@class='item-box']";
}
