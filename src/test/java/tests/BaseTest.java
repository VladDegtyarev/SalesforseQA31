package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.AccountPage;
import pages.LoginPage;
import pages.NewAccountModal;

import java.time.Duration;
import java.util.HashMap;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    NewAccountModal newAccountModal;
    LoginPage loginPage;
    AccountPage accountPage;

    @Parameters({"browser"})
    @BeforeMethod(description = "Настройка браузера", alwaysRun = true)
    public void setup(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("credentials_enable_service", false);
            chromePrefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", chromePrefs);
            options.addArguments("--incognito");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-infobars");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }
        newAccountModal = new NewAccountModal(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            AllureUtils.takeScreenshot(driver);
        }
        driver.quit();
    }
}
