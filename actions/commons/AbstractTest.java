package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class AbstractTest {
	private WebDriver driver;

	public WebDriver getBrowser(String browserName) {
		if ("firefox".equalsIgnoreCase(browserName)) {
			System.setProperty("webdriver.gecko.driver", ".//libraries//geckodriver.exe");
			driver = new FirefoxDriver();
		} else if ("headless_firefox".equalsIgnoreCase(browserName)) {
			System.setProperty("webdriver.gecko.driver", ".//libraries//geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);
		} else if ("chrome".equalsIgnoreCase(browserName)) {
			System.setProperty("webdriver.chrome.driver", ".//libraries//chromedriver.exe");
			driver = new ChromeDriver();
		} else if ("headless_chrome".equalsIgnoreCase(browserName)) {
			System.setProperty("webdriver.chrome.driver", ".//libraries//chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		}

		driver.get(Constants.URL);
		driver.manage().window().maximize();
		return driver;
	}
}
