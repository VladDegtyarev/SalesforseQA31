package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
@Log4j2
public class AccountListPage extends BasePage{
    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountListPage isPageOpen() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='New']")));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Page isn't opened");
        }
        return this;
    }

    public AccountListPage open (){
        driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/list");
        return this;
    }

    public NewAccountModal clickNew(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='New']")));
        driver.findElement(By.xpath("//a[@title='New']")).click();
        return new NewAccountModal(driver);
    }
}
