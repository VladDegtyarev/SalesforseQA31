package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountPage isPageOpen() {
        return null;
    }

    public void checkAccount(String name, String phone) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.findElement
                (By.xpath("//*[@name='primaryField']//descendant::*[@slot='primaryField']")).getText(), name);
        softAssert.assertEquals(driver.findElement
                (By.xpath("//*[@class='fieldComponent slds-text-body--regular slds-show_inline-block']" +
                        "//descendant::lightning-formatted-phone")).getText(), phone);
        softAssert.assertAll();
    }
}
