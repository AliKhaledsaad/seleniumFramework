package tests;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests{

	public static WebDriver driver;
	protected String url="https://localhost:5001/";
	public static String  downloadPath = System.getProperty("user.dir")+"/Downloads";
	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome")String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webDriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("profile.default_content_setting_values.notifications", 2);

			// Disable popup blocking (optional)
			prefs.put("profile.default_content_settings.popups", 0);
			prefs.put("download.default_directory", downloadPath);
			// Disable translation popup
			prefs.put("translate_whitelists", new HashMap<String, String>());
			prefs.put("translate.enabled", false);
			prefs.put("autofill.profile_enabled", false);
	        prefs.put("autofill.address_enabled", false);
			option.setExperimentalOption("prefs", prefs);
			option.addArguments("--ignore-certificate-errors");
			option.addArguments("--allow-insecure-localhost");
			option.addArguments("--disable-web-security");
			option.addArguments("--disable-notifications");
			option.addArguments("--disable-popup-blocking");
			option.addArguments("--disable-infobars");
			option.addArguments("--disable-save-password-bubble");
			option.addArguments("--disable-blink-features=AutomationControlled");
			//option.addArguments("--disable-print-preview");
			option.addArguments("--kiosk-printing");
			driver = new ChromeDriver(option);
		}
		if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webDriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			FirefoxOptions option = new FirefoxOptions();
			option.setAcceptInsecureCerts(true);
			// Disable web security (optional, for mixed content testing)
			option.addPreference("security.csp.enable", false); // Disable Content Security Policy
			option.addPreference("network.websocket.allowInsecureFromHTTPS", true); // Allow insecure WebSocket
			option.addPreference("dom.security.https_only_mode", false); // Allow HTTP
			option.addPreference("browser.download.dir", downloadPath);
			option.addPreference("dom.security.https_only_mode_pbm", false); // Allow HTTP in
			driver = new FirefoxDriver(option);
		}
		if(browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"/drivers/msedgedriver.exe");
			EdgeOptions options = new EdgeOptions();
			// Ignore SSL certificate errors
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--allow-insecure-localhost");
			// Disable web security (optional for testing)
			options.addArguments("--disable-web-security");
			driver = new EdgeDriver(options);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.navigate().to(url);


	}

	@AfterSuite
	public void closeDriver()
	{
		driver.quit();
	}
	// will run after every test method
	@AfterMethod
	public void takingScreenshotOnFailure(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed..");
			System.out.println("Taking ScreenShot..");
			Helper.captureScreenshot(driver, result.getName());
		}
	}
}
