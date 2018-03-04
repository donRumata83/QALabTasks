package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class Page {
    WebDriver driver;
    WebDriverWait waiter;
    By userIcon = By.className("img-thumbnail");
    By logout = By.id("header_logout");
    By logo = By.id("header_logout");
    By catalogLogo = By.className("logo pull-left");

    Page(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(driver, 10);
    }

    boolean isElementpresent(By element) {
        return driver.findElements(element).size() > 0;
    }

    public LoginPage logout() {
        driver.findElement(userIcon).click();
        driver.findElement(logout).click();
        return new LoginPage(driver);
    }

    void waitForLoad() {
        waiter.until(ExpectedConditions.presenceOfElementLocated(logo));
    }
}

