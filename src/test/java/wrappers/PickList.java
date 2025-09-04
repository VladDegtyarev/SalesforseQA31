package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PickList {
    WebDriver driver;
    String label;

    public PickList(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String option) {
        WebElement element = driver.findElement(By.xpath(String.format("//label[text()='%s']//ancestor::lightning-picklist//button", label)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        WebElement opt = driver.findElement(By.xpath(String.format("//label[text()='%s']//ancestor::lightning-picklist//lightning-base-" +
                "combobox-item//span[text()='%s']", label, option)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", opt);
        opt.click();


    }
}
