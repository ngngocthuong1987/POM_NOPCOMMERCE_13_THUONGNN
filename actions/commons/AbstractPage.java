package commons;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AbstractPage {

	public WebDriver driver;
	public Actions action;

	/**
	 * Open maxium browser with an Url
	 *
	 * @param url The url value need access
	*/
	public void openUrl(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public void back() {
		driver.navigate().back();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert() {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert() {
		return driver.switchTo().alert().getText();
	}

	public void sendKeyToAlert(String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public WebElement findElementByXpath(String locator) {
		return driver.findElement(By.xpath(locator));
	}

	public List<WebElement> findElementsByXpath(String locator){
		return driver.findElements(By.xpath(locator));
	}

	public void clickToElement(String locator) {
		findElementByXpath(locator).click();
	}

	public void sendKeyToElement(String locator, String value) {
		findElementByXpath(locator).sendKeys(value);
	}

	public int countElementNumber (String locator) {
		return findElementsByXpath(locator).size();
	}

	public String getAttributeElement(String locator, String attributeName) {
		return findElementByXpath(locator).getAttribute(attributeName);
	}

	public boolean isElementDisplay(String locator) {
		return findElementByXpath(locator).isDisplayed();
	}

	public void hoverMouseToElement(String locator) {
		action = new Actions(driver);
		action.moveToElement(findElementByXpath(locator)).perform();
	}
}
