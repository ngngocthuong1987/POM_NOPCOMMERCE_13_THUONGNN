package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPagesFactory {

	public Actions action;
	public Select select;
	JavascriptExecutor jsExecutor;
	WebDriverWait waitExplicit;

	/**
	 * Open maxium browser with an Url
	 *
	 * @param url The url value need access
	 */
	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	/**
	 * Get the title of the current page.
	 */
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	/**
	 * Get the current URL that the browser is looking at
	 */
	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	/**
	 * Move back in the browser's history
	 */
	public void back(WebDriver driver) {
		driver.navigate().back();
	}

	/**
	 * Refresh the current page
	 */
	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	/**
	 * Click OK button in alert
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * Click Cancel button in alert
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * Get text in alert
	 */
	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	/**
	 * Input value into alert
	 */
	public void sendKeyToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public WebElement findElementByXpath(WebDriver driver, String locator) {
		return driver.findElement(byXpath(locator));
	}

	public List<WebElement> findElementsByXpath(WebDriver driver, String locator){
		return driver.findElements(byXpath(locator));
	}

	public By byXpath(String locator) {
		return By.xpath(locator);
	}

	public void clickToElement(WebElement element) {
		element.click();
	}

	public void sendKeyToElement(WebElement element, String value) {
		element.sendKeys(value);
	}

	public void selectItemInHtmlDropdown(WebElement element, String value) {
		select = new Select(element);
		select.selectByVisibleText(value);
	}

	public WebElement getSelectItemInHtmlDropdown(WebDriver driver, String locator) {
		select = new Select(findElementByXpath(driver, locator));
		return select.getFirstSelectedOption();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String dropdownLocator,
			String allItemInDropdownLocator,
			String expectedItemValue) throws InterruptedException {
		jsExecutor = (JavascriptExecutor) driver;
		waitExplicit = new WebDriverWait(driver, 30);

		// Click in dropdown for display all items
		WebElement paretnDropdown = findElementByXpath(driver, dropdownLocator);
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", paretnDropdown);
		Thread.sleep(2000);
		jsExecutor.executeScript("arguments[0].click();", paretnDropdown);
		Thread.sleep(2000);

		// Wait all items loaded
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXpath(allItemInDropdownLocator)));

		// Loop and get expected item
		List<WebElement> allItems = findElementsByXpath(driver, allItemInDropdownLocator);
		for (WebElement item : allItems) {
			if (item.getText().equals(expectedItemValue)) {
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				Thread.sleep(1000);
				item.click();
				break;
			}
		}
	}

	public String getAttributeValue(WebDriver driver, String locator, String attributeName) {
		return findElementByXpath(driver, locator).getAttribute(attributeName);
	}

	public String getTextElement(WebDriver driver, String locator) {
		return findElementByXpath(driver, locator).getText();
	}

	public int countElementNumber(WebDriver driver, String locator) {
		return findElementsByXpath(driver, locator).size();
	}

	public boolean isElementDisplay(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return findElementByXpath(driver, locator).isSelected();
	}

	public boolean isElementEnabled(WebDriver driver, String locator) {
		return findElementByXpath(driver, locator).isEnabled();
	}

	/**
	 * Switch to another window by page tile
	 *
	 * @param title The title of window need switch
	 */
	public void switchToWindowByTile(WebDriver driver, String title) {
		Set<String> allWindow = driver.getWindowHandles();
		for (String runWindow : allWindow) {
			driver.switchTo().window(runWindow);
			if (driver.getTitle().equals(title)) {
				break;
			}
		}
	}

	/**
	 * Close all window with out parrent window
	 *
	 * @param parrentWindowTitle The title of parent window
	 */
	public void closeAllWindowsWithoutParent(WebDriver driver, String parrentWindowTitle) {
		Set<String> allWindow = driver.getWindowHandles();
		for (String runWindow : allWindow) {
			if (!runWindow.equals(parrentWindowTitle)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
	}

	public void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(findElementByXpath(driver, locator));
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(findElementByXpath(driver, locator)).perform();
	}

	public void hoverMouseToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(findElementByXpath(driver, locator)).perform();
	}

	public void rightClick(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(findElementByXpath(driver, locator)).perform();
	}

	public void dragAndDrop(WebDriver driver, String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(findElementByXpath(driver, sourceLocator), findElementByXpath(driver, targetLocator)).perform();
	}

	public void sendKeyboardToElement(WebDriver driver, String locator, String value) {
		action = new Actions(driver);
		action.sendKeys(findElementByXpath(driver, locator), value).perform();
	}

	public void waitToElementClickable(WebDriver driver, WebElement element) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitToElementDisplayed(WebDriver driver, WebElement element) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOf(element));
	}
}
