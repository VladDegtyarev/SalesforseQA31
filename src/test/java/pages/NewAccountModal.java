package pages;

import dto.Account;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import wrappers.CheckBox;
import wrappers.Input;
import wrappers.PickList;
import wrappers.TextArea;
@Log4j2
public class NewAccountModal extends BasePage {
    private final By SAVE_BUTTON = By.xpath("//*[@name='SaveEdit']");

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы New Account")
    public NewAccountModal open() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/new");
        return this;
    }

    @Step("Страница New Account открыта")
    public NewAccountModal isPageOpen(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='New Account']")));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Page isn't opened");
        }
        return this;
    }

    @Step("Создание нового аккаунта")
    public NewAccountModal createAccount
            (Account account) {
        new Input(driver, "Account Name").write(account.getName());
        new Input(driver, "Phone").write(account.getPhone());
        new Input(driver, "Fax").write(account.getFax());
        new Input(driver, "Website").write(account.getWebSite());
        new PickList(driver, "Rating").select(account.getRating());
        new PickList(driver, "Industry").select(account.getIndustry());
        new CheckBox(driver, "TeachMeSkills").select();
        new CheckBox(driver, "VIP Client").select();
        new TextArea(driver, "Billing Street").write(account.getStreet());
        new Input(driver, "Billing City").write(account.getCity());
        new Input(driver, "Billing Zip/Postal Code").write(account.getZipCode());
        new PickList(driver, "Customer Priority").select(account.getPriority());
        new Input(driver, "Number of Locations").write(account.getLocationNumber());
        new PickList(driver, "Upsell Opportunity").select(account.getOpportunity());

        return this;
    }

    @Step("Сохранение аккаунта")
    public AccountPage saveAccount(){
        driver.findElement(SAVE_BUTTON).click();
        return new AccountPage(driver);
    }
}
