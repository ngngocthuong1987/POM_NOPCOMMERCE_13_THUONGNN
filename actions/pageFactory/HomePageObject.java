package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPagesFactory;


public class HomePageObject extends AbstractPagesFactory {

	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='ico-login' and text()='Log in']")
	private WebElement loginLink;

	@FindBy(how = How.XPATH, using = "//a[@class='ico-register' and text()='Register']")
	private WebElement registerLink;

	public LoginPageObject clickToLoginPage() {
		waitToElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
		return new LoginPageObject(driver);
	}

	public RegisterPageObject clickToRegisterPage() {
		waitToElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
		return new RegisterPageObject(driver);
	}

}
