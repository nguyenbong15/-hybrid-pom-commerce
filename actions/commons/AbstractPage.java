package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


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
		explicitWait = new WebDriverWait(driver, 30);
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

	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public void clickToElement(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		element.click();
	}

	public void senkeyToElement(WebDriver driver,String locator, String value) {
		element = getElement(driver, locator);
		element.clear();
		element.sendKeys(value);
	}
	public String getTextElement(WebDriver driver,String locator) {
		element = getElement(driver, locator);
	return	element.getText();
		
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String itemValue) {
		element = getElement(driver, locator);
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
		explicitWait = new WebDriverWait(driver, 30);
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

	public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		element = getElement(driver, locator);
		return element.getAttribute(attributeName);
	}



	public int countElementSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
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

	public void scrollToElement(String locator, WebDriver driver) {
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
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));

	}

	public void waitToElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));

	}

	public void waitToElementclickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));

	}

	private WebDriverWait explicitWait;
	private JavascriptExecutor js;
	private WebElement element;
	private Actions action;
	private Select select;
	private List<WebElement> elements;

}
