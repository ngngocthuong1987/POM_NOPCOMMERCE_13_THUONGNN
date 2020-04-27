package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPagesFactory;

public class RegisterPageObject extends AbstractPagesFactory {

	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='gender-male']")
	private WebElement genderMaleRadio;

	@FindBy(how = How.XPATH, using = "//input[@id='FirstName']")
	private WebElement firstNameTextBox;

	@FindBy(how = How.XPATH, using = "//input[@id='LastName']")
	private WebElement lastNameTextBox;

	@FindBy(how = How.XPATH, using = "//select[@name='DateOfBirthDay']")
	private WebElement birthDaySelect;

	@FindBy(how = How.XPATH, using = "//select[@name='DateOfBirthMonth']")
	private WebElement birthMonthSelect;

	@FindBy(how = How.XPATH, using = "//select[@name='DateOfBirthYear']")
	private WebElement birthYearSelect;

	@FindBy(how = How.XPATH, using = "//input[@id='Email']")
	private WebElement emailTextBox;

	@FindBy(how = How.XPATH, using = "//input[@id='Password']")
	private WebElement passwordTextBox;

	@FindBy(how = How.XPATH, using = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextBox;

	@FindBy(how = How.XPATH, using = "//input[@id='register-button']")
	private WebElement registerButton;

	@FindBy(how = How.XPATH, using = "//input[@id='Company']")
	private WebElement companyTextBox;

	@FindBy(how = How.XPATH, using = "//div[@class='result' and text()='Your registration completed']")
	private WebElement registerSuccessLink;

	@FindBy(how = How.XPATH, using = "//a[@class='ico-logout' and text()='Log out']")
	private WebElement LogoutLink;


	public void selectMaleGender() {
		waitToElementClickable(driver, genderMaleRadio);
		clickToElement(driver, genderMaleRadio);
	}

	public void inputFistName(String value) {
		waitToElementDisplayed(driver, firstNameTextBox);
		sendKeyToElement(driver, firstNameTextBox, value);
	}

	public void inputLastName(String value) {
		waitToElementDisplayed(driver, firstNameTextBox);
		sendKeyToElement(driver, firstNameTextBox, value);
	}

	public void selectBirthDay(String valueItem) {
		waitToElementDisplayed(driver, birthDaySelect);
		selectItemInHtmlDropdown(driver, birthDaySelect, valueItem);
	}

	public void selectBirthMonth(String valueItem) {
		waitToElementDisplayed(driver, birthMonthSelect);
		selectItemInHtmlDropdown(driver, birthMonthSelect, valueItem);
	}

	public void selectBirthYear(String valueItem) {
		waitToElementDisplayed(driver, birthYearSelect);
		selectItemInHtmlDropdown(driver, birthYearSelect, valueItem);
	}

	public void inputEmail(String value) {
		waitToElementDisplayed(driver, emailTextBox);
		sendKeyToElement(driver, emailTextBox, value);

	}

	public void inputCompanyName(String value) {
		waitToElementDisplayed(driver, companyTextBox);
		sendKeyToElement(driver, companyTextBox, value);

	}

	public void inputPassword(String value) {
		waitToElementDisplayed(driver, passwordTextBox);
		sendKeyToElement(driver, passwordTextBox, value);

	}

	public void inputConfirmPassword(String value) {
		waitToElementDisplayed(driver, confirmPasswordTextBox);
		sendKeyToElement(driver, confirmPasswordTextBox, value);

	}

	public void clickRegisterButton() {
		waitToElementDisplayed(driver, registerButton);
		clickToElement(driver, registerButton);

	}

	public boolean isRegistSuccess() {
		return isElementDisplay(driver, registerSuccessLink);
	}

	public HomePageObject clickToLogOutLink() {
		waitToElementClickable(driver, LogoutLink);
		clickToElement(driver, LogoutLink);
		return new HomePageObject(driver);
	}

}
