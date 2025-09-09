package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
@Log4j2
public class MainPage extends BasePage{
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainPage isPageOpen(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".uiImage")));
        } catch (TimeoutException e) {
            log.error(e.getMessage());
            Assert.fail("Page isn't opened");
        }
        return this;
    }
}
