package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPagesFactory;

public class LoginPageObject extends AbstractPagesFactory {

	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='Email']")
	private WebElement emailTextBox;

	@FindBy(how = How.XPATH, using = "//input[@id='Password']")
	private WebElement passwordTextBox;

	@FindBy(how = How.XPATH, using = "//input[@value='Log in']")
	private WebElement loginButton;

	public void inputToEmailTextBox(String email) {
		waitToElementDisplayed(driver, emailTextBox);
		sendKeyToElement(driver, emailTextBox, email);
	}

	public void inputToPasswordTextBox(String password) {
		waitToElementDisplayed(driver, passwordTextBox);
		sendKeyToElement(driver, passwordTextBox, password);
	}

	public void clickToLoginButton() {
		waitToElementDisplayed(driver, loginButton);
		clickToElement(driver, loginButton);
	}

	public boolean isLoginSuccess() {
		return getCurrentUrl(driver).equals("https://demo.nopcommerce.com/");
	}

}
