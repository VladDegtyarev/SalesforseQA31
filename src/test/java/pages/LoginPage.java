package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class LoginPage extends BasePage {
    private final By USERNAME_INPUT = By.id("username");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.id("Login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы Login Page")
    public void open() {
        driver.get(BASE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        log.info("Opening Login Page");
    }

    @Step("Вход в в аккаунт")
    public void login() {
        driver.findElement(USERNAME_INPUT).sendKeys("tborodich@tms.sandbox");
        driver.findElement(PASSWORD_INPUT).sendKeys("Password003!");
        driver.findElement(LOGIN_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".uiImage")));
    }
}
