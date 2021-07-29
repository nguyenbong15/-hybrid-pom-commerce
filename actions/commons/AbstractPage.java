package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjectsUsers.PageGenerator;
import pageObjectsUsers.UserAddressesPO;
import pageObjectsUsers.UserChangePasswordPO;
import pageObjectsUsers.UserCustomerInfoPO;
import pageObjectsUsers.UserMyProductReviewPO;
import pageObjectsUsers.UserOrderInCustomerInfoPO;
import pageObjectsUsers.UserOrderPagePO;
import pageObjectsUsers.UserSearchPagePO;
import pageObjectsUsers.UserWishlistPagePO;
import pageUIAdmin.AdminProductPageUI;
import pageUIsUser.AbstracPageUI;
import pageUIsUser.UserCustomerInfoPageUI;

public class AbstractPage {

	public void openPageUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getCurrentPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void fowardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void setTextAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public void waitAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, GlobalConsarts.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindow = driver.getWindowHandles();
		for (String runWindow : allWindow) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindow = driver.getWindowHandles();
		for (String runWindow : allWindow) {
			driver.switchTo().window(runWindow);
			String titleCurrentWindow = driver.getTitle();

			if (titleCurrentWindow.equals(title)) {
				break;
			}
		}

	}

	public boolean closeAllWindowWithoutParentWin(WebDriver driver, String parent) {
		Set<String> allWindow = driver.getWindowHandles();
		for (String runWindow : allWindow) {
			if (!runWindow.equals(parent)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;

	}

	public WebElement getElement(WebDriver driver, String locator) {

		return driver.findElement(getByXpath(locator));
	}

	public List<WebElement> getElements(WebDriver driver, String locator) {

		return driver.findElements(getByXpath(locator));
	}
	public List<WebElement> getElements(WebDriver driver, String locator,String... values ) {

		return driver.findElements(getByXpath(getDynammicLocator(locator, values)));
	}

	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public void clickToElement(WebDriver driver, String locator) {
		if (driver.toString().toLowerCase().contains("edge")) {
			sleepMiliSecond(500);
		}
		element = getElement(driver, locator);
		element.click();
	}

	public void senkeyToElement(WebDriver driver, String locator, String value) {

		element = getElement(driver, locator);
		element.clear();
		if (driver.toString().toLowerCase().contains("edge") || driver.toString().toLowerCase().contains("chrome")) {
			sleepMiliSecond(500);
		}
		element.sendKeys(value);
	}

	public String getTextElement(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		return element.getText();
		
	}
	public String getTextElement(WebDriver driver, String locator,String... values) {
		element = getElement(driver, getDynammicLocator(locator, values));
		return element.getText();

	}

	public void selectItemInDropdown(WebDriver driver, String locator, String itemValue) {
		element = getElement(driver, locator);
		select = new Select(element);
		select.selectByVisibleText(itemValue);
	}
	public void selectItemInDropdown(WebDriver driver, String locator, String itemValue,String...values) {
		element = getElement(driver, getDynammicLocator(locator, values));
		select = new Select(element);
		select.selectByVisibleText(itemValue);
	}

	public String getFirstSelectedTextInDropdown(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMutiple(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		select = new Select(element);
		return select.isMultiple();
	}

	public void selectItemsInCustomDropdown(WebDriver driver, String parentLocator, String childItemsLocator,
			String expectedItem) {
		explicitWait = new WebDriverWait(driver, GlobalConsarts.LONG_TIMEOUT);
		getElement(driver, parentLocator).click();
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemsLocator)));
		elements = getElements(driver, childItemsLocator);
		for (WebElement x : elements) {
			if (x.getText().equals(expectedItem)) {
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", x);
				sleepSecond(1);
				x.click();
				sleepSecond(1);
				break;
			}
		}
	}

	public void sleepSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void sleepMiliSecond(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getAttributeElement(WebDriver driver, String locator, String attributeName) {
		element = getElement(driver, locator);
		return element.getAttribute(attributeName);
	}
	public String getAttributeElement(WebDriver driver, String locator, String attributeName,String... classTexbox) {
		element = getElement(driver, getDynammicLocator(locator, classTexbox));
		return element.getAttribute(attributeName);
	}

	public int countElementSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}
	public int countElementSize(WebDriver driver, String locator,String... values) {
		return getElements(driver, getDynammicLocator(locator, values)).size();
	}

	public void checkToCheckbox(WebDriver driver, String locator) {

		WebElement element = getElement(driver, locator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToCheckbox(WebDriver driver, String locator) {

		WebElement element = getElement(driver, locator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {

		return getElement(driver, locator).isDisplayed();
	}

	public boolean isElementDisplayed(WebDriver driver, String locator, String... values) {

		return getElement(driver, getDynammicLocator(locator, values)).isDisplayed();
	}

	public boolean isElementEnabled(WebDriver driver, String locator) {

		return getElement(driver, locator).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {

		return getElement(driver, locator).isSelected();
	}

	public void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(getElement(driver, locator));
	}

	public void switchToDefaulContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(getElement(driver, locator)).perform();

	}

	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(getElement(driver, locator)).perform();

	}

	public void hoverMouseToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();

	}

	public void clickAndHoverToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.clickAndHold(getElement(driver, locator)).perform();

	}

	public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();

	}

	public void senkeysBoardToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();
	}

	public void highlightElement(WebDriver driver, String locator) {
		js = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");

		js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2]", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepSecond(1);
		js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2]", element, "style", originalStyle);

	}

	public Object excecutorForBrower(String javaScript, WebDriver driver) {
		js = (JavascriptExecutor) driver;
		return js.executeScript(javaScript);
	}

	public void scrollToElement( WebDriver driver,String locator) {
		js = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public boolean verifyTextInInnerText(String textExpected, WebDriver driver) {
		js = (JavascriptExecutor) driver;
		String textActual = (String) js
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		System.out.println("Text actual =" + textActual);
		return textActual.equals(textExpected);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		js = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		js.executeScript("arguments[0].click();", element);
	}

	public void sendkeyToElementByJS(String locator, String value, WebDriver driver) {
		js = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		js.executeScript("arguments[0].setAttribute('value','" + value + "')", element);
	}

	public void scrollToBottomPage(WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void removeAttributeInDom(String attributeRemove, WebDriver driver, String locator) {
		js = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		js.executeScript("arguments[0].removeAttribute('" + attributeRemove + "'", element);
	}

	public void navigateToUrlByJS(String url, WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.location='" + url + "'");
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {

		js = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		element = getElement(driver, locator);
		boolean status = (boolean) js.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				element);
		if (status) {
			return true;
		}
		return false;
	}

	public void waitToElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConsarts.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));

	}
	public void waitToAllElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConsarts.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));

	}
	public void waitToAjaxLoading(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConsarts.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));

	}

	public void waitToElementVisible(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConsarts.LONG_TIMEOUT);
		explicitWait
				.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynammicLocator(locator, values))));

	}

	public void waitToElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConsarts.SHORT_TIMEOUT);
		overideImplicitWait(driver, GlobalConsarts.SHORT_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
		overideImplicitWait(driver, GlobalConsarts.LONG_TIMEOUT);
	}
	public boolean waitToElementStaleness(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConsarts.SHORT_TIMEOUT);
		overideImplicitWait(driver, GlobalConsarts.SHORT_TIMEOUT);
	return	explicitWait.until(ExpectedConditions.stalenessOf(getElement(driver, locator)));
		//overideImplicitWait(driver, GlobalConsarts.LONG_TIMEOUT);
	}
	
  
	public void waitToElementclickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConsarts.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));

	}

	public void waitToElementclickable(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConsarts.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynammicLocator(locator, values))));

	}

	public void clickToElement(WebDriver driver, String locator, String... values) {
		if (driver.toString().toLowerCase().contains("edge")) {
			sleepMiliSecond(500);
		}
		element = getElement(driver, getDynammicLocator(locator, values));
		element.click();
	}

	public void senkeyToElement(WebDriver driver, String locator, String value, String... values) {

		element = getElement(driver, getDynammicLocator(locator, values));
		element.clear();
		if (driver.toString().toLowerCase().contains("edge") || driver.toString().toLowerCase().contains("chrome")) {
			sleepMiliSecond(500);
		}
		element.sendKeys(value);
	}

	public String getDynammicLocator(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		return locator;
	}

	public UserAddressesPO openAddressesPage(WebDriver driver) {
		waitToElementclickable(driver, AbstracPageUI.ADDRESSES_LINK);
		clickToElement(driver, AbstracPageUI.ADDRESSES_LINK);
		return PageGenerator.getUserAddressesPage(driver);
	}
	public UserChangePasswordPO openChangePasswordPage(WebDriver driver) {
		waitToElementclickable(driver, AbstracPageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, AbstracPageUI.CHANGE_PASSWORD_LINK);
		return PageGenerator.getChangePasswordPage(driver);
	}

	public UserCustomerInfoPO openCustomerInfoPage(WebDriver driver) {
		waitToElementclickable(driver, AbstracPageUI.CUSTOMER_INFO_LINK);
		clickToElement(driver, AbstracPageUI.CUSTOMER_INFO_LINK);
		return PageGenerator.getUserCustomerInfoPage(driver);
	}

	public UserOrderInCustomerInfoPO openOrderInCustomerPage(WebDriver driver) {
		waitToElementclickable(driver, AbstracPageUI.ORDER_LINK);
		clickToElement(driver, AbstracPageUI.ORDER_LINK);
		return PageGenerator.getUserOrderPage(driver);
	}

	public UserMyProductReviewPO openMyProductReviewPage(WebDriver driver) {
		waitToElementclickable(driver, AbstracPageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, AbstracPageUI.MY_PRODUCT_REVIEW_LINK);
		return PageGenerator.getUserMyProductReviewPage(driver);
	}
	public UserSearchPagePO openSearchPage(WebDriver driver) {
		waitToElementclickable(driver, AbstracPageUI.SEARCH_LINK_FOOTER);
		clickToElement(driver, AbstracPageUI.SEARCH_LINK_FOOTER);
		return PageGenerator.getSearchPage(driver);
	}
	
	
	public UserWishlistPagePO openWishlistPage(WebDriver driver) {
		   
		waitToElementVisible(driver, AbstracPageUI.COMPUTER_LINK);
        clickAndHoverToElement(driver, AbstracPageUI.COMPUTER_LINK);
        waitToElementclickable(driver, AbstracPageUI.DESKTOP_LINK);
        clickToElement(driver, AbstracPageUI.DESKTOP_LINK);
		return PageGenerator.getWishlistPage(driver);
	}

	public AbstractPage openLinkByPageName(WebDriver driver, String pageName) {
		waitToElementclickable(driver, AbstracPageUI.DYNAMIC_LOCATOR, pageName);
		clickToElement(driver, AbstracPageUI.DYNAMIC_LOCATOR, pageName);
		switch (pageName) {
		case "Addresses":
			return PageGenerator.getUserAddressesPage(driver);
		case "Customer info":
			return PageGenerator.getUserCustomerInfoPage(driver);
		case "My product reviews":
			return PageGenerator.getUserMyProductReviewPage(driver);

		default:
			return PageGenerator.getUserOrderPage(driver);
		}

	}
	
	public void openLinkWithPageName(WebDriver driver, String pageName) {
		waitToElementclickable(driver, AbstracPageUI.DYNAMIC_LOCATOR, pageName);
		clickToElement(driver, AbstracPageUI.DYNAMIC_LOCATOR, pageName);
		
	}

	public void waitToElementPresent(WebDriver driver, String locator,int number) {
		explicitWait = new WebDriverWait(driver, GlobalConsarts.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.numberOfElementsToBe(getByXpath(locator),number));

	}
	public void upLoadFilePicture( WebDriver driver,String panelID,String... fileName) {

		String filePath=GlobalConsarts.UPLOAD_FOLDER;
		String fullFileName="";
		for (String file : fileName) {
			fullFileName = fullFileName + filePath + file + "\n";
			
		}
		fullFileName.trim();
		System.out.println(fullFileName);
		senkeyToElement(driver, AdminProductPageUI.UPLOAD_FILE_INPUT, fullFileName, panelID);
		System.out.println(getDynammicLocator(AdminProductPageUI.UPLOAD_FILE_INPUT, panelID));
		waitToElementInvisible(driver, AdminProductPageUI.ICON_LOADING_PICTURE);
	}
	public boolean isElementUnDisplayed(WebDriver driver,String locator) {
		overideImplicitWait(driver,  GlobalConsarts.SHORT_TIMEOUT);
		elements=getElements(driver, locator);
		overideImplicitWait(driver,  GlobalConsarts.LONG_TIMEOUT);
		
		if(elements.size()==0) {//element k cos tren ui vaf dom
			return true;
		}else if(elements.size()>0 && !elements.get(0).isDisplayed())//k co tren ui vaf co trong dom( hamf isDisplayed van sdung cho element cos trong dom
		{
			return true;
		}else {
			return false;
		}
		
	}
	public void overideImplicitWait(WebDriver driver,long timeSecond) {
		driver.manage().timeouts().implicitlyWait(timeSecond, TimeUnit.SECONDS);
	}
	

	private WebDriverWait explicitWait;
	private JavascriptExecutor js;
	private WebElement element;
	private Actions action;
	private Select select;
	private List<WebElement> elements;

}
