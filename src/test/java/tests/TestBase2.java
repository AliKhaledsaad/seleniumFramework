package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase2 extends AbstractTestNGCucumberTests {

    protected ThreadLocal<RemoteWebDriver> driver=null;
	public static String  downloadPath = System.getProperty("user.dir")+"/Downloads";

    protected String url = "https://localhost:59579/";

    @BeforeTest
    @Parameters("browser")
    public void startDriver(@Optional("chrome") String browser) throws MalformedURLException {
        driver = new ThreadLocal<>();
    	if (browser.equalsIgnoreCase("chrome")) {
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
            driver.set(new RemoteWebDriver(new URL("http://localhost:4444"),option));
        } else if (browser.equalsIgnoreCase("firefox")) {
        	FirefoxOptions option = new FirefoxOptions();
			option.setAcceptInsecureCerts(true);
			// Disable web security (optional, for mixed content testing)
			option.addPreference("security.csp.enable", false); // Disable Content Security Policy
			option.addPreference("network.websocket.allowInsecureFromHTTPS", true); // Allow insecure WebSocket
			option.addPreference("dom.security.https_only_mode", false); // Allow HTTP
			option.addPreference("browser.download.dir", downloadPath);
			option.addPreference("dom.security.https_only_mode_pbm", false); // A
            driver.set(new RemoteWebDriver(new URL("http://localhost:4444"), option));
        }
        getDriver().manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        getDriver().navigate().to(url);
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    @AfterClass
    public void closeDriver() {
        if (driver != null) {
            getDriver().quit();
        }
    }

    @AfterMethod
    public void takingScreenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed.. Taking ScreenShot..");
            Helper.captureScreenshot(getDriver(), result.getName());
        }
    }
}
