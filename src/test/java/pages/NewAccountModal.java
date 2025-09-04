package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wrappers.CheckBox;
import wrappers.Input;
import wrappers.PickList;
import wrappers.TextArea;

public class NewAccountModal extends BasePage {
    private final By SAVE_BUTTON = By.xpath("//*[@name='SaveEdit']");

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы New Account")
    public void open() {
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/new");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='New Account']")));
    }

    public void createAccount
            (String name, String phone, String fax, String webSite,
             String rating, String industry, String street, String city, String zipCode,
             String priority, String locationNumber, String opportunity) {
        new Input(driver, "Account Name").write(name);
        new Input(driver, "Phone").write(phone);
        new Input(driver, "Fax").write(fax);
        new Input(driver, "Website").write(webSite);
        new PickList(driver, "Rating").select(rating);
        new PickList(driver, "Industry").select(industry);
        new CheckBox(driver, "TeachMeSkills").select();
        new CheckBox(driver, "VIP Client").select();
        new TextArea(driver, "Billing Street").write(street);
        new Input(driver, "Billing City").write(city);
        new Input(driver, "Billing Zip/Postal Code").write(zipCode);
        new PickList(driver, "Customer Priority").select(priority);
        new Input(driver, "Number of Locations").write(locationNumber);
        new PickList(driver, "Upsell Opportunity").select(opportunity);
        driver.findElement(SAVE_BUTTON).click();
    }
}
