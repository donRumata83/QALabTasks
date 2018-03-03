package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    protected WebDriver driver;
    protected WebDriverWait waiter;

    Page(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(driver, 10);

    }

    boolean isElementpresent(By element) {
        return driver.findElements(element).size() > 0;
    }
}

