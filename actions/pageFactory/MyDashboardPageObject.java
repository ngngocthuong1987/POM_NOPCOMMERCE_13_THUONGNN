package pageFactory;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.MyDashBoradPageUI;

public class MyDashboardPageObject extends AbstractPages {

	private WebDriver driver;

	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMyAccountLinkDisplayed(String value) {
		waitToElementDisplayed(driver, MyDashBoradPageUI.MY_ACCOUNT_LINK);
		return isElementDisplay(driver, MyDashBoradPageUI.MY_ACCOUNT_LINK);
	}
}
