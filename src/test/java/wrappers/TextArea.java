package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextArea {
    WebDriver driver;
    String label;

    public TextArea(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        WebElement element = driver.findElement(By.xpath(String.format("//label[text()='%s']//ancestor::lightning-textarea//textarea", label)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.sendKeys(text);
    }
}
