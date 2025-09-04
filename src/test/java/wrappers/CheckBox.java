package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox {
    WebDriver driver;
    String label;

    public CheckBox(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select() {
        WebElement element = driver.findElement(By.xpath(
                String.format("//*[text()='%s']//ancestor::lightning-input//input", label)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }
}
